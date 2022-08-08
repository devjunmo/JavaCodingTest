package CT.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class SWEA_9229_한빈이와SpotMart {

    static int[] gArr;
    static int N;
    static int M;

    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int cNum = 1; cNum <= TC; cNum++) {

            res = 0;

            String[] nm = br.readLine().split(" ");

            N = Integer.parseInt(nm[0]);
            M = Integer.parseInt(nm[1]);

            gArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(gArr); // 정렬

//            System.out.println("M= "+ M);
//            System.out.println(Arrays.toString(gArr));

            mySol(gArr.length - 1);

            if (res == 0) { // 해당하는 케이스가 없으면
                res = -1;
            }

            System.out.println("#"+cNum+" "+res);
        }
    }

    static void mySol(int curLastIdx) {
        if (curLastIdx == 0) {
            return;
        }

        if (gArr[curLastIdx] < M && gArr[curLastIdx] + gArr[0] <= M) { // 가장 큰 값이 M보다 작으면서 첫요소랑 더했을때 M보다 작다면  돌아볼 가치 있다
            for (int i = 1; i <= curLastIdx; i++) {
                int tmpSum = gArr[curLastIdx - i] + gArr[curLastIdx];
                if (tmpSum <= M && tmpSum > res) {
                    res = tmpSum;
                }
            }
            mySol(curLastIdx - 1);
        } else {
            mySol(curLastIdx - 1);
        }
    }

}
