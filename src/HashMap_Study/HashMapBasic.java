/*
https://coding-factory.tistory.com/556
 */

package HashMap_Study;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapBasic {
    public static void main(String[] args) {

        // 생성 / 초기 용량을 지정해주면 좋다. (자동으로 늘릴때 두배로 늘려서 공간 낭비 발생)
        HashMap<Integer, String> map1 = new HashMap<>(20);


        // 값 추가
        map1.put(1, "one");
        map1.put(2, "two");
        map1.put(3, "three");
        map1.put(3, "three2");

        System.out.println("map1 = " + map1);


        // 값 삭제
        map1.remove(1); // 키를 입력해서 삭제


        // 값 출력
        System.out.println("map1 = " + map1);
        System.out.println("map1.get(2) = " + map1.get(2));

        // entrySet() 활용 값 출력
        for (Map.Entry<Integer, String> entry :
                map1.entrySet()
        ) {
            System.out.println("entry = " + entry);
            int curKey = entry.getKey();
            System.out.println("curKey = " + curKey);

            String curVal = entry.getValue();
            System.out.println("curVal = " + curVal);
        }

        // KeySet() 활용 값 출력
        for (int i :
                map1.keySet()) {
            System.out.println("key: " + i);
            System.out.println("val: " + map1.get(i));
        }


        // iterator 활용하기
        Iterator<Map.Entry<Integer, String>> entries = map1.entrySet().iterator();

        while (entries.hasNext()) {

            Map.Entry<Integer, String> entry = entries.next();
            System.out.println("entry = " + entry);

            Integer curKey = entry.getKey();
            System.out.println("curKey = " + curKey);
            String curVal = entry.getValue();
            System.out.println("curVal = " + curVal);

        }


    }
}
