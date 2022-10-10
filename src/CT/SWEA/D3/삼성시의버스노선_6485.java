package CT.SWEA.D3;

import java.util.HashMap;
import java.util.Scanner;

public class 삼성시의버스노선_6485 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();


        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            //
            HashMap<Integer, Integer> map = new HashMap<>();
            int N = sc.nextInt(); // 노선 N개

            for(int i=0; i<N; i++){
                int a = sc.nextInt(); // 노선에 따른 a~b
                int b = sc.nextInt();

                // 지나가는 구간의 카운트를 올리는 코드
                for(int j=a; j<=b; j++){
                    if(map.containsKey(j)){ // 시작점이 있는지 보고
                        int cnt = map.get(j); // 있다면 값 가져오고
                        map.replace(j, cnt+1); // 카운트 올린다.
                    }else{
                        map.put(j, 1); // 시작점이 없었다면 카운트 1로 신규 생성
                    }
                }
            }

            int P = sc.nextInt();
            for(int i=0; i<P; i++){
                int C = sc.nextInt(); // 버스 정류장 넘버 받아서
                if(!map.containsKey(C)) // 누적된 값이 없다면 영을 출력하고
                    sb.append(0).append(" ");
                else // 있다면 값을 출력
                    sb.append(map.get(C)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
