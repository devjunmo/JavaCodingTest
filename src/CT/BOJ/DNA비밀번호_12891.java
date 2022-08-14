package CT.BOJ;

/*
9 8
CCTGGATTG
2 0 1 1
 */

import java.io.*;
import java.util.Arrays;

public class DNA비밀번호_12891 {
    static int S, P;
    static char[] inputDNAArr;

    static char[] AGTC = {'A', 'G', 'T', 'C'};
//    static int refA, refC, refG, refT;
    static int[] acgtRefNums;
    static int curA, curC, curG, curT; // 현재 스트링 인덱스 까지의 염기 갯수
    static int[][] agtcCntArr; // 문자열 현재 인덱스의 ACGT 갯수 누적 카운팅

    static int res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp = br.readLine().split(" ");
        
        S = Integer.parseInt(sp[0]);
        P = Integer.parseInt(sp[1]);

        agtcCntArr = new int[4][S];
        inputDNAArr = br.readLine().toCharArray();
        acgtRefNums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//        refA = acgtNums[0]; refC = acgtNums[1]; refG = acgtNums[2]; refT = acgtNums[3];


        // agtcCntArr 채우기
        for (int i = 0; i < S; i++) {
            char curBase = inputDNAArr[i]; // 현재 염기
            switch (curBase) {
                case 'A':
                    curA++;
                    break;
                case 'C':
                    curC++;
                    break;
                case 'G':
                    curG++;
                    break;
                case 'T':
                    curT++;
                    break;
                default:
                    break;
            }
            
            // 누적 데이터 넣어주기
            agtcCntArr[0][i] = curA;
            agtcCntArr[1][i] = curC;
            agtcCntArr[2][i] = curG;
            agtcCntArr[3][i] = curT;
        }

        for (int j = 0; j < S; j++) { // 열 인덱스
//            bw.write(res+"<<<\n");
            boolean trigger =  true;
            if (j == 0) {
                for (int i = 0; i < 4; i++) { // 행 인덱스
                    if (!(acgtRefNums[i] <= agtcCntArr[i][P-1])) { // acgt가 기준 이상이 아니라면..
                        trigger = false;
                        break;
                    }
                }
            } else {
                if (j + P - 1 >= S) { // 문자열의 범위가 정상범위로 체크하지 않는다면..
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    if (!(acgtRefNums[i] <= (agtcCntArr[i][j+P-1] - agtcCntArr[i][j-1]))) { // acgt가 기준 이상이 아니라면..
                        trigger = false;
                        break;
                    }
                }
            }
            if (trigger) {
                res++;
            }
        }

        bw.write(res + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
