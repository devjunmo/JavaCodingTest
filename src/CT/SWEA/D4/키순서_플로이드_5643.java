package CT.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 키순서_플로이드_5643 {

    static int N;
    static int M;
    static int ans;

    static int[][] adjArr;


    static class FromTo{
        int from;
        int to;

        public FromTo(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "(" + from + "," + to + ")";
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int cNum = 0; cNum < TC; cNum++) {

            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            adjArr = new int[N+1][N+1]; // 1부터라

            ans = 0;


            for(int i=0;i<M;i++) {
                int[] adjInfo = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                adjArr[adjInfo[0]][adjInfo[1]] = 1; // 바로 갈 수 있으면 1로 초기화
            }

//            System.out.println(Arrays.deepToString(adjArr));
//            System.out.println();

            for (int k = 1; k < N+1; k++) {
                for (int i = 1; i < N+1; i++) {
                    for (int j = 1; j < N+1; j++) {
                        if (adjArr[i][k]==1 && adjArr[k][j]==1) {
                            // 경유해서 갈 수 있으면 갈수있다고 처리해준다
                            adjArr[i][j] = 1;
                        }
                    }
                }
            }

//            System.out.println(Arrays.deepToString(adjArr));

            for (int i = 1; i <= N; i++) {
                int tmpSum = 0;
                for (int j = 1; j <= N; j++) {
                    int tmpVal = adjArr[j][i];
                    int tmpVal2 = adjArr[i][j];
                    if (tmpVal == 1) {
                        tmpSum++;
                    }
                    if (tmpVal2 == 1) {
                        tmpSum++;
                    }
                }
                if (tmpSum == N - 1) {
                    ans++;
                }
            }

            System.out.println("#" + (cNum+1) + " " + ans);
        }

    }


}



















