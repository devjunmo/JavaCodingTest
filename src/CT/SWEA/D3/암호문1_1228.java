package CT.SWEA.D3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 암호문1_1228 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = 10;

        for (int cNum = 1; cNum <= TC; cNum++) {
            int N = sc.nextInt();

//            ArrayList<Integer> arr = new ArrayList<Integer>();
            LinkedList<Integer> llst = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                llst.add(sc.nextInt());
            }

            int cmdN = sc.nextInt();

            for (int i = 0; i < cmdN; i++) {
                String curI = sc.next();
                int x = sc.nextInt(); // x 뒤 인덱스에
                int addNumCnt = sc.nextInt();

                for (int j = 0; j < addNumCnt; j++) {
                    llst.add(x+j, sc.nextInt());
                }
            }

//            System.out.print("#"+cNum+" ");
//            for (int i = 0; i < 10; i++) {
//                System.out.print(llst.get(i)+ " ");
//            }
//            System.out.println();


        }


    }
}
