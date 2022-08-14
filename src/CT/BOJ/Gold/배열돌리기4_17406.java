package CT.BOJ.Gold;

import java.io.*;
import java.util.ArrayList;

public class 배열돌리기4_17406 {

    static int[][] A;

    static int K, N, M;

    static int[][] cmdArr;

    static boolean[] isSelected;

    static int[][] curCmdArr;

    static int[] dx = {1,0,-1,0}, dy={0,1,0,-1}; // 하 우 상 좌

    static int resMin = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ln1 = br.readLine().split(" ");

        N = Integer.parseInt(ln1[0]);
        M = Integer.parseInt(ln1[1]);

        K = Integer.parseInt(ln1[2]);

        A = new int[N][M];

        isSelected = new boolean[K];
        curCmdArr = new int[K][3];

        // 배열 받기
        for (int i = 0; i < N; i++) {
            String[] sArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(sArr[j]);
            }
        }

        // 명령 받기
        cmdArr = new int[K][3];
        for (int i = 0; i < K; i++) {
            String[] sArr = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                cmdArr[i][j] = Integer.parseInt(sArr[j]);
            }
        }

        permSol(0);

        bw.write(resMin + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static void calcMin(int[][] a) {
        // 현재 배열의 min값 구하기
        int localMin = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int sumRow = 0;
            for (int j = 0; j < M; j++) {
                sumRow += a[i][j];
            }
            if (sumRow < localMin) {
                localMin = sumRow;
            }
        }

        if (localMin < resMin) {
            resMin = localMin;
        }
    }

    static void runRCS(int R, int C, int S, int[][] a) {
        // 가장 왼쪽 윗 칸이 (r-s, c-s), 가장 오른쪽 아랫 칸이 (r+s, c+s)
        // start

        int leftUp_X = R - S -1; // 배열은 0부터 시작이라서 1 빼줌
        int leftUp_Y = C - S -1;

        // end
        int rightBot_X = R + S -1;
        int rightBOT_Y = C + S -1;

        for(int j=0; j<(S); j++){ // grpNo = 짧은거 / 2라서..
            int x=leftUp_X + j; // 시작점
            int y=leftUp_Y + j;
            int temp=a[x][y]; // 다 땡긴후 빈곳에 넣어줄 값
            int idx=0;
            while(idx<4){ // 시계방향, 하 우 상 좌
                int nx=x+dx[idx];
                int ny=y+dy[idx];

                // 벗어난 범위
                if(nx<leftUp_X+j || nx>rightBot_X-j || ny<leftUp_Y+j || ny>rightBOT_Y-j){
                    idx++;
                }
                else{
                    a[x][y] = a[nx][ny]; // 정상 범위라면 앞에꺼 땡겨서 전에다 넣기
                    x=nx;
                    y=ny;
                }
            }
            a[leftUp_X + j][leftUp_Y + j+1]=temp; // 시작점 우측
        }
    }

    static void permSol(int cnt) {
        if (cnt == K) { // curCmdArr가 꽉참

            int[][] curArr = new int[N][M];
            for(int i=0; i<N; i++) {
                System.arraycopy(A[i], 0, curArr[i], 0, M); // A 배열 깊은 복사
            }
            for (int[] cmd:
                 curCmdArr) {
                int cmdR = cmd[0];
                int cmdC = cmd[1];
                int cmdS = cmd[2];

                runRCS(cmdR, cmdC, cmdS, curArr);
            }
            calcMin(curArr);

            return;
        }

        for (int i = 0; i < K; i++) { // 가능한 모든 명령어 셋트에 대해..
            if (isSelected[i]) { // 세트가 사용중이라면
                continue;
            }

            curCmdArr[cnt] = cmdArr[i];
            isSelected[i] = true;

            permSol(cnt + 1);
            isSelected[i] = false;
        }
    }
}
