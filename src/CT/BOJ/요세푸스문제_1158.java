package CT.BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 요세푸스문제_1158 {

    static int curPtr = -1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        sb.append("<");

        int N = sc.nextInt(); // N명
        int K = sc.nextInt(); // K번째 (1번째 부터 시작..)

        int idx_K = K - 1; // 0번째로 맞춰주기..

        LinkedList<Integer> llst = new LinkedList<>();
        ArrayList<Integer> resLst = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            llst.add(i + 1);
        }

        // 첫 시작
        if (idx_K == llst.size() - 1) { // 인덱스가 최대 인덱스라면..
            resLst.add(llst.get(idx_K));
            llst.remove(idx_K);
            curPtr = idx_K - 1;
            // next는 + K
            curPtr += K;
        } else {
            resLst.add(llst.get(idx_K));
            llst.remove(idx_K);
            curPtr = idx_K;
            // next는 + K-1
            curPtr += K-1;
        }

        while (true) {
            if (llst.isEmpty()) {
                break;
            }

            if (curPtr >= llst.size()) { // 인덱스 초과시..
                curPtr %= llst.size();
            }

            if (curPtr == llst.size() - 1) { // 인덱스가 현재 최대 인덱스라면..
                resLst.add(llst.get(curPtr));
                llst.remove(curPtr);
                curPtr--;
                curPtr += K; // next ptr

                if (llst.isEmpty()) {
                    break;
                }
//                curPtr %= llst.size();
            } else {
                resLst.add(llst.get(curPtr));
                llst.remove(curPtr);
                curPtr += K-1; // 인위적 --;가 없으므로 K-1
            }
        }

        for (int i = 0; i < resLst.size(); i++) {
            if (i == resLst.size() - 1) {
                sb.append(resLst.get(i)).append(">");
                break;
            }
            sb.append(resLst.get(i)).append(",").append(" ");
        }

        System.out.println(sb.toString());


    }
}
