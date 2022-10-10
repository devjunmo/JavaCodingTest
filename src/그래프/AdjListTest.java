package 그래프;

import java.util.Scanner;

public class AdjListTest {

    static int N;
    static boolean[] visited;
    static Node[] adjList;

    static class Node{
        int to;
        Node next;
//        int weight;

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점 수
        int E = sc.nextInt(); // 간선 수

        adjList = new Node[N]; // Node type으로 N개짜리 배열. Head 배열이다..

        // 간선 정보에 해당하는 부분만 덮어 씀
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            // from의 인접 리스트에다가 to 정보를 저장
            // 맨 앞에다가 집어넣는 방식으로 달기
            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
        }

        dfs(0);

    }

    private static void dfs(int cur) {
        visited[cur] = true;
        System.out.print((char) (cur + 'A')); // 알파벳으로 찍기

        // 한 정점의 인접 정점들을 큐에 넣어서 차후 탐색하도록 만들기
        for (Node tmp = adjList[cur]; tmp != null; tmp = tmp.next) {
            if (!visited[tmp.to]) { // 방문 x
                dfs(tmp.to); // 방문하지 않았으면 걔한테 간다..
            }
        }
    }
}
