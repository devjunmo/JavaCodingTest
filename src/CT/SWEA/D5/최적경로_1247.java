package CT.SWEA.D5;

import java.io.*;
import java.util.*;

public class 최적경로_1247 {
    static int companyX, companyY, homeX, homeY, minDist=Integer.MAX_VALUE, N;
    static ArrayList<Coor> customer;
    static boolean[] isSelected;
    static class Coor{ // 고객 좌표 저장을 위한 커스텀 클래스
        int x, y;
        public Coor(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static void dfs(int curX, int curY, int lev, int curDist) {
        if (lev == N) {
            // 마지막 고객과 집까지의 거리 계산
            int dist = Math.abs(curX - homeX) + Math.abs(curY - homeY);
            if (minDist > curDist+dist) {
                minDist = curDist+dist;
            }
            return;
        }
        // 현 위치를 업데이트 하며 가능한 모든 좌표들과 비교
        for (int i = 0; i < customer.size(); i++) {
            if (isSelected[i]) continue;
            int nextX = customer.get(i).x;
            int nextY = customer.get(i).y;
            isSelected[i] = true;
            int dist = Math.abs(curX - nextX) + Math.abs(curY - nextY);
            dfs(nextX, nextY, lev + 1, curDist+dist);
            isSelected[i] = false;
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            minDist=Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine()); // 고객의 수
            isSelected = new boolean[N];
            customer = new ArrayList<>(); // 고객 좌표 객체 리스트

            String[] input = br.readLine().split(" ");
            companyX = Integer.parseInt(input[0]); // 회사 좌표
            companyY = Integer.parseInt(input[1]);
            homeX = Integer.parseInt(input[2]); // 집 좌표
            homeY = Integer.parseInt(input[3]);
            // 고객 좌표 넣기
            for(int i=4; i<(N+2)*2; i+=2){
                customer.add(new Coor(Integer.parseInt(input[i]),
                        Integer.parseInt(input[i+1])));
            }
            int curX = companyX; // 현재 비교할 대상 위치
            int curY = companyY;

            dfs(curX, curY, 0, 0);
            bw.write("#"+tc+" "+minDist+"\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}
