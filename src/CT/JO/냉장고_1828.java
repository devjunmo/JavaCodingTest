package CT.JO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 냉장고_1828 {

    static int N;
    static int[][] inputArr;

    static int refCnt = 1;

    static ArrayList<Chem> chemLst = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] minmax = br.readLine().split(" ");
            chemLst.add(new Chem(Integer.parseInt(minmax[0]), Integer.parseInt(minmax[1])));
        }

        Collections.sort(chemLst); // 오름차순 정렬

        // 2중 루프로 nCr 구현
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int refMin = chemLst.get(i).minT;
                int refMax = chemLst.get(i).maxT;

                int curMin = chemLst.get(j).minT;
                int curMax = chemLst.get(j).maxT;

                if ((refMin<=curMin && curMin<=refMax) ||
                        (refMin<=curMax && curMax<=refMax)){
                    // 양 극단이 레퍼런스에 포함 된다면
//                    continue;
                }else{
                    // 하나도 포함 되지 않는다면..
                    refCnt++;
                    break;
                }
            }
        }

        bw.write(refCnt+"\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static class Chem implements Comparable<Chem> {

        int minT;
        int maxT;

        public Chem(int minT, int maxT) {
            this.minT = minT;
            this.maxT = maxT;
        }

        @Override
        public int compareTo(Chem o) {
            return this.minT - o.minT; // 오름차순 (양수면 오른쪽에 있는 애가 먼저옴)
        }
    }
}
