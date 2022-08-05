package JAVABasic.overrideTest;

public class myClasses {
}

class A{
    void method() {
        System.out.println("부모 클래스의 메소드");
    }
}

class B extends A{
    @Override
    void method() {
        System.out.println("자식 클래스의 메소드!");
    }
}
