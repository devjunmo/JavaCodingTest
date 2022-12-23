package 이분탐색;

// 5
// 2 4 -10 4 -9
// ans: 2 3 0 3 1

import java.io.*;
import java.util.*;

public class BOJ18870_좌표압축 {

    static int N;
    static int[] arrX;
    static ArrayList<Integer> ans;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arrX = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ans = new ArrayList<>();

        int[] arrXCopy = arrX.clone(); // 정렬 전 원본 백업

        // 1. arrX 정렬
        Arrays.sort(arrX);

        // 2. arrX 중복 제거
        int[] arrNoDup = Arrays.stream(arrX).distinct().toArray();

        // 3. arrX를 돌면서 값에 대해 arrNoDup 이분탐색하여 인덱스 뽑기(인덱스 = 작은애 갯수)

        for (int target : arrXCopy) {
            int bsRst = Arrays.binarySearch(arrNoDup, target);

            if (bsRst >= 0) {
                ans.add(bsRst);
            } else {
                ans.add(0);
            }
        }

        for (int an : ans) {
            sb.append(an).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
