package CT.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 누적합 알고리즘으로 풀어보기
public class SWEA_2001_파리퇴치 {

    static int[][] flyArr;
    static int[][] sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int cNum = 1; cNum <= TC; cNum++) {
            String[] nm = br.readLine().split(" ");
            int N = Integer.parseInt(nm[0]);
            int M = Integer.parseInt(nm[1]);

            flyArr = new int[N + 1][N + 1];
            sumArr = new int[N + 1][N + 1];

//            int[] inArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 제로 패딩된 input arr 생성
            for (int i = 1; i <= N; i++) {
                int[] inArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < N; j++) {
                    flyArr[i][j+1] = inArr[j];
                }
            }


            // sumArr 채우기
            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] + flyArr[i][j] - sumArr[i - 1][j - 1];
                }
            }

            // 파리채 사이즈에 따른 sumArr 범위를 정하고 최대값 찾기
            // m=2면.. i=2, j=2 ~ 끝까지

            int maxVal = 0;

            for (int i = M; i < sumArr.length; i++) {
                for (int j = M; j < sumArr.length; j++) {
                    // 현재 sum값 - (보존하고 싶은 만큼 남기고 나머지 sum값 제거) + 중복으로 제거된값 더하기 (그림: 태블릿 참조)
                    int curVal = sumArr[i][j] - (sumArr[i][j-M] + sumArr[i-M][j]) + sumArr[i-M][j-M];
                    if (curVal >= maxVal) {
                        maxVal = curVal;
                    }
                }
            }

            System.out.println("#"+cNum+" "+maxVal);

        }
    }

}
