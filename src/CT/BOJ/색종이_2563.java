package CT.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class 색종이_2563 {
    static int[][] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        arr = new int[110][110]; // 0으로 초기화 되어 있음

        int TC = sc.nextInt();

        for (int cNum = 0; cNum < TC; cNum++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int i = 0; i < 10; i++) { // 길이 10
                for (int j = 0; j < 10; j++) {
                    arr[x+i][y+j] = 1;
                }
            }

        }

        int res = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                res += arr[i][j];
            }
        }

        System.out.println(res);
    }
}
