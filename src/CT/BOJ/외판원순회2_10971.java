package CT.BOJ;

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0
 */

import java.io.*;
import java.util.Arrays;

public class 외판원순회2_10971 {

    static int N;
    static int[][] arr;

    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1]; // 1부터 생각

        for (int i = 1; i <= N; i++) {
            String[] rows = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j+1] = Integer.parseInt(rows[j]);
            }
        }

        for (int i = 1; i <= N; i++) {
            // N개의 정점을 각각 스타트로 N번 루프
            System.out.println("#########");
            prim(i);
        }

        bw.write(minCost + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void prim(int startV) {
        int[] minEdge = new int[N + 1]; // 최소 간선비용 저장 배열, 1부터 생각
        boolean[] vis = new boolean[N + 1];

        Arrays.fill(minEdge, Integer.MAX_VALUE);

        // 임의의 시작점 처리
        minEdge[startV] = 0;
        int result = 0; // 최소 신장 트리 비용 누적

        // 이 문제는 마지막 방문 정점에서 스타트 정점으로 한번 더 가야함
        int lastV = -1;

        // V개의 정점을 처리하면 끝난다
        for (int c = 0; c < N; c++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1; // 최소 정점 저장 변수
            for (int i = 1; i <= N; i++) { // 1부터 시작
                if (!vis[i] && min > minEdge[i]) {
                    min = minEdge[i];
                    minVertex = i;
                }
            }

            // 신장트리에 추가
            vis[minVertex] = true;
            result += min;
            System.out.println(min);

            // 현재 정점과 인접한 간선들 minEdge배열에 min값으로 update
            for (int i = 1; i <= N; i++) {
                if (arr[minVertex][i] != 0 &&
                        !vis[i]) {
                    //minEdge[i] > arr[minVertex][i]
                    minEdge[i] = arr[minVertex][i];
                }
            }
            if (c == N - 1) {
                lastV = minVertex;
            }
        }

        result += arr[lastV][startV]; // 원점으로 회귀하는 비용까지 합산
        System.out.println("+"+arr[lastV][startV]);
        if (minCost > result) {
            minCost = result;
        }
    }
}













