package 완전탐색;

import java.util.Scanner;

public class subset {
    static int N, totalCnt;
    static int[] input;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // 숫자 배열과 선택 배열의 인덱스를 매칭
        input = new int[N];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        mySubset(0);
        System.out.println("총 경우의 수: " + totalCnt);
    }

    private static void mySubset(int index) {

        if (index == N) {
            totalCnt++;
            for (int i = 0; i < N; i++) {
                System.out.print(isSelected[i] ? input[i] : "X");
                System.out.print("\t");
            }
            System.out.println();
            return;
        }

        // 원소 선택
        isSelected[index] = true;
        mySubset(index + 1);

        // 원소 미선택
        isSelected[index] = false;
        mySubset(index + 1);
    }
}
