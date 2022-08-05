package CT.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SWEA_1974 {
    public static String[] oneToNineArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static List<String> oneToNine = Arrays.asList(oneToNineArr);
    public static String[][] inputArr;
    public static int N = 9;

    // 제자리, 서 서북, 북, ... 남서 (8방 + 1)
    public static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cNum = Integer.parseInt(br.readLine());
        inputArr = new String[N][N];

        for (int cn = 1; cn <= cNum; cn++) {
            for (int i = 0; i < 9; i++) {
                inputArr[i] = br.readLine().split(" ");
            }

            if (rowCheck(inputArr) && colCheck(inputArr) && boxCheck(inputArr)) {
                System.out.println("#" + cn + " 1");
            } else {
                System.out.println("#" + cn + " 0");
            }
        }


    }

    public static boolean rowCheck(String[][] inArr) {
        for (int r = 0; r < N; r++) {
            List<String> rLst = Arrays.asList(inArr[r]);
            rLst.retainAll(oneToNine);
            rLst = rLst.stream().distinct().collect(Collectors.toList());
            if (rLst.size() != 9) {
                return false;
            }
        }
        return true;
    }

    public static boolean colCheck(String[][] inArr) {
        for (int c = 0; c < N; c++) {
            List<String> tmpLst = new ArrayList<>();
            for (int r = 0; r < N; r++) {
                tmpLst.add(inArr[r][c]);
            }
            tmpLst.retainAll(oneToNine);
            tmpLst = tmpLst.stream().distinct().collect(Collectors.toList());
            if (tmpLst.size() != 9) {
                return false;
            }
        }
        return true;
    }

    public static boolean boxCheck(String[][] inArr) {
        for (int i = 1; i < 9; i = 3 * i + 1) {
            for (int j = 1; j < 9; j = 3 * j + 1) {
                List<String> tmpLst = new ArrayList<>();

                for (int d = 0; d < 9; d++) {
                    int curX = i + dx[d];
                    int curY = j + dy[d];
                    tmpLst.add(inArr[curX][curY]);
                }
                tmpLst.retainAll(oneToNine);
                tmpLst = tmpLst.stream().distinct().collect(Collectors.toList());
                if (tmpLst.size() != 9) {
                    return false;
                }
            }
        }
        return true;
    }

}
