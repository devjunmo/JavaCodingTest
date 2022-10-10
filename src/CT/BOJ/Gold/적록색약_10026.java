package CT.BOJ.Gold;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

/*
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
 */

public class 적록색약_10026 {

    static int N;
    static char[][] arr;
    static boolean[][] chk;

    static HashMap<Character, Character> rgMap;

    static int normalRes;
    static int weekRes;

    static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        rgMap = new HashMap<>();
        rgMap.put('R', 'G');
        rgMap.put('G', 'R');
        rgMap.put('B', 'B');

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = row.charAt(j);
            }
        }

        chk = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!chk[i][j]) {
                    bfsNormal(i, j);
                    normalRes++;
                }
            }
        }

        chk = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!chk[i][j]) {
                    bfsWeek(i, j);
                    weekRes++;
                }
            }
        }

        bw.write(normalRes+" "+weekRes+"\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfsWeek(int row, int col) {
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(row, col));
        chk[row][col] = true;

        while (!q.isEmpty()) {
            Coor curCoor = q.poll();
            for (int i = 0; i < 4; i++) {
                int nRow = curCoor.row + dx[i];
                int nCol = curCoor.col + dy[i];
                // 정상 범위, 방문여부, 동일색깔
                if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N
                        && !chk[nRow][nCol]
                        && (arr[curCoor.row][curCoor.col] == arr[nRow][nCol]
                            ||arr[nRow][nCol] == rgMap.get(arr[curCoor.row][curCoor.col]))) {
                    chk[nRow][nCol] = true;
//                    System.out.println(Arrays.deepToString(chk));
                    bfsWeek(nRow, nCol);
                }
            }
        }
    }

    private static void bfsNormal(int row, int col) {
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(row, col));
        chk[row][col] = true;

        while (!q.isEmpty()) {
            Coor curCoor = q.poll();
            for (int i = 0; i < 4; i++) {
                int nRow = curCoor.row + dx[i];
                int nCol = curCoor.col + dy[i];
                // 정상 범위, 방문여부, 동일색깔
                if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N && !chk[nRow][nCol] && arr[curCoor.row][curCoor.col] == arr[nRow][nCol]) {
                    chk[nRow][nCol] = true;
                    bfsNormal(nRow, nCol);
                }
            }
        }
    }

    static class Coor{
        int row;
        int col;

        public Coor(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
