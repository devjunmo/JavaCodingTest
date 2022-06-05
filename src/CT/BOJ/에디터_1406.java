package CT.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 에디터_1406 {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            int cmdNum = Integer.parseInt(br.readLine());
            LinkedList<Character> ll = new LinkedList<>(Arrays.asList('F', 'L'));

            for (int i = 0; i < cmdNum; i++) {
                // case 문

            }



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
