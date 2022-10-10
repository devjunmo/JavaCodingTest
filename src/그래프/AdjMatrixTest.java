package 그래프;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {

    static int[][] adjMatrix;
    static int N;

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점 수
        int E = sc.nextInt(); // 간선 수

        adjMatrix = new int[N][N];
        visited = new boolean[N];

        // 간선 정보에 해당하는 부분만 덮어 씀
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            // 무향 그래프
            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1;
        }

        bfs();
//        dfs(0);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        System.out.print((char) (cur + 'A')); // 알파벳으로 찍기

        for (int i = 0; i < N; i++) {
            if (!visited[i] &&
                    adjMatrix[cur][i] != 0) { // 방문 x && 인접
                dfs(i);
            }
        }
    }


    private static void bfs() {
        // 0번 정점 시작점
        Queue<Integer> queue = new ArrayDeque<>();
//        boolean[] visited = new boolean[N]; // 방문관리 배열

        visited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print((char) (cur + 'A')); // 알파벳으로 찍기

            // 한 정점의 인접 정점들을 큐에 넣어서 차후 탐색하도록 만들기
            for (int i = 0; i < N; i++) {
                if (!visited[i] &&
                        adjMatrix[cur][i] != 0) { // 방문 x && 인접
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        System.out.println();
    }
}

