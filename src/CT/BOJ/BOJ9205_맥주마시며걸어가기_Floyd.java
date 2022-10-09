package CT.BOJ;

/*
2
2
0 0
1000 0
1000 1000
2000 1000
2
0 0
1000 0
2000 1000
2000 2000*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ9205_맥주마시며걸어가기_Floyd {

    static List<Coor> adjLL;

    // i -> j로 갈 수 있는지 체크하는 배열
    // i -> j가 맨하탄 거리로 갈수 있으면 true, 없으면 false
    // 처음에 i -> j로 못가더라도 경유지로 갈 수 있는 경우에 floyd 알고리즘을 통해 true로 변경
    static boolean[][] map;

    static class Coor{
        int r;
        int c;

        public Coor(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Coor{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }


    private static int getDist(Coor curPos, Coor nextPos) {
        // 멘하탄 거리 리턴
        int tmpDx = Math.abs(curPos.r - nextPos.r);
        int tmpDy = Math.abs(curPos.c - nextPos.c);
        return (tmpDx + tmpDy);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int cNum = 0; cNum < TC; cNum++) {
            adjLL = new ArrayList<>();


            // 인풋 받아 큐에 넣기
            int storeNum = Integer.parseInt(br.readLine());

            for (int i = 0; i < storeNum+2; i++) {
                int[] posInfo = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

                adjLL.add(new Coor(posInfo[0], posInfo[1]));
            }

            map = new boolean[storeNum + 2][storeNum + 2];

            for (int i = 0; i < adjLL.size(); i++) {
                for (int j = 0; j < adjLL.size(); j++) {
                    if (i!=j && getDist(adjLL.get(i), adjLL.get(j)) <= 1000) {
                        // 갈수 있는 거리면
                        map[i][j] = true;
                    }
                }
            }


            for (int k = 0; k < adjLL.size(); k++) {
                for (int i = 0; i < adjLL.size(); i++) {
                    for (int j = 0; j < adjLL.size(); j++) {
                        if (map[i][k] && map[k][j]) {
                            // 경유해서 갈 수 있으면 갈수있다고 처리해준다
                            map[i][j] = true;
                        }
                    }
                }
            }

            System.out.println(map[0][adjLL.size() - 1] ? "happy" : "sad");


        }

    }
}
