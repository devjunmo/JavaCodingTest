package CT.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소스패닝트리_3124 {
    // 간선 리스트 만들기
    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parents;
    static int V,E; // 정점 갯수, 간선 갯수
    static Edge[] edgeList;


    static boolean union(int a, int b) { // 리턴값 : true ==> union 성공
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return false; // 부모가 같으면 합칠수가 없다. 원래 합쳐진 놈들이라..

        parents[bRoot] = aRoot; // bRoot의 부모를 aRoot로 합쳐버리기..
        return true;
    }

    static int find(int a) { // a의 대표자 찾기
        if (parents[a] == a) return a; // 나의 부모가 나라면 나를 리턴
        return parents[a] = find(parents[a]); // 우리의 대표자를 나의 부모로.. (path compression)
    }

    static void make() { // 크기가 1인 서로 소 집합 생성
        parents = new int[V+1];
        for (int i = 0; i < V; i++) { // 모든 노드가 자신을 부모로 하는(대표자) 집합으로 만듦
            parents[i] = i; // 자신의 부모는 자신으로
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine());
        for (int cNum = 1; cNum <= TC; cNum++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            edgeList = new Edge[E];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
            }

            make();
            Arrays.sort(edgeList); // 간선기준 오름차순

            long result = 0; // 가중치 합
            int count = 0; // 간선수
            for (Edge edge :
                    edgeList) {
                if (union(edge.from, edge.to)) { // 간선 하나씩 소모하면서 union try
                    result += edge.weight;
                    if (++count == V - 1) { // 간선수가 정점-1이 되면 break
                        break;
                    }
                }
            }
            System.out.println("#"+cNum+" "+result);
        }
    }
}
