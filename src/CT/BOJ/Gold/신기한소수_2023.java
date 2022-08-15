package CT.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 특정 자리수의 모든 수를 소수 체크 하면 시간초과
// 재귀로 앞에서부터 소수를 만들면서 소수체크 하기
public class 신기한소수_2023 {
    static int N;
    static StringBuilder sb;

    static boolean checkPrimeNum(int num) {
        boolean isTrue = true;
        // 1 ~ num의 제곱근까지만 본다
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) { // num 전에꺼랑 나누어 떨어지면
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }

    public static void recurSol(int cnt, int curVal) {
        if (cnt == N) {
            sb.append(curVal).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i++) { // 가능한 모든 수 체크
            int tmpVal = 10 * curVal + i;
            if (checkPrimeNum(tmpVal)) {  // 소수면 다음 자리 진행
                recurSol(cnt+1, tmpVal);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        // 첫번째 자리 수 = 2, 3, 5, 7
        int[] firstVal = {2, 3, 5, 7};
        for (int curVal:
             firstVal) {
            recurSol(1, curVal);
        }

        System.out.println(sb.toString());

    }
}
