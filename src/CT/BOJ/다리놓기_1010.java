package CT.BOJ;

import java.io.*;

public class 다리놓기_1010 {

    static int N;
    static int M;
    static int[] nArr;
    static int res;

    public static void main(String[] args) throws IOException {
        // 조합인데.. n이 30 이상..
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] nm = br.readLine().split(" ");
            N = Integer.parseInt(nm[0]);
            M = Integer.parseInt(nm[1]); // M C N 조합..
            res = 0;

            comb(0, 1);

            bw.write(res + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    static void comb(int cnt, int start) {
        if (cnt == N) { // N개 뽑
            res++;
            return;
        }

        for (int i = start; i <= M; i++) {
            comb(cnt + 1, i + 1);
        }



    }
}
