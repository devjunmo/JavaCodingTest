package CT.SWEA.D3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 규영이와인영이의카드게임_6808 {

    static HashSet<Integer> refSet = new HashSet<>(18);
    static HashSet<Integer> kyuSet;
    static HashSet<Integer> inSet;

    static int[] kyuArr;
    static int[] inArr;

    static int[] inNumbers; // 인영이 수열 생성용 배열

    static ArrayList<int[]> permLst;
    static boolean[] isSelected_in; // 인영이 숫자 선택 기록

    static int kyuScore;
    static int inScore;

    static int kyuWin;
    static int kyuLose;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 18; i++) {
            refSet.add(i);
        }

        int TC = sc.nextInt();

        for (int cNum = 1; cNum <= TC; cNum++) {

            kyuArr = new int[9];
            kyuSet = new HashSet<>(9);

            for (int i = 0; i < 9; i++) {
                int tmp = sc.nextInt();
                kyuArr[i] = tmp;
                kyuSet.add(tmp);
            }

            inSet = new HashSet<>(refSet);

            // 차집합으로 인영이 세트 구하기
            inSet.removeAll(kyuSet);

            // 어레이로 바꾸기
            inArr = Arrays.stream(inSet.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();

            inNumbers = new int[9];
            permLst = new ArrayList<>();
            isSelected_in = new boolean[9];

            permSol(0); // 인영이 가능한 숫자조합 생성하여 permList에 add

            kyuWin = 0;
            kyuLose = 0;

            for (int[] curInArr :
                    permLst) {
                kyuScore = 0;
                inScore = 0;

//                System.out.println(Arrays.toString(curInArr));
                for (int i = 0; i < 9; i++) { // 규영 인영 비교

                    if (kyuArr[i] > curInArr[i]) {
                        kyuScore += kyuArr[i] + curInArr[i];
                    }else {
                        inScore += kyuArr[i] + curInArr[i];
                    }

                }

                if (kyuScore > inScore) { // 규영이 이기는 수
                    kyuWin++;
                }else { // 규영이 지는 수
                    kyuLose++;
                }
            }

            System.out.println("#" + cNum + " " + kyuWin + " " + kyuLose);

        }
    }

    // 순열을 구하면서 과반 이상 점수라면 가지치기
    static void permSol(int cnt) {
        if (cnt == 9) {
            permLst.add(inNumbers.clone());
            return;
        }

        for (int i = 0; i < 9; i++) { // 가능한 모든 수에 대해..
            if (isSelected_in[i]) { // 첫번째 수가 사용중이라면
                continue;
            }

            inNumbers[cnt] = inArr[i];
            isSelected_in[i] = true;

            permSol(cnt + 1);
            isSelected_in[i] = false;
        }

    }
}
