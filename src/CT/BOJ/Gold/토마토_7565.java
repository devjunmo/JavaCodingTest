package CT.BOJ.Gold;

import java.io.*;
import java.nio.charset.CoderResult;
import java.util.*;

public class 토마토_7565 {

    static int M, N;
    static int[][] arr;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int level;

    static Stack<Coor> cStack = new Stack<>();

    static class Coor{
        int row;
        int col;

        public Coor(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Coor{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] mn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = mn[0];
        N = mn[1];
        arr = new int[N][M];

        int checkCnt = 0;
        ArrayList<Coor> ripeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] rows = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int tmpVal = Integer.parseInt(rows[j]);
                arr[i][j] = tmpVal;
                if (tmpVal == 0) {
                    checkCnt++;
                } else if (tmpVal == 1) {
                    ripeList.add(new Coor(i, j));
                }
            }
        }

        if (checkCnt == 0) { // 모든 토마토가 익어있다면
            bw.write("0"+"\n");
            br.close();
            bw.flush();
            bw.close();
            return;
        }

        bfs(ripeList);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    bw.write("-1"+"\n");
                    br.close();
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        bw.write(level-1 + "\n");

        // 1인 애의 좌표 구하기

        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(ArrayList<Coor> ripeList) {
        Queue<Coor> q = new ArrayDeque<>();

        for (Coor c :
                ripeList) {
            q.offer(c);
        }

        while (!q.isEmpty()) {

            // 큐 만큼 for 돌기
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Coor curCoor = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nRow = curCoor.row + dx[j];
                    int nCol = curCoor.col + dy[j];
                    // 다음게 정상범위 && 0일때
                    if (nRow >= 0 && nCol >= 0 && nRow < N && nCol < M && arr[nRow][nCol] == 0) {
                        Coor tmpCoor = new Coor(nRow, nCol);
                        q.offer(tmpCoor);
                        arr[nRow][nCol] = 1;
//                        System.out.println("??");
                    }
                }
            }
            level++;
        }
    }
}
