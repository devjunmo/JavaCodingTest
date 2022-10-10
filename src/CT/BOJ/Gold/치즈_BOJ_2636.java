package CT.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 치즈_BOJ_2636 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] initVisit;

    static int cnt;

    static Coor[][] tableMap;

    static int tmpCheeseCnt;

    static Queue<Coor> surfaceCheeseQueue;

    static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dy = {0, 1, 0, -1}; // 상 우 하 좌

    enum MatType {
        Air, Cheese, NA
    }

    enum ChzStat {
        Surface, Inner, NA
    }

    static class Coor{
        int r;
        int c;
        MatType type;
        ChzStat status;

        public Coor(int r, int c, MatType type, ChzStat status) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Coor{" +
                    "r=" + r +
                    ", c=" + c +
                    ", type=" + type +
                    ", status=" + status +
                    '}';
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        map = new int[N][M];
//        initVisit = new boolean[N][M];
        tableMap = new Coor[N][M];
        cnt = 0;


        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

//        System.out.println("map = " + Arrays.deepToString(map));

        Coor zeroCoor = getZeroCoor();

        if (zeroCoor != null) {
//            initAir(zeroCoor.r, zeroCoor.c);
//            System.out.println("tableMap = " + Arrays.deepToString(tableMap));
//            System.out.println(Arrays.deepToString(map));
//            System.out.println("\n");
            while (countCheese() != 0) {
                initAir(zeroCoor.r, zeroCoor.c); // 에어를 세팅
                setCheese(); // 표면 치즈와 이너 치즈를 세팅
                changeSurface(); // 표면치즈를 에어로 변환
                cnt++;
//                System.out.println(Arrays.deepToString(map));
//                System.out.println("\n");
            }

            System.out.println(cnt);
            System.out.println(tmpCheeseCnt);
//            System.out.println(Arrays.deepToString(map));

        }
//        else {
//            System.out.println("air가 없는 상황");
//        }


    }

    private static int countCheese() {
        int oneCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    oneCnt++;
                }
            }
        }
        return oneCnt;
    }

    private static void changeSurface() {
        while (!surfaceCheeseQueue.isEmpty()) {
            Coor pollCoor = surfaceCheeseQueue.poll();
            Coor changeCoor = new Coor(pollCoor.r, pollCoor.c, MatType.Air, ChzStat.NA);

            tableMap[pollCoor.r][pollCoor.c] = changeCoor;
            map[pollCoor.r][pollCoor.c] = 0;
        }

    }


    private static void setCheese() {
        surfaceCheeseQueue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    // 사방 인접에 Air가 하나 라도 있으면 Surfase다.
                    if (((tableMap[i + dx[0]][j + dy[0]] != null) && (tableMap[i + dx[0]][j + dy[0]].type == MatType.Air)) ||
                            ((tableMap[i + dx[1]][j + dy[1]] != null) && (tableMap[i + dx[1]][j + dy[1]].type == MatType.Air)) ||
                            ((tableMap[i + dx[2]][j + dy[2]] != null) && (tableMap[i + dx[2]][j + dy[2]].type == MatType.Air)) ||
                            ((tableMap[i + dx[3]][j + dy[3]] != null) && (tableMap[i + dx[3]][j + dy[3]].type == MatType.Air))) {
                        Coor curCoor = new Coor(i, j, MatType.Cheese, ChzStat.Surface);
                        tableMap[i][j] = curCoor;
                        surfaceCheeseQueue.offer(curCoor);

                    }else{
                        tableMap[i][j] = new Coor(i, j, MatType.Cheese, ChzStat.Inner);
                    }
                }
            }
        }

        tmpCheeseCnt = surfaceCheeseQueue.size(); // 하나전 치즈 수 백업
    }


    private static void initAir(int startRow, int startCol) {
        initVisit = new boolean[N][M];
        // bfs
        Queue<Coor> q = new ArrayDeque<>();
        initVisit[startRow][startCol] = true; // 최초 방문 체크
        tableMap[startRow][startCol] = new Coor(startRow, startCol, MatType.Air, ChzStat.NA);

        q.offer(new Coor(startRow, startCol, MatType.NA, ChzStat.NA));

        while (!q.isEmpty()) {
            Coor coor = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = coor.r + dx[i];
                int ny = coor.c + dy[i];

                // 다음께 정상범위 & 안가본곳 & 값이 영일 때
                if (nx >= 0 && ny >= 0 && nx < N && ny < M
                        && !initVisit[nx][ny] && map[nx][ny] == 0) {
                    tableMap[nx][ny] = new Coor(nx, ny, MatType.Air, ChzStat.NA);
                    initVisit[nx][ny] = true;
                    q.offer(new Coor(nx, ny, MatType.Air, ChzStat.NA));
                }
            }
        }
    }

    private static Coor getZeroCoor() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return new Coor(i, j, MatType.NA, ChzStat.NA);
                }
            }
        }
        return null;
    }


}
