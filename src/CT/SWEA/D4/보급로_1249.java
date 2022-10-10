package CT.SWEA.D4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 보급로_1249 {
    static int N;
    static int res;
    static int[][] mapArr;
    static boolean[][] visArr;

    static int[] dRow = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dCol = {0, 1, 0, -1}; // 상 우 하 좌

    static class Coor implements Comparable<Coor>{
        int x;
        int y;
        int cost;

        public Coor(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Coor{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cost=" + cost +
                    '}';
        }


        @Override
        public int compareTo(Coor o) {
            if (this.cost < o.cost) {
                return -1;
            }else if (this.cost == o.cost) {
                return 0;
            }else {
                return 1;
            }
        }
    }


    public static void bfs(Coor start){
        Queue<Coor> queue = new PriorityQueue<>();

        visArr[start.x][start.y] = true; // 현재 위치 방문 체크
        queue.offer(start);

        while (!queue.isEmpty()) {
            Coor curPos = queue.poll(); //우선순위가 높은게(현재 좌표에서 코스트가 제일 작은거) 폴된다
            visArr[curPos.x][curPos.y] = true;

            if (curPos.x == N - 1 && curPos.y == N - 1) {
                res = curPos.cost + mapArr[N-1][N-1];
                break;
            }

            // 폴 했을때 현재 자리
            for (int i = 0; i < 4; i++) {
                // 사방탐색
                int nx = curPos.x + dRow[i];
                int ny = curPos.y + dCol[i];

                // 맵을 벗어나지 않으면서, 방문하지 않은곳일때
                if (nx>=0 && ny>=0 && nx<N && ny<N && !visArr[nx][ny]){
                    int saveCost = mapArr[nx][ny] + curPos.cost; // 다음꺼 + 현재꺼
                    queue.offer(new Coor(nx, ny, saveCost));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNum = Integer.parseInt(br.readLine());

        for (int cNum = 1; cNum <= caseNum; cNum++) {
            N = Integer.parseInt(br.readLine());
            mapArr = new int[N][N];
            visArr = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    mapArr[i][j] = Character.getNumericValue(str.charAt(j));
                }
            }

            bfs(new Coor(0, 0, 0));
            bw.write("#" + cNum + " " + res + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }


}



















