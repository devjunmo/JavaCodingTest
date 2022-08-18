package CT.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Stack;

public class 쿼드트리_1992 {

    static int N;
    static int[][] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - 48; // 인풋 배열 만들기
            }
        }

        div(0, 0, N);

        bw.write(sb.toString()+"\n");


        br.close();
        bw.flush();
        bw.close();

    }

    private static void div(int startRow, int startCol, int curLen) {

        // 현재 기준 전체가 영 또는 1이면 sb에 0 또는 1을 append
        int sum = 0;
        for (int i = startRow; i < startRow+curLen; i++) {
            for (int j = startCol; j < startCol+curLen; j++) {
                sum += arr[i][j];
            }
        }

        // 만약 1x1까지 분할을 했을 때, 마지막 남는건 1 또는 0 뿐이므로.. 이 부분이 종료조건 역할도 한다.
        if (sum == 0) { // 모두 영이면..
            sb.append(0);
        } else if (sum == curLen * curLen) { // 모두 1이면
            sb.append(1);
        }else {
            // 전체를 보고 좁혀서 진행한것..
            // 0 또는 1로 줄이지 않은 문자열은 괄호 친다..
            sb.append("(");
            div(startRow, startCol, curLen/2); // 좌상
            div(startRow, startCol+(curLen/2), curLen/2); // 우상
            div(startRow+(curLen/2), startCol, curLen/2); // 좌하
            div(startRow+(curLen/2), startCol +(curLen/2), curLen/2); // 우하
            sb.append(")");
        }



    }

}
