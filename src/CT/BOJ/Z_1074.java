package CT.BOJ;
import java.io.*;

public class Z_1074 {

    static int N;
    static int len;
    static int r;
    static int c;

    static int curNum = 0;
    static int ans = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nrc = br.readLine().split(" ");
        N = Integer.parseInt(nrc[0]);
        r = Integer.parseInt(nrc[1]);
        c = Integer.parseInt(nrc[2]);

        len = (int) Math.pow(2, N);

        // 2^N x 2^N 배열

        div(0, 0, len);

        bw.write(ans + "\n");
//        bw.write(tmpCnt + "\n");


        br.close();
        bw.flush();
        bw.close();
    }


    private static void div(int startRow, int startCol, int curLen) {

        if(curLen == 1) {
            ans = curNum;
            return;
        }

        int halfLen = curLen/2;

        if(startRow+halfLen > r && startCol+halfLen > c) {
            div(startRow, startCol, halfLen); // 좌상

        }else if(startRow+halfLen > r && startCol+halfLen <= c) {
            curNum += halfLen * halfLen;
            div(startRow, startCol+(halfLen), halfLen); // 우상

        }else if(startRow+halfLen <= r && startCol+halfLen > c) {
            curNum += 2 * halfLen * halfLen;
            div(startRow+(halfLen), startCol, halfLen); // 좌하


        }else if(startRow+halfLen <= r && startCol+halfLen <= c) {
            curNum += 3 * halfLen * halfLen;
            div(startRow+(halfLen), startCol+(halfLen), halfLen); // 우하

        }


    }
}







