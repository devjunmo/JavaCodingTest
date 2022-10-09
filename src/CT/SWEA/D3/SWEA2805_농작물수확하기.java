package CT.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA2805_농작물수확하기 {

    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int cNum = 1; cNum <= TC; cNum++) {
            int N = Integer.parseInt(br.readLine());

            // int[] buildingArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            arr = new int[N][N];

            // 2차원 어레이 받기
            for (int i = 0; i<N; i++) {
                String tmpStr = br.readLine();
                char[] tmpChars = tmpStr.toCharArray();
                int tmpSize = tmpChars.length;

                int[] tmpIntArr = new int[tmpSize];

                for (int j = 0; j < tmpSize; j++) {
                    tmpIntArr[j] = Character.getNumericValue(tmpChars[j]);
//					System.out.println(tmpIntArr[j]);
                }
                arr[i] = tmpIntArr;
            }

//			System.out.println(Arrays.deepToString(arr));

            int rst = myProcess(N);

            System.out.println("#"+cNum + " " + rst);

        }

    }

    public static int myProcess(int N) {
        int sum = 0;
        int midCol = N/2;
        int left = midCol;
        int right = midCol;

        for (int i = 0; i < N; i++) {
            // 행 절반 이하일때
            if(i<=(int)(N/2)) {
                for (int p = left; p <= right; p++) {
                    sum += arr[i][p];
                }
                if(i != (N/2)) {
                    left--;
                    right++;
                }else {
                    left++;
                    right--;
                }

            }else {
                for (int p = left; p <= right; p++) {
                    sum += arr[i][p];
                }
                left++;
                right--;
            }
        }

        return sum;
    }


}


