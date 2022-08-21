package CT.BOJ.Gold;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DFS_BFS_1260 {

    static int N;
    static int M;
    static int startV;
    static int[][] adjArr;
    static boolean[] visArr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nmv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = nmv[0];
        M = nmv[1];

        adjArr = new int[N + 1][N + 1]; // 영은 안씀. 1~N 까지

        startV = nmv[2];

        for (int i = 0; i < M; i++) {
            int[] fromTo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = fromTo[0];
            int to = fromTo[1];

            // 양방향 인접 행렬
            adjArr[from][to] = 1;
            adjArr[to][from] = 1;
        }

        visArr = new boolean[N + 1]; // 영은 안씀
//        visArr[startV] = true;
//        sb.append(startV).append(" ");
        dfs(startV); // visArr 필요

        sb.append("\n");

        visArr = new boolean[N + 1]; // 영은 안씀
        bfs(); // 큐 필요, visArr 필요

        bw.write(sb.toString()+"\n");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(startV); // 큐에 첫 정점 넣기
//        visArr[startV] = true; // 첫 방문 체크
//        sb.append(startV).append(" ");

        while (!(q.isEmpty())) { // 큐가 비지 않는동안
            int curV = q.poll();

            if (!visArr[curV]) { // 중복 출력 방지
                sb.append(curV).append(" ");
            }

            visArr[curV] = true;

            for (int i = 1; i <= N; i++) { // 1~N 정점
                if (!visArr[i] && adjArr[curV][i] == 1) { // 방문 안했고, 인접 하다면
                    q.offer(i); // 해당 정점을 큐에 넣기
                }
            }
        }
    }

    private static void dfs(int curV) {
        visArr[curV] = true;
        sb.append(curV).append(" ");

        for (int i = 1; i <= N; i++) {
            if (!visArr[i] && adjArr[curV][i] == 1) {
                dfs(i);
            }
        }
    }
}
















