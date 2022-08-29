package CT.SWEA.모의역량테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 프로세서연결_1767 {
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
    static int N;
    static int[][] arr;
    static int[][] copyArr;
    static boolean[][] vis;
    static ArrayList<Coor> posLst;
    static Coor[] subsetRes;
    static boolean[] isSelected;
    static int curSubsetCnt;
    static int res;

    static boolean[] flagArr;

    // 사방탐색, 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int cNum = 1; cNum <= TC; cNum++) {
            res = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            posLst = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] rows = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    int tmpVal = Integer.parseInt(rows[j]);
                    arr[i][j] = tmpVal;
                    // 값이 1이면서 가장자리가 아닐때
                    if (tmpVal == 1 && (i != 0 && j != 0 && i != (N - 1) && j != (N - 1))) {
                        posLst.add(new Coor(i, j));
                    }
                }
            }

            isSelected = new boolean[posLst.size()];
            flagArr = new boolean[posLst.size() + 1];

            mySubset(0);

            bw.write("#" + cNum + " " + res + "\n");

        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void myDfs(ArrayList<Coor> curPosLst, int lev, int curSum) { // 시작 pos, 현재 lev
        if (lev == curSubsetCnt){
            for (int i = 0; i <= curSubsetCnt - 1; i++) {
                flagArr[i] = true;
            }

            if (curSum < res) {
                res = curSum;
            }
            return;
        }

        Coor curPos = curPosLst.get(lev);
        for (int i = 0; i < 4; i++) { // 사방 탐색
            int tmpCnt = 0;
            int tmpMaxCnt = 0;
            int tmpX = curPos.row;
            int tmpY = curPos.col;

            while (true) { // 해당 방향으로 최대한 갈수있는 카운트 구하기
                tmpX += dx[i];
                tmpY += dy[i];
                // 정상범위일때
                if (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < N) {
                    tmpMaxCnt++;
                }else {
                    break;
                }
            }

            tmpX = curPos.row;
            tmpY = curPos.col;
            while (true) { // tmpCnt 구하기
                tmpX += dx[i];
                tmpY += dy[i];
                // 정상범위면서 arr 값이 영일때
                if (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < N && copyArr[tmpX][tmpY] == 0) {
                    tmpCnt++;
                }else {
                    break;
                }
            }

            if (tmpCnt != tmpMaxCnt) { // 전선이 끝까지 도달 할 수 없다면 방향 튼다
                continue;
            }

            tmpX = curPos.row;
            tmpY = curPos.col;
            // tmpCnt만큼 1로 채우기
            for (int j = 0; j < tmpCnt; j++) {
                tmpX += dx[i];
                tmpY += dy[i];
                copyArr[tmpX][tmpY] = 1;
            }

            myDfs(curPosLst, lev + 1, curSum + tmpCnt);

            // dfs 끝나면 채운거 취소하기
            tmpX = curPos.row;
            tmpY = curPos.col;
            // tmpCnt만큼 1로 채우기
            for (int j = 0; j < tmpCnt; j++) {
                tmpX += dx[i];
                tmpY += dy[i];
                copyArr[tmpX][tmpY] = 0;
            }
        }

    }

    static void mySubset(int lev) {
        if (lev == posLst.size()) {
            // 서브셋 케이스마다 초기화 해야할 변수들 초기화
            vis = new boolean[N][N]; // 서브셋 케이스마다 vis 새로 쓰기
            copyArr = new int[N][N];
            System.arraycopy(arr, 0, copyArr, 0, N); // 카피배열 만들기
            ArrayList<Coor> curPosLst = new ArrayList<>(); // 서브셋된 위치 정보들
            for (int i = 0; i < posLst.size(); i++) {
                if (isSelected[i]) {
                    curPosLst.add(posLst.get(i));
                }
            }
            curSubsetCnt = curPosLst.size();

            if (!flagArr[curSubsetCnt]) { // 5짜리가 성공했으면 4 안본다는것
                myDfs(curPosLst, 0, 0);
            }
            return;
        }

        isSelected[lev] = true; // 선택하거나
        mySubset(lev + 1);

        isSelected[lev] = false; // 선택 안하거나
        mySubset(lev + 1);
    }
}
