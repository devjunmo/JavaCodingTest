package ListStudy;

// 스트링 배열을 인트 배열로 바꾸는것 같은 기능

// 출처: https://zetawiki.com/wiki/%EC%9E%90%EB%B0%94_String_%EB%B0%B0%EC%97%B4%EC%9D%84_int_%EB%B0%B0%EC%97%B4%EB%A1%9C_%EB%B3%80%ED%99%98


import java.util.Arrays;

public class ListMapping {
    public static void main(String[] args) {
        String[] strings = {"1", "2", "3"};

        int[] nums1 = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        int[] nums2 = Arrays.asList(strings).stream().mapToInt(Integer::parseInt).toArray();

        int[] nums3 = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums3[i] = Integer.parseInt(strings[i]);
        }

        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("nums3 = " + Arrays.toString(nums3));

    }
}
