package CT.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 어디에 단어가

public class SWEA_1979 {
//    public static char[][] charArr;

    public static int[][] intArr;
    public static boolean trigger;
    public static int curCnt;

    public static int res;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNumber = Integer.parseInt(br.readLine());

        for (int cn = 1; cn <= caseNumber; cn++) {
            res = 0;
            ArrayList<String> nm = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
            int n = Integer.parseInt(nm.get(0));
            int k = Integer.parseInt(nm.get(1));

//            charArr = new char[n][n];
            intArr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] strs = Arrays.asList(br.readLine().split(" ")).toArray(new String[n]);
                intArr[i] = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
            }

            // 첫번째 순회
            for (int i = 0; i < n; i++) {
                trigger = false;
                curCnt = 0;
                for (int j = 0; j < n; j++) {
                    alg(i, j, k);
                }

                if (curCnt == k) {
                    res++;
                }
            }

            // 두번째 순회
            for (int i = 0; i < n; i++) {
                trigger = false;
                curCnt = 0;
                for (int j = 0; j < n; j++) {
                    alg(j, i, k);
                }

                if (curCnt == k) {
                    res++;
                }
            }

            System.out.println("#" + cn + " " + res);


        }
    }

    public static void alg(int row, int col, int k) {
        if (!trigger && intArr[row][col] == 1) {
            trigger = true;
            curCnt++;
        } else if (trigger && intArr[row][col] == 0) {
            trigger = false;
            if (curCnt == k) {
                res++;
            }
            curCnt = 0;
        } else if (trigger && intArr[row][col] == 1) {
            curCnt++;
        }
    }
}
