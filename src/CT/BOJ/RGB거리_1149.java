package CT.BOJ;

import java.io.*;
import java.util.Arrays;

/*
3
26 40 83
49 60 57
13 89 99
 */

public class RGB거리_1149 {
    static int N;
    static int[][] rgbInputcosts;

    static int[][] floorRGBMinVals; // 행: 층 / 열: r, g, b

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        N = Integer.parseInt(br.readLine());
//        rgbInputcosts = new int[N][N];
//        floorRGBMinVals = new int[N][N];
//
//        for (int i = 0; i < N; i++) {
//            rgbInputcosts[i] = Arrays.stream(br.readLine().split(" "))
//                    .mapToInt(Integer::parseInt).toArray();
//        }
//
//        // System.out.println(Arrays.deepToString(rgbInputNums));
//
//        dfs(0, -1, 0);
//
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//
//    static void dfs(int cnt, int behindIdx, int curSum){
//        if (cnt == 3) {
//            return;
//        }
//
//        // rgb 컬럼 3개
//        for (int i = 0; i < 3; i++) {
//            if (floorRGBMinVals[cnt][i]){
//
//            }
//            if (i == behindIdx) {
//                continue;
//            }
//            int nextSum = curSum + rgbInputcosts[cnt][i];
//            if (nextSum < floorRGBMinVals[cnt][i]) {
//                floorRGBMinVals[cnt][i] = nextSum;
//            }
//
//
//
//        }
//
////        dfs(cnt + 1, behindIdx);

    }
}
