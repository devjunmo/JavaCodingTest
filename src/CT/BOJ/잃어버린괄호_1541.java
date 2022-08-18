package CT.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class 잃어버린괄호_1541 {

    // 55-50+40
    static int res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputStr = br.readLine();
        int[] valArr = Arrays.stream(inputStr.split("\\+|-")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Character> operLst = new ArrayList<>();

        for (char c : inputStr.toCharArray()) {
            if (!Character.isDigit(c)) { // 연산자면 ...
                operLst.add(c);
            }
        }


        int minusIdx = -1;
        for (int i = 0; i < operLst.size(); i++) {
            if (operLst.get(i) == '-') {
                minusIdx = i; // value는 i+1번째부터 마이너스로..
                break;
            }
        }

        if (minusIdx == -1) { // 마이너스가 없으면
            for (int i = 0; i < valArr.length; i++) {
                res += valArr[i]; // 모두 더하기
            }
        }else { // 마이너스가 있으면
            for (int i = 0; i <= minusIdx; i++) {
                res += valArr[i];
            }
            for (int i = minusIdx+1; i < valArr.length; i++) {
                res -= valArr[i];
            }
        }



        bw.write(res+"\n");

        br.close();
        bw.flush();
        bw.close();

    }

}
