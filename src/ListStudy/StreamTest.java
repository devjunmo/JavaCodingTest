package ListStudy;

import java.util.ArrayList;
import java.util.Arrays;

public class StreamTest {
    public static void main(String[] args) {
        ArrayList<String> list
                = new ArrayList<>(Arrays.asList(
                        "바나나", "딸기", "메론", "Grape", "Apple"
        ));

        System.out.println("list = " + list);


        // 이 람다들은 성능 향상이 아닌 축약을 통한 편의성 증대를 목표로 함

        // 리스트를.일렬로뽑은다음.매핑할거(리턴타입=스트림).리턴받은 스트림을 배열로 만들자
        // 이거 하려고 functioal interface와 default method가 생긴것..
        // map이 받는게 functional interface
        Object[] pro1 = list.stream().map(e -> e.toUpperCase()).toArray();
        System.out.println(Arrays.toString(pro1));
        System.out.println("list = " + list); // 원본은 안바뀜

        // forEach()는 컨슈머
        // ::는 람다식을 더 축약한 표현법임
        list.stream().map(String::toUpperCase).forEach(System.out::println);


    }
}
