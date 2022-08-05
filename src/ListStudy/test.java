package ListStudy;

import java.util.ArrayList;
import java.util.List;

class Emp1{
    void work(){
        System.out.println("w1");
    }
}

class Emp2 extends Emp1{
    void work() {
        System.out.println("w2");
    }
}

class Emp3{
    Emp3() {
        System.out.println("cc");
    }

    void work() {
        System.out.println("ww");
    }

    public String toString() {
        return "KIM";
    }
}

public class test {

    public static void main(String[] args) {
        int j = 100;
        switch (10) {
            case 10:
            default:
                System.out.println("hi");
        }
    }
}
