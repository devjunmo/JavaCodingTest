package JavaLibraryStudy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorTest {
    public static void main(String[] args) {
        LinkedList<Integer> llst = new LinkedList<>();

        llst.add(4);
        llst.add(2);
        llst.add(3);
        llst.add(1);

        Iterator<Integer> iterator = llst.iterator();



//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        ListIterator<Integer> listIterator = llst.listIterator();
        // 커서 comp1 comp2 comp3 ... 순서임
        while (listIterator.hasNext()) {
            listIterator.next();
            break;
        }

        for (int i = 99; i > 95; i--) {
            listIterator.add(i); // 현재 커서에 insert 하고 커서 자동으로 +1
        }

        listIterator.previous();
        listIterator.remove(); // next()나 previous() 메소드에 의해 반환된 가장 마지막 요소를 리스트에서 제거
//        listIterator.remove();

//        while (listIterator.hasNext()) {
//            System.out.print(listIterator.next()+" "); // 커서 순방향 이동
//        }


//        System.out.println();
//
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous()+" "); // 커서 역방향 이동

        }

   }

}

