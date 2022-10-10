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

public class BOJ9205_맥주마시며걸어가기 {

    static Queue<Coor> posQueue;
    static HashMap<Coor, Boolean> visMap;

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

    private static boolean bfs() {
        Coor curPos = null;

        curPos = posQueue.poll();

        if (curPos != null) {
            visMap.put(curPos, true); // 방문처리

            while (!posQueue.isEmpty()) {
                Coor nextPos = posQueue.poll();
                int dist = getDist(curPos, nextPos);

                // 한번에 갈수있는거리 = 1000m 이면서 미방문일때...
                if (dist <= 1000 && !(visMap.get(nextPos))) {
                    // 방문 처리 후
                    visMap.put(nextPos, true); // 방문처리

                    // 미방문 포지션 큐에 다 때려넣기
                    for (Coor coor : visMap.keySet()) {
                        if (!visMap.get(coor)) {
                            posQueue.offer(coor);
                        }
                    }
                }

            }
        }
        return false;
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
            posQueue = new ArrayDeque<>();
            visMap = new HashMap<>(); // 방문체크를 위한 해쉬맵

            // 인풋 받아 큐에 넣기
            int storeNum = Integer.parseInt(br.readLine());
            int[] startPosInfo = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Coor startPos = new Coor(startPosInfo[0], startPosInfo[1]);
            posQueue.offer(startPos);
            visMap.put(startPos, false); // 미방문

            for (int i = 0; i < storeNum; i++) {
                int[] storePosInfo = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                Coor storePos = new Coor(storePosInfo[0], storePosInfo[1]);
                posQueue.offer(storePos);
                visMap.put(storePos, false); // 미방문
            }

            int[] destPosInfo = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Coor destPos = new Coor(destPosInfo[0], destPosInfo[1]);
            posQueue.offer(destPos);
            visMap.put(destPos, false); // 미방문


            // 폴하면서 방문체크 하며 bfs

            if (bfs()) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
        
    }
}
