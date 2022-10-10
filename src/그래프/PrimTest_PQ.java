package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTest_PQ {
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

    // PQ에 넣을 클래스 생성
    static class Vertex{
        int no, weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
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

        PriorityQueue<Vertex> pQueue = new PriorityQueue<>(
                (v1,v2)-> v1.weight - v2.weight
        );
        pQueue.offer(new Vertex(0, minEdge[0])); // 시작점을 큐에 넣기

        int cnt = 0; // 신장 트리에 추가된 정점 수
        while (true) {
            // step1. 신장 트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
            Vertex minVertex = pQueue.poll();

            if (visited[minVertex.no]) continue;

            /*
            step2. 신장트리에 추가
             */

            visited[minVertex.no] = true;
            result += minVertex.weight;
            if (++cnt == V) {
                break;
            }

            /*
            step3. 신장 트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은
                    정점들의 기존 최소 비용과 비교해서 갱신

                    신장 트리에 새롭게 추가되는 정점의 모든 인접 정점 들여다 보며 처리
             */

            for (Node tmp = adjList[minVertex.no]; // 방금 찍은
                 tmp != null;
                 tmp = tmp.next) {
                // 방문 x &&
                if (!visited[tmp.vertex] &&
                        minEdge[tmp.vertex] > tmp.weight) {
                    minEdge[tmp.vertex] = tmp.weight; // 비용 갱신
                    pQueue.offer(new Vertex(tmp.vertex, minEdge[tmp.vertex]));
                }
            }
        }

        System.out.println(result);
    }
}
