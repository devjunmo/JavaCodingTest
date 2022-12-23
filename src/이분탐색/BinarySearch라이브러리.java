package 이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
int res = Arrays.binarySearch(nArr, target);
형태로 사용하면되는데,
값이 존재하면 인덱스를 리턴하고
존재하지 않으면 타겟값을 끼워넣었을 때의 인덱스를 -를 붙이고, '1'부터 시작하는 인덱스로 리턴함
* */

public class BinarySearch라이브러리 {
    static int N;
    static int[] nArr;
    static int M;
    static int[] mArr;
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

        for (int target : mArr) {
            int res = Arrays.binarySearch(nArr, target);
            if (res >= 0) {
                res = 1;
            } else {
                res = 0;
            }
            sb.append(res).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
