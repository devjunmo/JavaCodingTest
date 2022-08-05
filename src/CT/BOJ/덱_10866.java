package CT.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 덱_10866 {

    public static int MX = 10000;
    public static int[] dq = new int[(MX * 2) + 1];
    public static int front = MX;
    public static int back = MX;

    public static StringBuilder sb = new StringBuilder();

    public static String curCmd;

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int caseNum = Integer.parseInt(br.readLine());

            for (int i = 0; i < caseNum; i++) {
                curCmd = br.readLine();
                String curCmdStr = curCmd.split(" ")[0];

                switch (curCmdStr) {
                    case "push_front":
                        push_front();
                        break;
                    case "push_back":
                        push_back();
                        break;
                    case "pop_front":
                        pop_front();
                        break;
                    case "pop_back":
                        pop_back();
                        break;
                    case "size":
                        size();
                        break;
                    case "empty":
                        empty();
                        break;
                    case "front":
                        front();
                        break;
                    case "back":
                        back();
                        break;
                    default:
                        break;
                }
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void push_front() {
        String push_val = curCmd.split(" ")[1];
        front--;
        dq[front] = Integer.parseInt(push_val); // 가서 넣어
    }

    public static void push_back() {
        String push_val = curCmd.split(" ")[1];
        dq[back] = Integer.parseInt(push_val);
        back++; // 넣고 가
    }

    public static void pop_front() {
        if (front == back) {
            sb.append(-1).append("\n"); // 츨력후 가
        } else {
            sb.append(dq[front]).append("\n"); // 츨력후 가
            front++;
        }
    }

    public static void pop_back() {
        if (front == back) {
            sb.append(-1).append("\n"); // 츨력후 가
        } else {
            sb.append(dq[back-1]).append("\n");
            back--; // 전꺼 출력후 가
        }
    }

    public static void size() {
        int size = back - front;
        sb.append(size).append("\n");
    }

    public static void empty() {
        if (front == back) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    public static void front() {
        if (front == back) {
            sb.append(-1).append("\n"); // 츨력후 가
        } else {
            sb.append(dq[front]).append("\n"); // 해당 위치 출력
        }

    }

    public static void back() {
        if (front == back) {
            sb.append(-1).append("\n"); // 츨력후 가
        } else {
            sb.append(dq[back-1]).append("\n"); // 전꺼 출력
        }
    }


}
