package CT.BOJ;

import java.io.*;

public class 외판원순회2_넥퍼_10971 {

    static int N;
    static int[][] arr;
    static int[] vertexArr;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        vertexArr = new int[N];

        arr = new int[N + 1][N + 1]; // 1부터 생각

        for (int i = 1; i <= N; i++) {
            String[] rows = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j+1] = Integer.parseInt(rows[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            vertexArr[i] = i + 1; // 간선 리스트
        }

        do {
            int edgeSum = 0;
            int startV = vertexArr[0];
            int lastV = vertexArr[N-1];
            boolean trigger = false;
            if (arr[lastV][startV] != 0) { // 못 돌아 오면 다음 넥퍼
                edgeSum += arr[lastV][startV]; // 마지막점으로 회귀
                for (int i = 0; i < N-1; i++) {
                    int v1 = vertexArr[i];
                    int v2 = vertexArr[i + 1];
                    if (arr[v1][v2] == 0) {
                        break; // 못가는 길이면 해당 케이스는 안가고 넥퍼 돌림
                    }else {
                        edgeSum += arr[v1][v2];
                        if (i == N - 2) {
                            // 루프가 끝까지 돌았다면
                            trigger = true;
                        }
                    }
                }
                // 루프가 끝까지 돌았고 간선 합이 최소라면 갱신
                if (trigger && minCost > edgeSum) {
                    minCost = edgeSum;
                }
            }
        } while (np(vertexArr));

        bw.write(minCost + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean np(int[] numbers) {

        int N = numbers.length;
        // 1. 꼭대기 찾기
        int i = N - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i]) {--i;}
        if (i==0) {return false;} // 다음 순열을 만들 수 없는 가장 큰 상태

        // 2. 꼭대기의 바로 앞 자리 (i-1)의 값을 크게 만들 교환 값 뒤쪽에서 찾기
        int j = N - 1;
        while (numbers[i - 1] >= numbers[j]) {--j;}

        // 3. i-1의 위치값과 j 위치값 교환
        swap(numbers, i - 1, j);

        // 4. i 위치부터 맨 뒤까지의 수열을 가장 작은 형태의 오름차순으로 변경
        int k = N - 1;
        while (i < k) { swap(numbers, i++, k--); }

        return true; // 다음 순열을 만들 수 있음
    }

    public static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
