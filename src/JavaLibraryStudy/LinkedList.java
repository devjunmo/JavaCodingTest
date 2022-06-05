package JavaLibraryStudy;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedList {
    public static void main(String[] args) {

        System.out.println(Arrays.asList(1,2,3));
        System.out.println(Arrays.asList(1,2,3).getClass());

        ArrayList<Integer> testArr = new ArrayList<>();
        testArr.add(1);
        testArr.add(2);

        System.out.println("testArr = " + testArr);
        System.out.println("testArr = " + testArr.getClass());

    }
}
