/*
[참고 자료]
https://www.youtube.com/watch?v=uPSkCKB4Kuo
https://da2uns2.tistory.com/entry/Java-ArrayList-%EC%82%AC%EC%9A%A9%EB%B2%95%EA%B3%BC-%EC%A3%BC%EC%9A%94-%EB%A9%94%EC%86%8C%EB%93%9C

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


        // remove: 해당 인덱스의 값 or 해당 값 중 첫번째 값 삭제 (int로 치면 index로 인식해서 exception 뜰수 있다.)
        testArr.remove(1);
        System.out.println("testArr = " + testArr);


        // get으로 인덱스에 해당하는 값 받기
        int val = testArr.get(1);
        System.out.println("val = " + val);
        System.out.println("testArr = " + testArr);


        // indexOf로 특정 값에대해 첫번째 인덱스 받기
        testArr.add(1000);
        int idx = testArr.indexOf(1000);
        System.out.println("idx = " + idx);


        // lastindexOf로 특정 값에 대해 마지막 인덱스 받기


        // contains로 리스트 내부에 값이 있는지 없는지 확인
        boolean isVal = testArr.contains(1000);
        System.out.println("isVal = " + isVal);


        // isEmpty로 비었는지 체크
        System.out.println("testArr.isEmpty() = " + testArr.isEmpty());


        // size 반환
        int size = testArr.size();
        System.out.println("size = " + size);




    }
}
