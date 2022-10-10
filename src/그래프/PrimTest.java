package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimTest {
    static int V, E;
    static class Node{
        int vertex, weight;
        Node next;

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        Node[] adjList = new Node[V];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 인접 리스트 생성
            adjList[from] = new Node(to, weight, adjList[from]);
            adjList[to] = new Node(from, weight, adjList[to]);
        }

        // 프림 알고리즘에 필요한 자료구조
        int[] minEdge = new int[V]; // 각 정점 입장에서 신장 트리에 포함된 정점과의 간선 비용을 최소 비용으로
        boolean[] visited = new boolean[V]; // 신장트리에 포함 여부

        Arrays.fill(minEdge, Integer.MAX_VALUE);

        // 1. 임의의 시작점 처리
        minEdge[0] = 0; // 처음은 나 자신과 거리니까 제로
        int result = 0; // 최소 신장트리 비용 누적

        // V개의 정점 처리 하면 끝 ( 이부분 시간복잡도 N, PQ로 logN 느낌으로 최적화 가능)
        for (int c = 0; c < V; c++) { // 첫 요소 부터 정점 수 만큼 루프. c변수 사용 안됨
            // step1. 신장 트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
            int min = Integer.MAX_VALUE;
            int minVertex = -1; // 최소인 정점 저장할 변수
            for (int j = 0; j < V; j++) {
                // 신장트리에 포함되지 않은 정점이면서 간선 비용이 최소일때
                if (!visited[j] && min > minEdge[j]) {
                    min = minEdge[j];
                    minVertex = j; // 최소 정점번호 기억
                }
            }  // 현재 정점 차례에서 인접한 정점 중 최소 비용의 인접 정점 얻었음

            /*
            step2. 신장트리에 추가
             */

            visited[minVertex] = true; // 방문처리
            result += min;

            /*
            step3. 신장 트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은
                    정점들의 기존 최소 비용과 비교해서 갱신

                    신장 트리에 새롭게 추가되는 정점의 모든 인접 정점 들여다 보며 처리
             */

            for (Node tmp = adjList[minVertex]; // 방금 찍은 노드에 인접한 노드들 가져오기
                 tmp != null;
                 tmp = tmp.next) {
                // 방문 x &&
                if (!visited[tmp.vertex] && // 방문 안했고
                        minEdge[tmp.vertex] > tmp.weight) { // 각 정점의 최소 가중치를 모은 배열의 정보와 비교해서 현재가 더 작다면
                    minEdge[tmp.vertex] = tmp.weight; // 비용 갱신. 비용갱신 먼저 하고 다음 정점을 찍는것
                }
            }
        }

        System.out.println(result);
    }
}
