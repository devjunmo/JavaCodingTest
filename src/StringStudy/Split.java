package StringStudy;

public class Split {
    public static void main(String[] args) {

        // 공백 없는 문자열 자르기
        String str = "1234567890";
        System.out.println(str.substring(3)); // 3번 인덱스 부터 출력됨. (0~2번째 잘려짐)

        String nm = "3 4"; // 3x4 같은 정보가 이렇게 주어진다면..
        int n = Integer.parseInt(nm.substring(0, 1));
        int m = Integer.parseInt(nm.substring(2, 3));

        System.out.println(n + " x " + m); // 3 x 4



    }
}
