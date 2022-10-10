package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int V = Integer.parseInt(in.readLine());

        int[][] adjMatrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int start = 0; // 출발 정점
        int end = V-1; // 도착 정점

        // 다익스트라 아록리즘에 필요한 자료구조
        int[] D = new int[V]; // 출발지에서 자신으로 오는데 소요되는 최소 비용
        boolean[] visited = new boolean[V]; // 처리한 정점 여부

        // 출발 정점 처리
        Arrays.fill(D, Integer.MAX_VALUE);
        D[start] = 0; // 출발 정점은 당연히 거리 영

        int min, minVertex;

        for (int i = 0; i < V; i++) {
            // step1. 미 방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
            // 방문해야하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기

            min = Integer.MAX_VALUE;
            minVertex = -1;
            for (int j = 0; j < V; j++) {
                if (!visited[j] && min > D[j]) {
                    min = D[j];
                    minVertex = j;
                }
            }

            // step2. 방문 처리
            visited[minVertex] = true;


            // step3. 선택된 정절을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다
            //      유리하면 갱신
            for (int j = 0; j < V; j++) {
                if (!visited[j]
                        && adjMatrix[minVertex][j] > 0 // 인접 행렬에서 가중치가 0인곳은 못가는 상황
                        && D[j] > D[minVertex] + adjMatrix[minVertex][j]) {
                    D[j] = D[minVertex] + adjMatrix[minVertex][j]; // 갱신
                }
            }
        }
        System.out.println(D[end]);
    }
}
