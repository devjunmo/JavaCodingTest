package JAVABasic.overrideTest;

public class Test {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        A ab = new B();

        a.method(); // 부모 클래스 메소드 뜸
        b.method(); // 자식 클래스 메소드 뜸
        ab.method(); // 자식 클래스 메소드 뜸
    }
}
