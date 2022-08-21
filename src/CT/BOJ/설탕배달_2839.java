package CT.BOJ;

import java.util.Scanner;

/*
5검사 = 5로 나누고 3으로 나눠떨어지는지 검사
3을 빼가면서 5검사하기
 */
public class 설탕배달_2839 {
    static int ans = 0;
    static int N = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        while (true) {
            if (N <= 0) { // N이 영보다 작을때
                ans = -1;
                System.out.println(ans);
                break;
            }

            int quot5 = N/5;
            int rem5 = N%5;

            if (check(quot5, rem5)){
                System.out.println(ans);
                break;
            }
        }
    }

    public static boolean check(int q5, int r5) { // 5로 나눈 정보들이 3으로 나누어 떨어지는지 체크
        if (r5 % 3 == 0) {
            ans += q5 + (r5 / 3);
            return true;
        }else {
            // 3빼고 다시 검사하기 위한 코드
            N -= 3;
            ans++;
            return false;
        }
    }
}
