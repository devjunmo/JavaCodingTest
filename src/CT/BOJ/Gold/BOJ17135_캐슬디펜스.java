package CT.BOJ.Gold;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BOJ17135_캐슬디펜스 {
    static int debug = 0;
    static int[] archerCols; // 아처의 열을 조합으로 뽑
    static int curArcherRow; // 현재 궁수의 행

    static int arrFirstRow = 1; // 적을 탐색할 지도의 첫 행은 항상 1로 고정
    static int arrLastRow; // 적을 탐색할 지도의 마지막 행 = curArcherRow - 1

    static int[][] arr;
    static int N, M, D;
    static int res;
    static int maxRes = Integer.MIN_VALUE;
    static class Enemy{
        int row, col;

        public Enemy(int row, int col) {
            this.row = row;
            this.col = col;
//            this.distFromArc = distFromArc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nmd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = nmd[0];
        M = nmd[1];
        D = nmd[2];

        archerCols = new int[3];
//        curArcherRow = N + 1;
//        arrLastRow = curArcherRow - 1; // 아처 바로 위가 적이 위치하는 마지막 행
        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) { // 1 ~ N
            String[] rows = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) { // 1 ~ M
                arr[i][j] = Integer.parseInt(rows[j-1]);
            }
        }

        comb(0, 1);
        bw.write(maxRes+"\n");


        br.close();
        bw.flush();
        bw.close();

    }

    private static void setLst(ArrayList<Enemy> eLst, int fstRow, int LstRow, int[][] copyArr) {
        for (int i = fstRow; i <= LstRow; i++) {
            for (int j = 1; j <= M; j++) {
                if (copyArr[i][j] == 1) {
                    eLst.add(new Enemy(i, j));
                }
            }
        }
    }

    private static void killEnemy(int[] archerColCopy, int[][] copyArr) {
        curArcherRow = N + 1;
        arrLastRow = curArcherRow - 1; // 아처 바로 위가 적이 위치하는 마지막 행
//        Queue<Enemy> enemyQ = new ArrayDeque<>(); // 현 상황에서 존재하는 적들을 넣는 큐
        
        while (true) {
            if (curArcherRow == 1) { // 더이상 없앨 적이 없으면 루프 빠져나감 
                break;
            }
            ArrayList<Enemy> eLst = new ArrayList<>(); // 적 객체를 담은 리스트
            // 리스트 채우기
            setLst(eLst, arrFirstRow, arrLastRow, copyArr); // 지정된 범위 내 적들의 위치 채우기

            ArrayList<Enemy> rmEnemys = new ArrayList<>(); // 궁수 세명이 현재 죽일 적들 저장

            // 조합으로 뽑힌 궁수들 각각을 돌려
            for (int i = 0; i < archerColCopy.length; i++) {
                int curMinDist = Integer.MAX_VALUE; // 현재 최소 거리 저장
                int cur_e_MinCol = Integer.MAX_VALUE; // 현재 제일 왼쪽 컬럼 저장
                int cur_e_matchedRow = -1; // 위 컬럼에 매칭되는 row 저장

                int curArcherCol = archerColCopy[i]; // 현재 아처 컬럼
                // |궁수행-적행|+|궁수열-적열|
                for (Enemy tmpE : eLst){
                    int tmpDst = Math.abs(curArcherRow - tmpE.row) + Math.abs(curArcherCol - tmpE.col);
                    // 사거리 이내의 가장 왼쪽의 가장 근거리인 적 위치 구하기 (왼쪽부터 도니까...)
//                    if (tmpDst <= D && curMinDist >= tmpDst) {
//                        // 최소 거리가 같을때 왼쪽에 있는 적 선택
//                        if (curMinDist == tmpDst && tmpE.col < cur_e_MinCol) {
//                            curMinDist = tmpDst;
//                            cur_e_MinCol = tmpE.col;
//                            cur_e_matchedRow = tmpE.row;
//                            //
//                        } else if (curMinDist != tmpDst) { // 거리가 다를때는
//
//                        }
//                    }
                    if (tmpDst <= D) { // 사거리 이내일 때
                        // curMinDist가 max면 그냥 값 대입
                        if (curMinDist == Integer.MAX_VALUE) {
                            curMinDist = tmpDst;
                            cur_e_MinCol = tmpE.col;
                            cur_e_matchedRow = tmpE.row; // 값 대입
                        } else if (curMinDist == tmpDst && tmpE.col < cur_e_MinCol) {
                            // 현재까지의 최소와 지금 적과의 거리가 같으면서 지금께 더 왼쪽일 때
                            cur_e_MinCol = tmpE.col; // 열 갱신
                            cur_e_matchedRow = tmpE.row; // 행 갱신
                        } else if (curMinDist > tmpDst) { // 지금것이 더 작을때
                            curMinDist = tmpDst;
                            cur_e_MinCol = tmpE.col;
                            cur_e_matchedRow = tmpE.row; // 값 대입
                        }
                    }

                }
                rmEnemys.add(new Enemy(cur_e_matchedRow, cur_e_MinCol));
            }

            for (Enemy e :
                    rmEnemys) {
                if (e.row!=-1 && copyArr[e.row][e.col] == 1) { // 정상범위 이면서 적이 있다면
                    copyArr[e.row][e.col] = 0; // 적 없애기
                    res++;
                }
            }
            
            // 다 쏘고 죽였으면 궁수 한칸 위로
            curArcherRow--;
            arrLastRow = curArcherRow - 1; // 아처 바로 위가 적이 위치하는 마지막 행
        }

    }

    private static void comb(int cnt, int start) {
        if (cnt == 3) {
            debug++;
            // 궁수의 컬럼 리스트 채워짐
            int[][] copyArr = new int[arr.length][arr[0].length];
            for (int i = 0; i < copyArr.length; i++) {
                System.arraycopy(arr[i], 0, copyArr[i], 0, arr[0].length);
            }
            killEnemy(archerCols.clone(), copyArr);
            if (res > maxRes) {
                maxRes = res;
            }
            res = 0;
            return;
        }

        for (int i = start; i <= M; i++) {
            archerCols[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }
}

















