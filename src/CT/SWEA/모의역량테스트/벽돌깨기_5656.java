package CT.SWEA.모의역량테스트;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽돌깨기_5656 {

    static int N, W, H, min;

    // 사방탐색, 상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void copy(int[][] map, int[][] newMap) {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                newMap[r][c] = map[r][c];
            }
        }
    }

    // 구슬 던지기 게임
    static void go(int[][] map, int cnt)  {

        if (cnt == N) { // 구술을 모두 던진 상태
            // 남은 벽돌 수 세고 최소값 갱신
            int res = getRemain(map);
            if(min>res) min = res;

            return;
        }

        // 구슬 던지기 (중복 순열)
        int[][] newMap = new int[H][W];
        for (int c = 0; c < W; c++) {

            // 구슬에 맞는 시작 벽 찾기
            int r = 0;
            while (r < H && map[r][c] == 0) ++r; // 빈칸이면 내려가면서 찾기

            if (r == H) { // 맞는 시작 벽돌이 없는 상태
                go(map, cnt + 1); // 다음 열로 떨어뜨리러 가기
            } else { // 맞는 시작벽돌이 있는 상태
                copy(map, newMap);
                // 제거될 벽돌 연쇄 처리
                boom(newMap, r, c);

                // 벽돌 중력 처리
                down(newMap);

                // 다음 구슬 던지기
                go(newMap, cnt + 1);
            }


        }
    }

    private static int getRemain(int[][] map) {
        int res = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] > 0) res++;
            }
        }
        return res;
    }

    private static void down(int[][] newMap) {
        for (int c = 0; c < W; c++) {
            int r = H - 1;
            while (r > 0) {
                if (newMap[r][c] == 0) { // 빈칸이면 내릴 벽돌 찾기
                    int nr = r - 1;
                    while (nr>0 && newMap[nr][c] == 0) nr--;
                    newMap[r][c] = newMap[nr][c];
                    newMap[nr][c] = 0;
                }
                --r;
            }
        }
    }

    private static void boom(int[][] newMap, int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();

        // 벽돌이 있던 자리를 영으로 변경 (빈캄으로 만들어서 방문처리 하는 효과)
        if (newMap[r][c] > 1) { // 주변에 영향을 주는 벽돌 정보만 큐에 넣을것
            queue.offer(new Point(r, c, newMap[r][c]));
        }
        newMap[r][c] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll(); // 주변에 영향을 주는 벽돌 정보

            // 벽돌 크기 - 1 만큼 4방 연쇄 처리
            for (int d = 0; d < 4; d++) {
                int nr = p.r;
                int nc = p.c;

                for (int k = 1; k < p.cnt; k++) {
                    nr += dr[d];
                    nc += dc[d];
                    if (nr >= 0 && nc >=0 && nr < H && nc < W && newMap[nr][nc] > 0) {
                        if (newMap[nr][nc] > 1) {
                            queue.offer(new Point(nr, nc, newMap[nr][nc]));
                        }
                        // 벽돌이 있던 자리를 영으로 변경
                        newMap[nr][nc] = 0;
                    }
                }
            }
        }

    }

    static class Point{
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            go(map, 0);

            bw.write("#" + tc + " " + min + "\n");

        }

        br.close();
        bw.flush();
        bw.close();
    }


}
