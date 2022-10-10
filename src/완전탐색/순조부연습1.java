package 완전탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 순조부연습1 {
    static int N;
    static int R;

    static int[] inputArr;
    static int[] arr;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        inputArr = new int[N];
        for (int i = 0; i < N; i++) {
            inputArr[i] = sc.nextInt();
        }

        arr = new int[R];
        isSelected = new boolean[N];
        System.out.println("##### 순열 #####");
        perm(0);

        arr = new int[R];
        System.out.println("##### 조합 #####");
        comb(0, 0);

        arr = new int[N];
        isSelected = new boolean[N];
        System.out.println("##### 부분집합 #####");
        subset(0);
    }

    static void perm(int lev) {
        if (lev == R) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                arr[lev] = i+1;
                perm(lev + 1);
                isSelected[i] = false;
            }
        }
    }

    static void comb(int lev, int start) {
        if (lev == R) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = start; i < N; i++) {
            arr[lev] = i+1;
            comb(lev + 1, i + 1);
        }
    }

    static void subset(int lev) {
        if (lev == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(isSelected[i]?inputArr[i]:"X");
                System.out.print("\t");
            }
            System.out.println();
            return;
        }

        isSelected[lev] = true; // 선택
        subset(lev + 1);

        isSelected[lev] = false; // 미선택
        subset(lev + 1);
    }
}
