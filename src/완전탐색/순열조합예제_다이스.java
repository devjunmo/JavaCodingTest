package 완전탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 순열조합예제_다이스 {

    static int N, totalCnt; // N: 주사위 수, totalCnt: 경우의수 카운트
    static int[] numbers;

    static boolean[] isSelected; // 0~6으로 만들어서 인덱스와 주사위 눈을 일치 시키기

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 던지는 주사위 수

        int mode = sc.nextInt(); // 던지기 모드

        numbers = new int[N];

        switch (mode) {
            case 1:
                dice1(0); // 중복순열
                break;
            case 2:
                isSelected = new boolean[7];
                dice2(0); // 순열
                break;
            case 3:
                dice3(0, 1); // 중복조합
                break;
            case 4:
                dice4(0, 1); // 조합
                break;
            default:
                return;
        }

        System.out.println("총 경우의 수: " + totalCnt);
    }

    // 중복순열 (중복 허용 + 순서 의미 있음)
    private static void dice1(int cnt) {

        if (cnt == N) {
            totalCnt++; // 원하는 답이 나올때마다 카운트 누적
            System.out.println(Arrays.toString(numbers));
            return;
        }

        // 가능한 모든 수 시도
        for (int i = 1; i <= 6; i++) {
            // 중복체크 필요 x. 그냥 숫자 선택
            numbers[cnt] = i;

            // 다음 주사위 던지기
            dice1(cnt + 1);
        }
    }

    // 순열 (중복 허용 X + 순서 의미 있음)
    private static void dice2(int cnt) {

        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        // 가능한 모든 수 시도
        for (int i = 1; i <= 6; i++) {
            // 중복체크 필요함
            if (isSelected[i]) {
                continue;
            }

            numbers[cnt] = i;
            isSelected[i] = true;

            // 다음 주사위 던지기
            dice2(cnt + 1);
            isSelected[i] = false;
        }
    }

    // 중복 조합
    private static void dice3(int cnt, int start) {
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            dice3(cnt + 1, i); // 내가 뽑은 수부터 뽑는다
        }
    }

    // 조합 -> 앞에서 뽑은 수의 다음 수부터 뽑는다
    private static void dice4(int cnt, int start) {
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            dice4(cnt + 1, i + 1);
        }
    }
}






