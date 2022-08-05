package CT.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.rmi.server.ExportException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class 에디터_1406 {

    private static String[] curCmdArr = new String[2];
    private static LinkedList<String> llst;

    private static ListIterator<String> listIterator;


    private static int curPtr = -1;

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            String inputStr = br.readLine();
            llst = new LinkedList<>(Arrays.asList(inputStr.split("")));

            curPtr = llst.size() - 1;

            listIterator = llst.listIterator();

            while (listIterator.hasNext()) {
                listIterator.next(); // 커서를 끝에다 위치 시킨다
            }


            int methodCnt = Integer.parseInt(br.readLine());

            for (int i = 0; i < methodCnt; i++) {
                // case 문

                curCmdArr = br.readLine().split(" ");
                String curCmd = curCmdArr[0];

                switch (curCmd) {
                    case "L":
                        cmdL();
                        break;
                    case "D":
                        cmdD();
                        break;
                    case "B":
                        cmdB();
                        break;
                    case "P":
                        cmdP();
                        break;
                }
            }

            String ans = "";

            for (String llComp :
                    llst) {
                sb.append(llComp);
            }

//            System.out.println(ans);
            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void cmdP() {

        String addStr = curCmdArr[1];

//        llst.add(curPtr+1, addStr);
//        curPtr++;
        listIterator.add(addStr); // 현재 커서에서 추가하고, 커서 +1 해줌
    }

    private static void cmdB() {
//        if (curPtr < 0) {
//
//        } else {
////            llst.remove(curPtr);
//            listIterator.remove();
//            listIterator.previous();
//            curPtr--;
//        }
        if (listIterator.hasPrevious()) {
            listIterator.previous();
            listIterator.remove();
        }
    }

    private static void cmdD() {
//        if (curPtr >= llst.size()) {
//
//        } else {
//            listIterator.next();
//            curPtr++;
//        }
        if (listIterator.hasNext()) {
            listIterator.next();
        }
    }

    private static void cmdL() {
//        if (curPtr < 0) {
//
//        } else {
//            listIterator.previous();
//            curPtr--;
//        }
        if (listIterator.hasPrevious()) {
            listIterator.previous();
        }
    }
}
