package CT.BOJ;

import java.io.*;

public class 도영이가만든맛있는음식_2961 {

    static int[][] sbArr;
    static int N;

    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        sbArr = new int[N][2];
//        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            String[] curSB  = br.readLine().split(" ");
            int S = Integer.parseInt(curSB[0]);
            int B = Integer.parseInt(curSB[1]);
            sbArr[i][0] = S;
            sbArr[i][1] = B;
        }

        mySubset(0, 1, 0); // 신맛은 곱

        bw.write(minDiff + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void mySubset(int index, int sumS, int sumB) {
        if (index == N) {
            if (sumB == 0) {
                return;
            }
            int tmpDiff = Math.abs(sumS - sumB);
            if (minDiff > tmpDiff) {
                minDiff = tmpDiff;
            }
            return;
        }

        // 원소 선택
//        isSelected[index] = true;
        mySubset(index + 1, sumS * sbArr[index][0], sumB + sbArr[index][1]);

        // 원소 미선택
//        isSelected[index] = false;
        mySubset(index + 1, sumS, sumB);

    }
}
