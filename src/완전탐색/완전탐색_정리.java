package 완전탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 완전탐색_정리 {
    static int N,R, input[], numbers[]; // input: 입력 배열, numbers: 순열, 조합에 선택된 수 배열
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        numbers = new int[R];
        isSelected = new boolean[N];


        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        System.out.println("=========순열=========");
        perm(0);

        numbers = new int[R];
        System.out.println("=========조합=========");
        comb(0, 0);

        numbers = new int[R];
        isSelected = new boolean[N];
        System.out.println("=======부분집합=======");
        subset(0);
    }

    static void perm(int lev) {
        if (lev == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                numbers[lev] = i;
                perm(lev + 1);
                isSelected[i] = false;
            }
        }
    }

    static void comb(int lev, int start) {
        if (lev == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[lev] = i;
            comb(lev + 1, i + 1);
        }
    }

    static void subset(int lev) {
        if (lev == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(isSelected[i]?input[i]:"X");
                System.out.print("\t");
            }
            System.out.println();
            return;
        }

        isSelected[lev] = true;
        subset(lev + 1);

        isSelected[lev] = false;
        subset(lev + 1);
    }
}

