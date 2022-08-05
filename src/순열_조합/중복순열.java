package 순열_조합;

import java.util.Arrays;
import java.util.Scanner;

public class 중복순열 {
    static int N, totalCnt;
    static int[] numbers;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int mode = sc.nextInt();

        totalCnt = 0;
        numbers = new int[N];

        switch (mode) {
            case 1:
                dice1(0);
                break;
            case 2:
                isSelected = new boolean[7]; // 주사위 1~6
                dice2(0);
                break;
            case 3:
                dice3(0,1);
                break;
            case 4:
                dice4(0,1);
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                return;
        }

        System.out.println("총 경우의 수: " + totalCnt);
    }


    // 주사위 던지기 1: 중복 순열
    private static void dice1(int cnt) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        // 가능한 모든 수 시도 (주사위 눈 1~6)
        for (int i = 0; i <= 6; i++) {
            // 수의 중복 선택이 가능하므로 중복 체크 필요없음
            // 해당 수 선택
            numbers[cnt] = i;
            // 다음 주사위 던지기
            dice1(cnt + 1);
        }
    }

    // 주사위 던지기2: 순열
    private static void dice2(int cnt) {
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
        }

        // 가능한 모든 수 시도 (주사위 눈 1~6)
        for (int i = 1; i <= 6; i++) {
            // 중복체크 필요
            if (isSelected[i]) {
                continue;
            }

            // 해당 수 선택
            numbers[cnt] = i;
            isSelected[i] = true;
            // 다음 주사위 던지기
            dice2(cnt+1);
            isSelected[i] = false;
        }
    }

    // 주사위 던지기 3: 중복조합

    private static void dice3(int cnt, int start) {
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
        }

        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            dice3(cnt+1, i);
        }
    }

    // 주사위 던지기 4: 조합

    private static void dice4(int cnt, int start) {
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
        }

        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            dice4(cnt+1, i+1);
        }
    }

    //
}
