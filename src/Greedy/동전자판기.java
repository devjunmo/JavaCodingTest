package Greedy;

import java.util.Scanner;

public class 동전자판기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetMoney = sc.nextInt();

        int[] units = {500, 100, 50, 5, 1};
        int[] counts = {
                sc.nextInt(), sc.nextInt(), sc.nextInt(),
                sc.nextInt(), sc.nextInt(), sc.nextInt()};

        int totalMoney = 0;
        for (int i = 0, size = units.length; i < size; i++) {
            // 보유한 동전들로 만들 수 있는 총 금액
            totalMoney += units[i] * counts[i];
        }

        // 갖고있는 돈에서 음료수 값을 지불하고 남은 나머지 금액
        int remainMoney = totalMoney - targetMoney;

        // 음료수 값을 지불하는데 동전을 최대로 사용하려면,
        // 지불하고 남는 금액의 동전수를 최소로!
        int sum = 0, maxCnt, availCnt;
        for (int i = 0, size = units.length; i < size; i++) {
            maxCnt = remainMoney / units[i]; // 해당 금액을 i 화폐단위를 가장 많이 쓸때 수
            availCnt = Math.min(maxCnt, counts[i]);

            counts[i] -= availCnt; // 사용되고 남은 갯수
            remainMoney -= availCnt * units[i];

            sum += counts[i]; // 사용되고 남은 동전이 지불하기 위해 사용될 동전 수
        }
        System.out.println(sum); // 음료수 값을 지불하기 위해 사용된 동전 수

        for (int i = 0, size = counts.length; i < size; i++) {
            System.out.println(counts[i] + " ");
        }
    }
}
