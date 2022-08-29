package CT.SWEA.D4;

import java.util.Arrays;
import java.util.Scanner;

public class 준환이의양팔저울_3234 {
    static int wNum, res;
    static int[] weightArr;

    static boolean[] isSelected;

    static int wSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        for (int cNum = 1; cNum <= TC; cNum++) {
            res = 0;
            wNum = sc.nextInt();
            weightArr = new int[wNum]; // 추가 들어갈 배열

            isSelected = new boolean[wNum]; // 순열을 위한..

            for (int i = 0; i < wNum; i++) {
                weightArr[i] = sc.nextInt();
            }

            Arrays.sort(weightArr);

            // 일단 nPn,,, 후 추를 놓아보기
            do {
//				System.out.println(Arrays.toString(weightArr));
                mySubset(0, 0, 0); // 가장 처음에는 left에만 놓을수 있음
            } while (np(weightArr)); // np로 weightArr 바꾸기

            System.out.println("#"+cNum+ " "+res);
        }

    }

    // 가장 먼저 왼쪽에 놓는다
    // 그 다음 왼쪽에 놓을때와 오른쪽에 놓을때로 나눈다.
    // 왼쪽에 놓을때는 그냥 놓으면 됨
    // 오른쪽에 놓을때는 curSum보다 작으면 놓을수 있고, 크면 return한다.
    static void mySubset(int idx, int curLeftSum, int curRightSum) {
        if (idx == wNum) {
            res++;
            return;
        }

        // 왼쪽
        mySubset(idx + 1, curLeftSum + weightArr[idx], curRightSum);

        // 오른쪽
        if (curLeftSum >= curRightSum + weightArr[idx]) { // 지금까지 왼쪽의 합보다 다음게 작아야 오른쪽 놓기 가능
            mySubset(idx + 1, curLeftSum, curRightSum + weightArr[idx]);
        }
    }

//    static void perm(int lev) {
//        if (lev == wNum) {
//            mySubset(0, 0, 0);
//            return;
//        }
//
//        for (int i = 0; i < weightArr.length; i++) {
//
//        }
//    }


    static boolean np(int[] numbers) {

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
