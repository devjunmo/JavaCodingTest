/*
[참고 자료]
https://www.youtube.com/watch?v=uPSkCKB4Kuo

 */

package ListStudy;

import java.util.ArrayList;
import java.util.Collections;

public class ListBasic {

    public static void main(String[] args) {

        ArrayList<Integer> testArr = new ArrayList<>();

        // 기본 add()는 append로 작용
        testArr.add(400);
        testArr.add(200);

        // index 지정하면 insert같이 사용 가능
        testArr.add(1, 1000);

        System.out.println("testArr = " + testArr);

        // 값 출력
        for (int val :
                testArr) {
            System.out.println("val = " + val);
        }

        // index 출력
        for (int i = 0; i < testArr.size(); i++) {
            System.out.println("idx = " + i);
        }

        Collections.sort(testArr); // call by ref
        System.out.println("testArr = " + testArr);

        
        // set은 특정 인덱스에 대해 기존 값 변경
        testArr.set(1, 11);
        System.out.println("testArr = " + testArr);


        // String -> list





    }
}
