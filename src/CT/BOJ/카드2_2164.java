package CT.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 카드2_2164 {

    static ArrayList<Integer> intLst;
    static int startIdx;
    static int endIdx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());

        intLst = new ArrayList<>();

        // 어레이 리스트 채우기
        for (int i = 1; i <= inputNum; i++) {
            intLst.add(i);
        }

        System.out.println(intLst);

        startIdx = 0;
        endIdx = inputNum - 1;

        while (true) {
            if (startIdx == endIdx) {
                break;
            }

            // 먼저 첫 요소 버리기
            startIdx++;

            // 다음으로 첫 요소 뒤로 빼기
            int curVal = intLst.get(startIdx); // 뒤로 뺄 값 가져오기
            intLst.add(curVal); // 뒤로 뺴기
            startIdx++; // 뒤로 뺐으니까 첫 인덱스 증가
            endIdx++; // 뒤로 뺐으니까 마지막 인덱스 증가
        }

        System.out.println(intLst.get(startIdx));

    }
}
