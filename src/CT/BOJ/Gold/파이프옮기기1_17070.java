package CT.BOJ.Gold;

/*
3
0 0 0
0 0 0
0 0 0
*/

import java.io.*;
import java.util.Arrays;

public class 파이프옮기기1_17070 {

    static int N;
    static int[][] mapArr;
    static int res;

    static class Pipe{
        int tail;
        int head;
        int status; // 0: 가로 1: 세로 2: 대각선

        public Pipe(int tail, int head, int status) {
            this.tail = tail;
            this.head = head;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Pipe{" +
                    "tail=" + tail +
                    ", head=" + head +
                    ", status=" + status +
                    '}';
        }
    }

    public static void dfs(int curX, int curY, int curStatus) {
        // 기저조건
        if (curX == N - 1 && curY == N - 1) {
            res++;
            return;
        }

        // 비 정상 범위일 때
        if (curX >= N && curY >= N) {
            return;
        }

        int nextX = curX + 1;
        int nextY = curY + 1;

//        // 비 정상 범위일 때
//        if (nextX >= N || nextY >= N) {
//            return;
//        }



        // 가로 or 대각 && 다음 자리가 영일 때
        if ((curStatus == 0 || curStatus == 1)){

            // 갈 자리가 영일 때
            if (nextY < N && mapArr[curX][nextY] == 0) {
                dfs(curX, nextY, 0); // 가로로
            }
        }

        // 세로 or 대각 && 다음 자리가 영일 때
        if ((curStatus == 2 || curStatus == 1)){

            // 갈 자리가 영일 때
            if (nextX < N && mapArr[nextX][curY] == 0) {
                dfs(nextX, curY, 2); // 세로로
            }
        }

        // 모든 경우에서 대각선으로 움직일 때
        if (nextX < N && nextY < N
                && mapArr[nextX][nextY] == 0
                && mapArr[nextX][curY] == 0
                && mapArr[curX][nextY] == 0) {

            dfs(nextX, nextY, 1); // 대각으로
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        mapArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            mapArr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0, 1, 0); // 가로: 0, 대각: 1, 세로: 2

        bw.write(res + "\n");

        br.close();
        bw.flush();
        bw.close();

    }
}
