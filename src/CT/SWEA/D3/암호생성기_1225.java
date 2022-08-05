package CT.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 암호생성기_1225 {

    static ArrayList<Integer> passwdLst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = 10;

        for (int cNum = 1; cNum <= TC; cNum++) {
            Integer.parseInt(br.readLine()); // 필요 없음

            // int 배열 생성
            int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // int 배열 -> int List
            passwdLst = (ArrayList<Integer>)Arrays.stream(intArr).boxed().collect(Collectors.toList());

//            System.out.println(passwdLst);
            boolean goWhile = true; // while 종료를 위한 변수

            // 한 싸이클 = while 안에 for로 구현. 1~5 감소 및 맨뒤로..
            while (goWhile) {
                // 1~5 빼는것 반복..
                for (int i = 1; i <= 5; i++) {
                    // 첫번째 요소에 사이클내 차례에 해당하는 값 빼주기
                    int willAdd = passwdLst.get(0) - i;

                    if (willAdd <= 0) { // 빼준 값이 0 이하라면
                        willAdd = 0;
                        passwdLst.remove(0); // 첫 요소 제거
                        passwdLst.add(willAdd); // 해당값 맨 뒤로 붙이기
                        goWhile = false;
                        System.out.print("#"+cNum+" ");
                        for (int j = 0; j < passwdLst.size(); j++) {
                            System.out.print(passwdLst.get(j)+" ");
                        }
                        System.out.println();
                        break; // for loop 종료
                    }
                    passwdLst.remove(0); // 첫 요소 제거
                    passwdLst.add(willAdd); // 해당값 맨 뒤로 붙이기
                }


            }

        }

    }
}
