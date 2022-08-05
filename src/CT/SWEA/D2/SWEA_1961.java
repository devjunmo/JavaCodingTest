package CT.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class SWEA_1961 {

    public static BufferedReader br;
    public static int N;

    public static String[][] inputArr;
    public static String[][] resArr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int cNum = Integer.parseInt(br.readLine());

        for (int cn = 1; cn <= cNum; cn++) {
            N = Integer.parseInt(br.readLine());

            inputArr = new String[N][N];
            resArr = new String[N][N];

            for (int i = 0; i < N; i++) {
                inputArr[i] = br.readLine().split(" "); // 스트링 2차원 배열 받음
            }

            String[][] rot90 = rot(inputArr);
            String[][] rot180 = rot(rot90);
            String[][] rot270 = rot(rot180);

            System.out.println("#" + cn);

            for (int n = 0; n < N; n++) {
                String[] r90 = rot90[n];
                String[] r180 = rot180[n];
                String[] r270 = rot270[n];

                for (int q = 0; q < N; q++) {
                    System.out.print(r90[q]);
                }
                System.out.print(" ");
                for (int q = 0; q < N; q++) {
                    System.out.print(r180[q]);
                }
                System.out.print(" ");
                for (int q = 0; q < N; q++) {
                    System.out.print(r270[q]);
                }
                System.out.print("\n");
            }
        }
    }

    public static String[][] rot(String[][] inArr) {
        int curPtr = 0;
        String[] tmpArr = new String[N * N];
        String[][] returnArr = new String[N][N];

        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                String curVal = inArr[i][j];
                tmpArr[curPtr] = curVal;
                curPtr++;
            }
        }
        curPtr = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                returnArr[i][j] = tmpArr[curPtr];
                curPtr++;
            }
        }

        return returnArr;
    }
}














