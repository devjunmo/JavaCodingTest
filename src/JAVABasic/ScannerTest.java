package JAVABasic;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        /*
        3
        1 A 2
        1
        출력
         */

        Scanner sc = new Scanner(System.in);

        int i1 = sc.nextInt();

        int i2 = sc.nextInt();

        String s1 = sc.next();
        int i3 = sc.nextInt();
        int i4 = sc.nextInt();

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("s1 = " + s1);
        System.out.println("i3 = " + i3);
        System.out.println("i4 = " + i4);
    }
}
