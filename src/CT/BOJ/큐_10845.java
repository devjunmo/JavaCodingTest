package CT.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 큐_10845 {

    public static int[] queue = new int[11000];
    public static int head = 0;
    public static int tail = 0;

    public static StringBuilder sb = new StringBuilder();
    public static String curCmd;


    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int caseNum = Integer.parseInt(br.readLine());

            for (int i = 0; i < caseNum; i++) {
                curCmd = br.readLine();
                String cmdStr = curCmd.split(" ")[0];


                switch (cmdStr) {
                    case "push":
                        push();
                        break;
                    case "pop":
                        pop();
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

    public static void back() {
        if (head - tail == 0) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue[tail-1]).append("\n");
        }
    }

    public static void front() {
        if (head - tail == 0) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue[head]).append("\n");
        }
    }

    public static void push() {
        String pushVal = curCmd.split(" ")[1];
        queue[tail] = Integer.parseInt(pushVal);
        tail++;
    }

    public static void pop() {
        if (head - tail == 0) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue[head]).append("\n");
            head++;
        }
    }

    public static void size() {
        sb.append(tail - head).append("\n");
    }

    public static void empty() {
        if (tail - head == 0) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }






}
