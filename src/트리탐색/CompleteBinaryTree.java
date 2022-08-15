package 트리탐색;

/*
마지막 노드 높이 바로 위 노드는 꽉 차있어야 하고,
마지막 줄의 노드들은 왼쪽부터 차례로 채워져야 함
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree {
    private char[] nodes;
    private int lastIdx;
    private final int SIZE;


    // 좌측자식 - 우측자식 - 나 처리
    public void dfsByPostOrder(int currentIdx) {
        // 바뀌는것: 탐색할 대상

        if (currentIdx > lastIdx) {
            return;
        }

        dfsByPostOrder(currentIdx * 2);
        dfsByPostOrder(currentIdx * 2 + 1);

        System.out.print(nodes[currentIdx] + " "); // 방문시 해야 할 일 처리

    }

    // 좌측자식 - 나 - 우측자식 처리
    public void dfsByInOrder(int currentIdx) {
        // 바뀌는것: 탐색할 대상

        if (currentIdx > lastIdx) {
            return;
        }

        dfsByInOrder(currentIdx * 2);
        System.out.print(nodes[currentIdx] + " "); // 방문시 해야 할 일 처리
        dfsByInOrder(currentIdx * 2 + 1);

    }

    // 나 - 좌측자식 - 우측자식 처리
    public void dfsByPreOrder(int currentIdx) { // dfs 가면서 노드 만날때 마다 처리

        System.out.print(nodes[currentIdx] + " "); // 방문시 해야 할 일 처리
        // 바뀌는것: 탐색할 대상
        if (currentIdx * 2 <= lastIdx) { // 왼쪽 자식 있다면
            dfsByPreOrder(currentIdx * 2);
        }
        if (currentIdx * 2 + 1 <= lastIdx) { // 오른쪽 자식 있다면
            dfsByPreOrder(currentIdx * 2 + 1);
        }
    }

    public void bfs2() {
        Queue<Integer> queue = new LinkedList<Integer>(); // 큐에 인덱스를 넣을것
        queue.offer(1); // 루트 노드 인덱스부터 (1 인덱스 부터 사용)

        while (!queue.isEmpty()) { // 방문 대상이 있을때까지 반복
            int curQ_Size = queue.size(); // 현재 높이의 큐 사이즈 가져오기
            while (--curQ_Size >= 0) { // 현재 큐 사이즈 만큼만 돈다
                int current = queue.poll(); // 방문 차례인 대상 정보 꺼내기
                System.out.print(nodes[current] + " ");

                // 현재 방문 노드의 자식 노드들을 대기열에 넣기
                if (current * 2 <= lastIdx) {
                    queue.offer(current * 2); // 왼쪽자식 넣기
                }
                if (current * 2 + 1 <= lastIdx) {
                    queue.offer(current * 2 + 1); // 오른쪽 자식 넣기
                }

            }System.out.println();
        }
        System.out.println();

    }

    public void dfs() {
        Stack<Integer> stack = new Stack<>(); // 큐에 인덱스를 넣을것
        stack.push(1); // 루트 노드 인덱스부터 (1 인덱스 부터 사용)

        while (!stack.isEmpty()) { // 방문 대상이 있을때까지 반복
            int current = stack.pop(); // 방문 차례인 대상 정보 꺼내기
            System.out.print(nodes[current] + " ");

            // 현재 방문 노드의 자식 노드들을 대기열에 넣기
            if (current * 2 <= lastIdx) {
                stack.push(current * 2); // 왼쪽자식 넣기
            }
            if (current * 2 + 1 <= lastIdx) {
                stack.push(current * 2 + 1); // 오른쪽 자식 넣기
            }
        }
        System.out.println();

    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>(); // 큐에 인덱스를 넣을것
        queue.offer(1); // 루트 노드 인덱스부터 (1 인덱스 부터 사용)

        while (!queue.isEmpty()) { // 방문 대상이 있을때까지 반복
            int current = queue.poll(); // 방문 차례인 대상 정보 꺼내기
            System.out.print(nodes[current] + " ");

            // 현재 방문 노드의 자식 노드들을 대기열에 넣기
            if (current * 2 <= lastIdx) {
                queue.offer(current * 2); // 왼쪽자식 넣기
            }
            if (current * 2 + 1 <= lastIdx) {
                queue.offer(current * 2 + 1); // 오른쪽 자식 넣기
            }
        }
        System.out.println();

    }

    public boolean add(char c) { // 완전 이진트리에 맞게 추가
        if (lastIdx == SIZE) {
            return false;
        }
        nodes[++lastIdx] = c;
        return true;
    }

    public CompleteBinaryTree(int size) {
        SIZE = size;
        nodes = new char[size + 1]; // 1 인덱스 부터 사용
    }
}
