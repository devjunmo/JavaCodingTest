package 이분탐색;

/*
시작시간: 4:33 ~ 5:08
5
4 1 5 2 3
5
1 3 7 9 5
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_1920_수찾기 {
    static int N;
    static int[] nArr;
    static int M;
    static int[] mArr;

    static int binarySearch(int target, int start, int end) {
        if (start > end) {
            return 0; // 없다
        }

        int mid = (start + end) / 2;

        if (nArr[mid] < target) {
            return binarySearch(target, mid + 1, end);
        } else if (nArr[mid] > target) {
            return binarySearch(target, start, mid - 1);
        } else { // mid의 value가 target이랑 일치할 경우
            return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // N 숫자열에 대해
        N = Integer.parseInt(br.readLine());
        nArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 정렬
        Arrays.sort(nArr);

        // M에 해당하는 수가 있는가
        M = Integer.parseInt(br.readLine());
        mArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int m : mArr) {
            int res = binarySearch(m, 0, N-1);
            sb.append(res).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}













