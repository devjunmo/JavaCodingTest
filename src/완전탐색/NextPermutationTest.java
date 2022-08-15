package 완전탐색;

import java.util.Arrays;
import java.util.Scanner;

// 수 배열을 스와핑하여 구현함
// nPn만 가능함.

public class NextPermutationTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        // 전처리: 순열에 쓰일 수들을 오름차순 정렬
        Arrays.sort(input);

        do {
//            System.out.println(Arrays.toString(input));
        } while (np(input));
        System.out.println("finish");

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);

    }

    // numbers 배열의 상태를 근거로 다음 순열 생성,
    // 다음 순열이 존재하면 true, 아니면 false
    public static boolean np(int[] numbers) {

        int N = numbers.length;
        // 1. 꼭대기 찾기
        int i = N - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i]) {--i;}
        if (i==0) {return false;} // 다음 순열을 만들 수 없는 가장 큰 상태

        // 2. 꼭대기의 바로 앞 자리 (i-1)의 값을 크게 만들 교환 값 뒤쪽에서 찾기
        int j = N - 1;
        while (numbers[i - 1] >= numbers[j]) {--j;}

        // 3. i-1의 위치값과 j 위치값 교환
        swap(numbers, i - 1, j);

        // 4. i 위치부터 맨 뒤까지의 수열을 가장 작은 형태의 오름차순으로 변경
        int k = N - 1;
        while (i < k) { swap(numbers, i++, k--); }

        return true; // 다음 순열을 만들 수 있음
    }

    public static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
