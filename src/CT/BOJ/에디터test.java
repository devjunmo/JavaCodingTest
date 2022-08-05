package CT.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 에디터test {
    // 링크드 리스트 풀이법
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 입력 문자열
        String str = bf.readLine();

        // 명령 행 개수
        int n = Integer.parseInt(bf.readLine());

        List<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        int size = list.size();
        int index = list.size();

        while (n-- > 0) {
            String[] line = bf.readLine().split(" ");

            // 커서 왼쪽 한칸 이동
            if (line[0].equals("L")) {
                if(index >= size){
                    index -= 1;
                }
            }
            // 커서 오른쪽 한칸 이동
            else if (line[0].equals("D")) {
                index += 1;
            }
            // 커서 왼쪽 문자 삭제
            else if (line[0].equals("B")) {
                list.remove(index);
            }
            // P 다음 문자 왼쪽 추가
            else if (line[0].equals("P")) {
                if(index >= size){
                    list.add(index, line[1].charAt(0));
                }else{
                    list.add(index+1, line[1].charAt(0));
                }
            }

        }

        System.out.println(list.toString());


    }
}
