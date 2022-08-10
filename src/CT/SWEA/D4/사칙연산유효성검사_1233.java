package CT.SWEA.D4;

import java.util.Scanner;

public class 사칙연산유효성검사_1233 {

    static String[] nodeValArr;
    static int[] leafNumArr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int TC = 10;

        for (int cNum = 1; cNum <= TC; cNum++) {
//            int nodeCnt = sc.nextInt();
            int nodeCnt = Integer.parseInt(sc.nextLine());
            nodeValArr = new String[nodeCnt + 1]; // 0은 무시하고 1부터

            for (int i = 1; i <= nodeCnt; i++) {
                String inputLine = sc.nextLine();
//                System.out.println(">>>");
//                System.out.println(inputLine);
                String[] inputLineArr = inputLine.split(" ");

                int curIdx = Integer.parseInt(inputLineArr[0]);
                String val = inputLineArr[1];

                nodeValArr[curIdx] = val;

            }

            // 리프노드 찾기
            int n = 0;
            while (true) {

                if (Math.pow(2, n) <= nodeCnt) {
                    n++; // node 카운트에 최대한 가까운 지수승 n값 구하기
                } else {
                    n--;
                    break;
                }
            }

            // 좌측 하단
//            int leftStartLeaf = (int) Math.pow(2, n); // leftStartLeaf ~ nodeCnt

            // last의 부모 노드 넘버
            int lslParent = nodeCnt / 2; // lslParent + 1 ~ last = 리프노드
            int leafStart = lslParent + 1;

//            leafNumArr = new int[nodeCnt - leafStart + 1];
//            int tmpIdx = 0;
//            for (int i = leafStart; i <= nodeCnt; i++) {
//                leafNumArr[tmpIdx] = i;
//                tmpIdx++;
//            }


            // leafNumArr의 수에만 숫자여야 함..

            boolean isEnd = false;

            // 숫자가 아니어야 함
            for (int i = 1; i < leafStart; i++) {
                try {
                    int intVal = Integer.parseInt(nodeValArr[i]);
                    System.out.println("#" + cNum + " " + "0");
                    isEnd = true;
                    break;
                } catch (NumberFormatException numberFormatException) {

                }
            }

            boolean isEnd2 = false;

            if (isEnd) { // 위에서 0 출력됨
                continue;
            }else {
                // 숫자여야 함
                for (int i = leafStart; i < nodeCnt; i++) {
                    try {
                        int intVal = Integer.parseInt(nodeValArr[i]);

                    } catch (NumberFormatException numberFormatException) {
                        System.out.println("#" + cNum + " " + "0");
                        isEnd2 = true;
                        break;
                    }
                }
            }

            if (isEnd2) {
                continue;
            }

            System.out.println("#" + cNum + " " + "1");

        }
    }
}
