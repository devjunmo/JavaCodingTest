package ListStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrTest {

    public static void main(String[] args) {

        String[] test = new String[4];
        test[0] = "a";
        test[1] = "b";
        test[2] = "c";
        test[3] = "c";

        for (String c:
             test) {
            System.out.print(c);
        }

//        String[] test2 = {"b", "c", "a"};
        String[] test2 = {"b", "c"};

        ArrayList<String> as1 = new ArrayList<>(Arrays.asList(test));
        ArrayList<String> as2 = new ArrayList<>(Arrays.asList(test2));

        as1.retainAll(as2);
        System.out.println("as2 = " + as2);

        ArrayList<String> as3 = new ArrayList<>(Arrays.asList("a", "3", "A", "B"));
        System.out.println("as3 = " + as3);

        // java7 스타일
        Collections.sort(as3, Collections.reverseOrder());
        System.out.println();

        // java8 스타일
        as3 = new ArrayList<>(Arrays.asList("a", "3", "A", "B"));
        System.out.println("as3 = " + as3);
        as3.sort(Comparator.reverseOrder());
        System.out.println("as3 = " + as3);
        as3.sort(Comparator.naturalOrder());
        System.out.println("as3 = " + as3);
        as3.sort(String.CASE_INSENSITIVE_ORDER); // 대소문자 상관 없이
        System.out.println("as3 = " + as3);
        as3.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER)); // 얘는 자바 7 스타일



    }

}
