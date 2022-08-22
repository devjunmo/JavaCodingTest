package CT.SWEA.D4;

import java.io.*;
import java.util.*;

//24 2
//1 17 3 22 1 8 1 7 7 1 2 7 2 15 15 4 6 2 11 6 4 10 4 2


public class Contact_1238 {

    static int[][] adjArr;

    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int cNum = 1; cNum <= 10; cNum++) {
            int inputLen = sc.nextInt();
            int startV = sc.nextInt();

            // 연락 인원은 최대 100명이며, 부여될 수 있는 번호는 1이상, 100이하이다.
            adjArr = new int[101][101];
            vis = new boolean[101];

            for (int i = 0; i < inputLen/2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                adjArr[from][to] = 1;

            }
            System.out.print("#"+cNum+" ");
            bfs(startV);

        }
    }

    private static void bfs(int startV) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(startV);
        vis[startV] = true;
        int nowMaxVert = -1;

        while (!q.isEmpty()) {
            nowMaxVert = -1;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) { // 이 루프 만큼 한 레벨
                int curV = q.poll();

                if (curV > nowMaxVert) {
                    nowMaxVert = curV;
                }

                for (int j = 1; j <= 100; j++) {
                    int tmpV = adjArr[curV][j];
                    if (!vis[j] && tmpV == 1) { // 방문 x && 인접
                        q.offer(j);
                        vis[j] = true;
                    }
                }
            }
        }
        // 끝까지 갔을때의 maxVert값 출력
        System.out.println(nowMaxVert);
    }
}
