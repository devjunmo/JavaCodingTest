package CT.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1289 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cNum = Integer.parseInt(br.readLine());

        for (int cn = 1; cn <= cNum; cn++) {
            int changeCnt = 0;
            char[] inArr = br.readLine().toCharArray();
//            System.out.println(Arrays.toString(inArr));

            char[] compArr = new char[inArr.length];

            for (int j = 0; j < inArr.length; j++) {
                compArr[j] = '0';
            }

            for (int i = 0; i < inArr.length; i++) {
                if (!myComp(inArr, compArr, i)) {
                    ++changeCnt;
                    char curChar = compArr[i];
                    if (curChar == '0') {
                        for (int j = i; j < inArr.length; j++) {
                            compArr[j] = '1';
                        }
                    } else if (curChar == '1') {
                        for (int j = i; j < inArr.length; j++) {
                            compArr[j] = '0';
                        }
                    }
                }
            }

            System.out.println("#" + cn + " " + changeCnt);

        }

    }

    public static boolean myComp(char[] cArr1, char[] cArr2, int idx) {
        if (cArr1[idx] == cArr2[idx]) {
            return true;
        }else {
            return false;
        }
    }
}
