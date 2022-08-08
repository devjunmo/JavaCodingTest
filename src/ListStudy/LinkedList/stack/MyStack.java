package ListStudy.LinkedList.stack;

public class MyStack<E> implements IStack<E> {

    private Node<E> top; // 더미노드 아님

    @Override
    public void push(E data) { // 첫 노드 삽입
        top = new Node<E>(data, top); // 새로운 노드 생성하고, 주소를 탑에 넣어준다
                                        // 맨처음 top은 null이니까 새로 생긴 노드의 next부분이 null로 채워지고
                                        // 새로 만든 노드의 주소를 기존의 탑에 넣는다
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            System.out.println("공백 스택이어서 작업 불가");
            return null;
        }

        Node<E> popNode = top; // 탑노드를 pop 할것
        top = popNode.link; // 탑을 팝노드 다음꺼에 링크
        popNode.link = null; // 팝노드의 링크는 null로, gc에 의해 수거

        return popNode.data;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.out.println("공백 스택이어서 작업 불가");
            return null;
        } else {
            return top.data;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        int cnt = 0;

        // 탑부터 시작해서 링크가 null인 노드까지 간다
        // tmp는 메모리의 스택영역에 존재하는 포인터 변수니까.. 힙에 있는 객체의 주소를 바꿔 넣어줄 수 있는것
        for (Node<E> tmp = top; tmp != null; tmp = tmp.link) {
            ++cnt;
        }

        return cnt;
    }
}
