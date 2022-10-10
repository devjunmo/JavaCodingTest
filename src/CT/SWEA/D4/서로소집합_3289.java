package CT.SWEA.D4;

import java.io.*;
import java.util.Arrays;

public class 서로소집합_3289 {

    static int N, M;
    static int[] parents;

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b); // 각각의 루트 찾고

        // 이미 같으면 유니온 못하니까 false 리턴
        if (aRoot==bRoot) return false;

        // b루트의 루트를 a로
        parents[bRoot] = aRoot;
        return true;
    }

    static int find(int V) {
        if (parents[V] == V) return V; // 본인이라면.. 본인 리턴
        return parents[V] = find(parents[V]); // 재귀로 root 찾기
    }

    static void make(){ // 크기가 1인 서로소 집합 생성
        parents = new int[N + 1]; // 1부터 시작
        // 각자를 자신의 노드로 초기화
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int cNum = 1; cNum <= TC; cNum++) {
            bw.write("#"+ cNum+ " ");
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = nm[0];
            M = nm[1];
            make();
            for (int i = 0; i < M; i++) {

                int[] cab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int cmd = cab[0];
                int a = cab[1];
                int b = cab[2];

                switch (cmd) {
                    case 0:
                        union(a, b);
                        break;
                    case 1:
                        if (find(a) == find(b)) {
                            bw.write("1");
                        }else {
                            bw.write("0");
                        }
                        break;
                }
            }

            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
