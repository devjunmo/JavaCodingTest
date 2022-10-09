package CT.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SWEA1210_Ladder1 {

    static int N = 100;
    static String[][] ladArr;

    static int curRowIdx = 0;
    static int curColIdx = 0;

    static boolean[][] vis;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int cNum = 1; cNum <= 10; cNum++) {

            int TC = Integer.parseInt(br.readLine());

            ladArr = new String[N][N];

            for (int i = 0; i < N; i++) {
                ladArr[i] = br.readLine().split(" "); // 사다리 받기
            }

//			System.out.println(Arrays.toString(ladArr[0]));
//			System.out.println(ladArr[0][0].getClass());

            ArrayList<Integer> startIdxArr = new ArrayList<>(); // 시작 컬럼 인덱스

            for (int i = 0; i < N; i++) {
                if(ladArr[0][i].equals("1")) {
//					System.out.println("i: "+ i);
//					System.out.println("ladArr[0][i]: "+ladArr[0][i]);
                    startIdxArr.add(i);
                }
            }


//			System.out.println(Arrays.toString(vis[0]));


//			System.out.println(startIdxArr);

            for (Integer startIdx : startIdxArr) {
//				System.out.println("startIdx: "+startIdx);
                curRowIdx = 0;
                curColIdx = startIdx;

                vis = new boolean[N][N];

//				vis[curRowIdx][curColIdx]=true;

                // 기본적으로 아래로 간다...
                for (int i = 0; i < 100; i++) {
//					System.out.println(curRowIdx + "," + curColIdx);
                    curRowIdx = i;

                    vis[curRowIdx][curColIdx]=true;

                    if(ladArr[curRowIdx][curColIdx].equals("2")) {
                        System.out.println("#" + TC + " " + startIdx);
                        break;
                    }


                    while(true) {
//						if(startIdx == 67) {
//							System.out.println(curRowIdx+ "," +curColIdx);
//						}
                        int tmpLeft = curColIdx - 1;
                        int tmpRight = curColIdx + 1;

                        // 왼쪽에 길이 있다면..
                        if(tmpLeft >= 0 && ladArr[curRowIdx][tmpLeft].equals("1") && vis[curRowIdx][tmpLeft]==false) {
                            curColIdx = tmpLeft;
                            vis[curRowIdx][curColIdx]=true;

                        } else if (tmpRight < N && ladArr[curRowIdx][tmpRight].equals("1") && vis[curRowIdx][tmpRight]==false) { // 오른쪽에 길이 있다면..
                            curColIdx = tmpRight;
                            vis[curRowIdx][curColIdx]=true;

                        } else { // 길이 없다면... 밑으로 진행..
                            break;
                        }
                    }



                }
            }

        }

    }

}
