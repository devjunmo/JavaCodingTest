package CT.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스위치켜고끄기_1244 {

    public static String[] swArr;
    public static int swArrSize;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        swArrSize = Integer.parseInt(br.readLine());
        swArr = br.readLine().split(" ");

        int studNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < studNum; i++) {
            String[] studInput = br.readLine().split(" ");
            int sex = Integer.parseInt(studInput[0]);
            int getNum = Integer.parseInt(studInput[1]);

            switch (sex) {
                case 1: boy(getNum);
                    break;
                case 2: girl(getNum);
                    break;
                default:
                    break;
            }
        }

//        for (String s :
//                swArr) {
//            System.out.print(s + " ");
//        }

//        for (int i = 0; i < swArrSize; i++) {
//            if (i == 0) {
//                System.out.print(swArr[i] + " ");
//            } else if (i % 19 == 0) {
//                System.out.println(swArr[i]);
//            } else if (i == swArrSize - 1) {
//                System.out.print(swArr[i]);
//            } else {
//                System.out.print(swArr[i] + " ");
//            }
//        }

        int outCnt = 1;

        for (int i = 0; i < swArrSize; i++) {
            System.out.print(swArr[i] + " ");
            if (outCnt % 20 == 0) {
                System.out.println();
            }
            outCnt++;
        }

    }

    private static void boy(int getNum) {
        for (int i = 1; i <= swArrSize; i++) {
            if (i % getNum == 0) {
                if (swArr[i - 1].equals("0")) {
                    swArr[i - 1] = "1";
                } else if (swArr[i - 1].equals("1")) {
                    swArr[i - 1] = "0";
                }
            }
        }
    }

    private static void girl(int getNum) {
        int getIdx = getNum - 1;
        int leftIdx = getIdx - 1;
        int rightIdx = getIdx + 1;

        while (leftIdx >= 0 && rightIdx < swArrSize) {
            if (swArr[leftIdx].equals(swArr[rightIdx])) { // 대칭이 같으면
                leftIdx--; // 확장
                rightIdx++;
                if (leftIdx < 0 || rightIdx >= swArrSize) { // 확장했는데 out of range면
                    leftIdx++;
                    rightIdx--; // 되돌리고
                    for (int i = leftIdx; i <= rightIdx; i++) {
                        if (swArr[i].equals("0")) {
                            swArr[i] = "1";
                        } else if (swArr[i].equals("1")) {
                            swArr[i] = "0";
                        }
                    }
                    break;
                }

            } else { // 대칭이 틀리면
                leftIdx++;
                rightIdx--;
                for (int i = leftIdx; i <= rightIdx; i++) {
                    if (swArr[i].equals("0")) {
                        swArr[i] = "1";
                    } else if (swArr[i].equals("1")) {
                        swArr[i] = "0";
                    }
                }
                break;
            }
        }


    }

}
