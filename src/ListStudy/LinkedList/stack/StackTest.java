package ListStudy.LinkedList.stack;

public class StackTest {

    public static void main(String[] args) {
        MyStack<Integer> st = new MyStack<>();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());

    }

}
