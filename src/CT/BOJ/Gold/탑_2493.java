package CT.BOJ.Gold;

/*
5
6 9 5 7 4

>>> 0 0 2 2 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 탑_2493 {
    static int N;
    static int[] inputArr;
    static int[] res;

    static Stack<Integer> st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        res = new int[N];

        st = new Stack<>();

        inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = N - 1; i >= 0; i--) {
            int curVal = inputArr[i];
            int leftIdx = i - 1;
            if (leftIdx == -1) {
                break; // 맨 왼쪽은 영..
            }
            st.push(i); // 현재 인덱스를 스택에 넣는다
            int leftVal = inputArr[leftIdx];

            if (curVal < leftVal) { // 왼쪽 값이 더 크다면..
                while (!st.isEmpty()) { // 스텍에 저장된 인덱스 사용
                    int peekVal = inputArr[st.peek()];
                    if (peekVal > leftVal) { // 현재 peek값이 left보다 크면 안꺼낸다
                        break;
                    }
                    int popIdx = st.pop();
                    res[popIdx] = leftIdx + 1; // 1번째부터 라서..
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
