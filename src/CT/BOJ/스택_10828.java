package CT.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 스택_10828 {

    public static int[] st = new int[11000];
    public static int stTop = 0;
    public static String curCmd;

    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            int cmdNum = Integer.parseInt(br.readLine());

            for (int i = 0; i < cmdNum; i++) {
                curCmd = br.readLine();
                String curCmdStr = curCmd.split(" ")[0];

                switch (curCmdStr) {
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
                    case "top":
                        top();
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

    private static void push() {
        int pushVal = Integer.parseInt(curCmd.split(" ")[1]);
        st[stTop] = pushVal;
        stTop++;
    }

    private static int pop() {
        if (stTop == 0) {
            sb.append(-1).append("\n");
            return -1;
        } else {
            int popVal = st[stTop-1];
            stTop--;
            sb.append(popVal).append("\n");
            return popVal;
        }
    }

    private static int size() {
        sb.append(stTop).append("\n");
        return stTop;
    }

    private static int empty() {
        if (stTop == 0) {
            sb.append(1).append("\n");
            return 1;
        } else {
            sb.append(0).append("\n");
            return 0;
        }
    }

    private static int top() {
        if (stTop == 0) {
            sb.append(-1).append("\n");
            return -1;
        } else {
            sb.append(st[stTop - 1]).append("\n");
            return st[stTop - 1];
        }
    }


}
