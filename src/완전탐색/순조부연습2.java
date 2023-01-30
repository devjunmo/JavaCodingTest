package 완전탐색;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class 순조부연습2 {

    static int N;
    static int R;
    static int[] arr;
    static int[] ans;
    static boolean[] vis;


    static void subset(int lev){
        if (lev == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(vis[i]?arr[i]:"X");
                System.out.print("\t");
            }
            System.out.println();
            return;
        }

        vis[lev] = true;
        subset(lev + 1);

        vis[lev] = false;
        subset(lev + 1);
    }

    static void comb(int lev, int start){
        if (lev == R) {
            System.out.println(Arrays.toString(ans));
            return;
        }

        for (int i = start; i < N; i++) {
            ans[lev] = arr[i];
            comb(lev+1, i+1);
        }

    }

    static void perm(int lev){
        if (lev == R) {
            System.out.println(Arrays.toString(ans));
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!vis[i]){
                vis[i] = true;
                ans[lev] = arr[i];
                perm(lev+1);
                vis[i] = false;
            }

        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        vis = new boolean[N];
        ans = new int[R];

//        perm(0);
//        comb(0, 0);
        subset(0);

        br.close();
        bw.flush();
        bw.close();
    }
}
