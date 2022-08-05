package CT.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class 괄호짝짓기_1218 {
    public static void main(String[] args) throws IOException {
        int TC = 10;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int cNum = 1; cNum <= TC; cNum++) {
            int strLen = Integer.parseInt(br.readLine());
            char[] inChars = new char[strLen];

            inChars = br.readLine().toCharArray();

            // 스택 생성
            Stack<Character> s = new Stack<Character>();

            // 해시맵 생성
            HashMap<Character, Character> hashMap = new HashMap<>();
            hashMap.put(')', '(');
            hashMap.put('}', '{');
            hashMap.put(']', '[');
            hashMap.put('>', '<'); // 닫는괄호 여는괄호 페어 형성

//            System.out.println(hashMap.get(')'));

            for (char inChar :
                    inChars) {
                // 여는 괄호일 때
                if (inChar == '(' || inChar == '{' || inChar == '[' || inChar == '<') {
                    s.push(inChar); // 스택에 넣는다
                }else { // 닫는괄호일 때
                    char curPeek = s.peek();
                    if (hashMap.get(inChar).equals(curPeek)) { // 닫는괄호에 매칭되는 여는괄호가 peek에 있다면
                        s.pop(); // 날린다
                    }else {
                        s.push(inChar);
                    }
                }
            }

            // 루프가 다 돌았을때 스택이 비어있는지 확인
            if (s.size() == 0) {
                System.out.println("#" + cNum + " " + "1"); // 비어있다면
            } else {
                System.out.println("#" + cNum + " " + "0"); // 비어있지 않다면
            }

//            System.out.println(s);
        }

    }
}
