package CT.BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11659_구간합구하기4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");

        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // j에서 i-1번째 누적합 빼주면 된다.

        int[] sumStackArr = new int[numArr.length];
        sumStackArr[0] = numArr[0];

        for (int i = 1; i < numArr.length; i++) {
            sumStackArr[i] = sumStackArr[i-1] + numArr[i];
        }

//		System.out.println(Arrays.toString(sumStackArr));

        for (int m = 0; m < M; m++) {
            String[] ij = br.readLine().split(" ");

            int i = Integer.parseInt(ij[0])-1; // 문제의 첫번째 = 배열의 영번째
            int j = Integer.parseInt(ij[1])-1;

            int sum = 0;

            if((i-1)<0) {
                sum = sumStackArr[j];
            }else {
                sum = sumStackArr[j] - sumStackArr[i-1];
            }

            sb.append(sum).append("\n");
//			System.out.println(sum);
        }

        System.out.println(sb.toString());

    }

}
