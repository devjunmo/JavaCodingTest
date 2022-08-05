package StringStudy;

public class Format {

    public static void main(String[] args) {
        double pi = Math.PI;

        System.out.println(String.format("%.6f", pi)); // 3.141593
        System.out.println(String.format("%.6f", pi).getClass().getName()); //java.lang.String
    }

}
