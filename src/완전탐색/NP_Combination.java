package 완전탐색;

public class NP_Combination {
    public static void main(String[] args) {

        long res = 1;

        for (int i = 1; i <= 14; i++) {
            res *= i;
        }

        System.out.println(res);

    }
}
