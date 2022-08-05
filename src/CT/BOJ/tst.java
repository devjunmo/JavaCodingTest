package CT.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tst {

    static int N, M;
    static int[] states;

    public static void switchB(int num) {
        for(int i = num; i < N; i += num+1) {
            states[i] = (states[i] +  1)%2; // 0 -> 1, 1 -> 0
        }
        return;
    }

    public static void switchG(int num) {
        int right = num+1;
        int left = num-1;
        states[num] = (states[num] + 1)%2;

        for(int i = 0; i < N; i++){
            if(right >=N || left < 0) break; // index 범위를 넘어갈 경우를 체크
            if(states[right] != states[left]) break; // 대칭으로 상태가 같은지 체크

            states[right] = (states[right] + 1)%2;
            states[left] = (states[left] + 1)%2;
            right++;
            left--;
        }
        return;
    }

    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());// 스위치의 갯수
        states = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < N ; i++){
            states[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine()); // 학생 수
        int[][] nums = new int[M][2];
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine()," ");
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            if(nums[i][0] == 1)  // 남학생
                switchB(nums[i][1]-1);
            else // 여학생
                switchG(nums[i][1]-1);
        }

        //output
        for(int i = 1; i <= N; i++) {
            System.out.print(states[i-1] + " ");
            if(i%20 == 0) System.out.println();
        }

    }

}
