/*
    https://www.delftstack.com/ko/howto/java/string-to-arraylist-in-java/
 */

package ListStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class String2List {

    public static void main(String[] args) {

        // 방법1. charat()

        String str1 = "hello";
        ArrayList<Character> lst1 = new ArrayList<>();

        for (int i = 0; i < str1.length(); i++) {
            lst1.add(str1.charAt(i));
        }

        System.out.println("lst1 = " + lst1);


        // 방법2. split() 활용

        ArrayList<String> lst2 = new ArrayList<>(Arrays.asList(str1.split(""))); // string arr이어야 오류 안남
        System.out.println("lst2 = " + lst2);


        // 예제 : 공백으로 구분된 문자열을 리스트로 받기

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            ArrayList<String> lst3 = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));

            System.out.println("lst3 = " + lst3);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}










