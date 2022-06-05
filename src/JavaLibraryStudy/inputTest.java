package JavaLibraryStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class inputTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int caseNum = sc.nextInt();
        System.out.println("caseNum = " + caseNum);
        sc.close(); // 스캐너 종료

        for (int i = 0; i < caseNum; i++) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("br = " + br.getClass().getName()); // java.io.BufferedReader
                System.out.println(br.readLine());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }







    }
}
