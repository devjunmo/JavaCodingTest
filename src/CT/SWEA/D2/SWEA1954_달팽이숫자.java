package CT.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1954_달팽이숫자 {

    static int N;
    static int[][] res;
    static boolean[][] vis;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int cNum = 1; cNum <= TC; cNum++) {

            N = Integer.parseInt(br.readLine());

            int maxCnt = N * N;
            int movCnt = 1;

            res = new int[N][N];
            vis = new boolean[N][N];

            int curRowIdx = 0;
            int curColIdx = 0;

            vis[curRowIdx][curColIdx] = true; // 등록
            res[curRowIdx][curColIdx] = movCnt;
            movCnt++;

            while(true) {
                // 우측 이동
                while(true) {

                    curColIdx++; // 선 우측 이동

                    // 정상범위이면서 가본적 없는곳일때
                    if(curRowIdx>=0 && curRowIdx<N && curColIdx>=0 && curColIdx<N && vis[curRowIdx][curColIdx] == false) {
                        vis[curRowIdx][curColIdx] = true; // 등록
                        res[curRowIdx][curColIdx] = movCnt;
                        movCnt++;
                    }else {
                        curColIdx--; // 이동 취소
                        break;
                    }
                }

                // 하측 이동
                while(true) {

                    curRowIdx++; // 선 하측 이동

                    // 정상범위이면서 가본적 없는곳일때
                    if(curRowIdx>=0 && curRowIdx<N && curColIdx>=0 && curColIdx<N && vis[curRowIdx][curColIdx]== false) {
                        vis[curRowIdx][curColIdx] = true; // 등록
                        res[curRowIdx][curColIdx] = movCnt;
                        movCnt++;
                    }else {
                        curRowIdx--; // 이동 취소
                        break;
                    }
                }

                // 좌측 이동
                while(true) {

                    curColIdx--; // 선 좌측 이동

                    // 정상범위이면서 가본적 없는곳일때
                    if(curRowIdx>=0 && curRowIdx<N && curColIdx>=0 && curColIdx<N && vis[curRowIdx][curColIdx]== false) {
                        vis[curRowIdx][curColIdx] = true; // 등록
                        res[curRowIdx][curColIdx] = movCnt;
                        movCnt++;
                    }else {
                        curColIdx++; // 이동 취소
                        break;
                    }
                }

                // 상측 이동
                while(true) {

                    curRowIdx--; // 선 상측 이동

                    // 정상범위이면서 가본적 없는곳일때
                    if(curRowIdx>=0 && curRowIdx<N && curColIdx>=0 && curColIdx<N && vis[curRowIdx][curColIdx]== false) {
                        vis[curRowIdx][curColIdx] = true; // 등록
                        res[curRowIdx][curColIdx] = movCnt;
                        movCnt++;
                    }else {
                        curRowIdx++; // 이동 취소
                        break;
                    }
                }

//				System.out.println("hi");

                if(movCnt>maxCnt) {
                    break;
                }

            }

            System.out.println("#" + cNum);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(j==N-1) {
                        System.out.print(res[i][j]);
                    }else {
                        System.out.print(res[i][j] + " ");
                    }

                }System.out.println();
            }

        }
    }

}
