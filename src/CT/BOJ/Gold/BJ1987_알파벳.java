package CT.BOJ.Gold;

/*
2 4
CAAB
ADCB
 */

import java.io.*;

public class BJ1987_알파벳 {

    static int movCnt=1, R, C, maxMovCnt=Integer.MIN_VALUE;
    static int[] arr;

    // 65 빼줘서 0~25개 알파벳 배열
    static boolean[] alphabetArr = new boolean[26];
    static char[][] inputArr;
    static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rc = br.readLine().split(" ");

        R = Integer.parseInt(rc[0]);
        C = Integer.parseInt(rc[1]);

        inputArr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                inputArr[i][j] = row.charAt(j);
            }
        }

        alphabetArr[inputArr[0][0]-65] = true; // 처음 자리 방문 체크
        dfs(0, 0, 0); // 0,0부터 시작..

        bw.write(maxMovCnt + "\n");

        br.close();
        bw.flush();
        bw.close();


    }

    private static void dfs(int curRow, int curCol, int lev) {

        // 현재 무브 카운트가 맥스보다 크다면...
        if (movCnt > maxMovCnt) {
            maxMovCnt = movCnt;
        }

        // 이동 로직
        for (int i = 0; i < 4; i++) { // 4방향
            int nextRow = curRow + dx[i];
            int nextCol = curCol + dy[i];

            // 정상 범위인지, 알파벳 선택 되었는지 확인
            if (nextRow>=0 && nextRow < R && nextCol >= 0 && nextCol < C
             && !alphabetArr[inputArr[nextRow][nextCol] - 65]) {
                alphabetArr[inputArr[nextRow][nextCol] - 65] = true; // 선택 기록 남기기
                movCnt++;
                dfs(nextRow, nextCol, lev + 1);
                alphabetArr[inputArr[nextRow][nextCol] - 65] = false; // 선택 해제
                movCnt--;
            }

        }
    }
}
