package ListStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoDimArr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 3;
        int m = 3;

//        int[][] arr = new int[n][m];
        char[][] charArr = new char[n][m];

        for (int i = 0; i < n; i++) {
            charArr[i] = br.readLine().toCharArray();
        }

        System.out.println("charArr = " + Arrays.toString(charArr[0]));
        System.out.println("charArr = " + Arrays.toString(charArr[1]));
        System.out.println("charArr = " + Arrays.toString(charArr[2]));

        
    }

}
