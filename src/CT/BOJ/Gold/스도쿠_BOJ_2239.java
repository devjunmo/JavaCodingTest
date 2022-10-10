package CT.BOJ.Gold;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 스도쿠_BOJ_2239 {
    static int[][] sMap;
    static int[][] ans;
    static List<Coor> zeroCoors;
    static StringBuilder sb;

    static class Coor {
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
//        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sMap = new int[9][9];
        ans = new int[9][9];
        zeroCoors = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 9; j++) {
                int tmpVal = Character.getNumericValue(tmp.charAt(j));
                sMap[i][j] = tmpVal;
                if (tmpVal == 0) {
                    zeroCoors.add(new Coor(i, j));
                }
            }
        }
//        System.out.println("zeroCoors = " + zeroCoors);
//        System.out.println("sMap = " + Arrays.deepToString(sMap));

        dfs(0);



//        // 출력
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                bw.write(ans[i][j]+"");
//            }
//            bw.write("\n");
//        }

//        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
//        System.out.println("시간차이(m) : "+secDiffTime);

    }

    private static void dfs(int lev) {

        if (lev == zeroCoors.size()) {
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    ans[i][j] = sMap[i][j];
//                }
//            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sMap[i][j]);
                }
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.print(sb.toString());
            System.exit(0);
            return;
        }

        // 넣을 수 있는 숫자 찾기
        boolean[] usingNums = new boolean[10]; // 1 ~ 9 자리 쓰려고

        int curX = zeroCoors.get(lev).row;
        int curY = zeroCoors.get(lev).col;

        // 세로 체크
        for (int i = 0; i < 9; i++) {
            if (sMap[i][curY] != 0) { // 0이 아닌값은 사용중이므로 true
                usingNums[sMap[i][curY]] = true;
            }
        }

        // 가로 체크
        for (int i = 0; i < 9; i++) {
            if (sMap[curX][i] != 0) {
                usingNums[sMap[curX][i]] = true;
            }
        }

        // 3x3 체크
        int rowQuo = curX / 3;
        int colQuo = curY / 3;

        int rowStart = 3 * rowQuo;
        int colStart = 3 * colQuo;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (sMap[i][j] != 0) {
                    usingNums[sMap[i][j]] = true;
                }
            }
        }

//        usingNums가 false인 수를 넣을 수 있음
        for (int i = 1; i < 10; i++) {
            if (!usingNums[i]) { // 둘곳이 없다면 추가적인 재귀를 못타고 종료됨
                sMap[curX][curY] = i;
                dfs(lev + 1);
                sMap[curX][curY] = 0;

            }
        }

    }
}
