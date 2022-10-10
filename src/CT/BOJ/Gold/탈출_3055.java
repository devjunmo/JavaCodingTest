package CT.BOJ.Gold;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
3 3
D.*
...
.S.
 */
public class 탈출_3055 {
    static int ans;
    static boolean goalIn = false;
    static int R, C;
    static char[][] arr;
    static boolean[][] vis;
    static int curRow, curCol; // 현재 고슴도치 위치 저장 

    static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dy = {0, 1, 0, -1};

    static Queue<Coor> waterQ = new ArrayDeque<>();
    static Queue<Coor> moveQ = new ArrayDeque<>();
    
    static class Coor{
        int x;
        int y;
        int level;

        public Coor(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        @Override
        public String toString() {
            return "Coor{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = rc[0];
        C = rc[1];

        arr = new char[R][C];
        vis = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = row.charAt(j);
                if (arr[i][j] == 'S') {
                    curRow = i; // 고슴도치 위치 초기화
                    curCol = j;
                    moveQ.offer(new Coor(curRow, curCol, 0));
                    arr[curRow][curCol] = '.'; // 고슴도치 위치를 알았으니 이 자리는 물이 찰수있게 만들어줌
                    vis[curRow][curCol] = true; // 고슴도치가 방문 했다고 체크
                } else if (arr[i][j] == '*') { // 물이라면
                    waterQ.offer(new Coor(i, j, -1)); // 현재 물 좌표를 워터큐에 넣는다.
                }
            }
        }

        while (!moveQ.isEmpty()) {
            setWater();
            bfs();
        }

        if (goalIn) {
            bw.write(ans + "\n");
        }else {
            bw.write("KAKTUS"+"\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs() {
        int qSize = moveQ.size();
        for (int i = 0; i < qSize; i++) {
            Coor curCoor = moveQ.poll();
            vis[curCoor.x][curCoor.y] = true; // 방문체크
            int pastLev = curCoor.level;

            for (int j = 0; j < 4; j++) {
                int nx = curCoor.x + dx[j];
                int ny = curCoor.y + dy[j];
                // 정상범위면서 방문 안했으면서 .이랑 D 인 곳만 간다
                if (nx >= 0 && nx < R && ny >= 0 && ny < C &&  !vis[nx][ny] && (arr[nx][ny] == '.' || arr[nx][ny] == 'D')) {
                    if (arr[nx][ny] == 'D'){ // 도착지에 도착하면
                        goalIn = true;
                        moveQ.clear(); // 비우고 리턴
                        ans = pastLev + 1;
                        return;
                    }
                    vis[nx][ny] = true;
                    // 목적지가 아니라면
                    moveQ.offer(new Coor(nx, ny, pastLev + 1));

                }
            }
        }
    }

    private static void setWater() {
        int wqSize = waterQ.size();
        for (int wqc = 0; wqc < wqSize; wqc++) {
            Coor curWater = waterQ.poll();
            for (int i = 0; i < 4; i++) {
                int nwx = curWater.x + dx[i];
                int nwy = curWater.y + dy[i];
                // 정상 범위 && .인곳만 물 채운다
                if (nwx >= 0 && nwx < R && nwy >= 0 && nwy < C && arr[nwx][nwy] == '.') {
                    arr[nwx][nwy] = '*';
                    waterQ.offer(new Coor(nwx, nwy, -1));
                }
            }
        }
    }
}
