/*
https://coding-factory.tistory.com/552
 */

package JavaLibraryStudy;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> llst = new LinkedList<>();

        // 값 추가
        llst.addFirst(1);
        llst.addLast(10);
        llst.add(2); // append 효과
        llst.add(3); // append 효과
        llst.add(4); // append 효과
        llst.add(1, 100); // 1자리에 100이 들어가고, 나머지는 뒤로 밀림 (배열에 비해 성능 좋다)
        System.out.println("llst = " + llst);

        // 값 삭제
        llst.removeFirst();
        llst.removeLast();
        System.out.println("llst = " + llst);
        llst.remove(); // 디폴트 = removeFirst
        System.out.println("llst = " + llst);
        llst.remove(1); // 인덱스 지정해서 제거
        System.out.println("llst = " + llst);

        // size 출력
        System.out.println(llst.size());

        // 값 출력
        int val = llst.get(1); // get 활용
        System.out.println("val = " + val);

        for (int tmp_val :
                llst) {
            // for 활용
            System.out.println("tmp_val = " + tmp_val);
        }

            // iterator 활용
        Iterator<Integer> iterator = llst.iterator();

        while (iterator.hasNext()) {
            // 다음 값이 있으면 다음값 출력
            System.out.println("iterator = " + iterator.next());
        }


        // 값 확인

        System.out.println(llst.contains(10)); // t/f 반환
        System.out.println(llst.indexOf(10)); // 있으면 인덱스 리턴
        System.out.println(llst.indexOf(1000)); // 없으면 -1 리턴

    }
}
