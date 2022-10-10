package CT.SWEA.D4;

/*
10
2
0 0
0 100
1.0
4
0 0 400 400
0 100 0 100
1.0
6
0 0 400 400 1000 2000
0 100 0 100 600 2000
0.3
9
567 5 45674 24 797 29 0 0 0
345352 5464 145346 54764 5875 0 3453 4545 123
0.0005

 */
import java.io.*;
import java.util.Arrays;

public class 하나로_1251 {
    static int V; // vertex count
    static int[] xPosLst;
    static int[] yPosLst;

    static Double E;

    static long[][] arr; // 간선을 넣을 인접 배열
    static Island[] islandArr;

    static class Island{
        int x, y;

        public Island(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int cNum = 1; cNum <= TC; cNum++) {
            V = Integer.parseInt(br.readLine());
            islandArr = new Island[V];

            xPosLst = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            yPosLst = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            E = Double.parseDouble(br.readLine());

            // 00 11 22
            for (int i = 0; i < V; i++) {
                islandArr[i] = new Island(xPosLst[i], yPosLst[i]);
            }

            arr = new long[V][V];

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (i != j) {
                        long xDist = Math.abs(islandArr[i].x-islandArr[j].x);
                        long yDist = Math.abs(islandArr[i].y-islandArr[j].y);
                        long sum = xDist * xDist + yDist * yDist;
                        arr[i][j] = sum; // 인접행렬 채우기 
                    }
                }
            }

            // 프림 알고리즘에 필요한 자료구조
            long[] minEdge = new long[V]; // 각 정점 입장에서 신장 트리에 포함된 정점과의 간선 비용을 최소 비용으로
            boolean[] visited = new boolean[V]; // 신장트리에 포함 여부

            Arrays.fill(minEdge, Long.MAX_VALUE);

            // 1. 임의의 시작점 처리
            minEdge[0] = 0; // 처음은 나 자신과 거리니까 제로
            long result = 0; // 최소 신장트리 비용 누적


            // V개의 정점 처리 하면 끝 ( 이부분 시간복잡도 N, PQ로 logN 느낌으로 최적화 가능)
            for (int c = 0; c < V; c++) { // 첫 요소 부터 정점 수 만큼 루프. c변수 사용 안됨
                // step1. 신장 트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
                long min = Long.MAX_VALUE;
                int minVertex = -1; // 최소인 정점 저장할 변수
                for (int j = 0; j < V; j++) {
                    // 신장트리에 포함되지 않은 정점이면서 간선 비용이 최소일때
                    if (!visited[j] && min > minEdge[j]) {
                        min = minEdge[j];
                        minVertex = j; // 최소 정점번호 기억
                    }
                }  // 현재 정점 차례에서 인접한 정점 중 최소 비용의 인접 정점 얻었음

            /*
            step2. 신장트리에 추가
             */

                visited[minVertex] = true; // 방문처리
                result += min;

            /*
            step3. 신장 트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은
                    정점들의 기존 최소 비용과 비교해서 갱신

                    신장 트리에 새롭게 추가되는 정점의 모든 인접 정점 들여다 보며 처리
             */

                for (int i = 0; i < V; i++) {
                    if (arr[minVertex][i] != 0 &&
                            !visited[i] &&
                            minEdge[i]>arr[minVertex][i]) {
                        minEdge[i]=arr[minVertex][i];
                    }
                }
            }

            bw.write("#"+cNum + " "+Math.round(E*result)+"\n");

        }

        br.close();
        bw.flush();
        bw.close();

    }

}
