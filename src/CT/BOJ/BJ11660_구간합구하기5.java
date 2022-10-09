package CT.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11660_구간합구하기5 {

    static int[][] arr;
    static int[][] sumArr;

    static int backRow;
    static int backCol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");

        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        arr = new int[N+1][N+1]; // 제로 패딩

        for (int i = 1; i <= N; i++) {
//			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] tmpLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < tmpLine.length; j++) {
                arr[i][j+1] = tmpLine[j];
            }
        }

        // sum arr 만들기
        sumArr = new int[N+1][N+1]; // 제로 패딩

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if(i==0 && j==0) {
//					sumArr[i][j] = arr[i][j];
//					backRow = i;
//					backCol = j; // 다음 루프에서 직전 요소에 접근하기 위해 저장
//
//				}else {
//					sumArr[i][j] = sumArr[backRow][backCol] + arr[i][j];
//					backRow = i;
//					backCol = j;
//				}
//			}
//		}

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
//				System.out.println(arr[i][j]);
                sumArr[i][j] = sumArr[i][j-1] + sumArr[i-1][j] - sumArr[i-1][j-1] + arr[i][j];

            }
        }
//		System.out.println(Arrays.deepToString(sumArr));



        // 타겟 영역 합 구하기

        for (int i = 0; i < M; i++) {

            String[] posInfo = br.readLine().split(" ");

            int x1 = Integer.parseInt(posInfo[0]);
            int y1 = Integer.parseInt(posInfo[1]);

            int x2 = Integer.parseInt(posInfo[2]);
            int y2 = Integer.parseInt(posInfo[3]);

            int starX1 = x1; // 우측 상단 꼭지점
            int starY1 = y2;

            int starX2 = x2; // 좌측 하단 꼭지점
            int starY2 = y1;

            int loopCnt = x2 - x1 + 1;

            int mySum = 0;

//			int sum1 = sumArr[starX1][starY1] - sumArr[x1][y1] + arr[x1][y1];
//			int sum2 = sumArr[x2][y2] - sumArr[starX2][starY2] + arr[starX2][starY2];
            if(x2==x1 && y2==y1) {
                mySum = arr[x2][y2];
            }else if (x1==0 && y1==0) {
                mySum = sumArr[x2][y2];
            }else {
                mySum = sumArr[x2][y2] - sumArr[starX2][starY2-1] - sumArr[starX1-1][starY1] + sumArr[x1-1][y1-1];
            }

            sb.append(mySum).append("\n");

        }

        System.out.println(sb.toString());

    }


    static int getArrSum(int i, int j) {
        int tmpSum = 0;

        for (int k = 0; k <= i; k++) {
            for (int k2 = 0; k2 <= j; k2++) {
                tmpSum += arr[k][k2];
            }
        }

        return tmpSum;
    }


}












