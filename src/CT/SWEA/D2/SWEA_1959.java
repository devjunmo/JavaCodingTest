package CT.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 두개의 숫자열
public class SWEA_1959 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 1; i <= caseNum; i++) {
            ArrayList<String> nm = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
            int n = Integer.parseInt(nm.get(0));
            int m = Integer.parseInt(nm.get(1));

            ArrayList<String> aj = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
            ArrayList<String> bj = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));

            int res = 0;
            if (aj.size() >= bj.size()) {
                res = alg(bj, aj);
            } else {
                res = alg(aj, bj);
            }

            System.out.println("#" + i + " "+res);

        }
    }

    public static int alg(ArrayList<String> short_arr, ArrayList<String> long_arr) {

        int short_size = short_arr.size();
        int long_size = long_arr.size();

        int pop_count = long_size-short_size;

        int cur_cnt = 0;

        ArrayList<Integer> sum_lst = new ArrayList<>(100);

        while (true) {
            int tmp_sum = 0;
            for (int i = 0; i < short_size; i++) {
                int a_val = Integer.parseInt(short_arr.get(i));
                int b_val = Integer.parseInt(long_arr.get(i));
                tmp_sum += a_val * b_val;
            }

            sum_lst.add(tmp_sum);

            if (cur_cnt == pop_count) {
                break;
            }

            // pop
            long_arr.remove(0);
            cur_cnt++;
        }

        int maxVal = Collections.max(sum_lst);

        return maxVal;

    }
}
