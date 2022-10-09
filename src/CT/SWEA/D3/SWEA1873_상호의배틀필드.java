package CT.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1873_상호의배틀필드 {

    static char[][] map;
    static int curMapH;
    static int curMapW;

    static int tankRow;
    static int tankCol;
    static char curTankShape;

    static int curCmdSize;
    static char[] curCmdArr;


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int cNum = 1; cNum <= TC; cNum++) {

            String[] arrWHinfo = br.readLine().split(" ");

            curMapH = Integer.parseInt(arrWHinfo[0]);
            curMapW = Integer.parseInt(arrWHinfo[1]);
//			System.out.println(H + " " + W);

            map = new char[curMapH][curMapW];

            for (int i = 0; i < curMapH; i++) {
                map[i] = br.readLine().toCharArray().clone();
            }

//			System.out.println("처음");
//			System.out.println(Arrays.deepToString(map));

            // 현재 탱크 위치 찾기
            for (int i = 0; i < curMapH; i++) {
                for (int j = 0; j < curMapW; j++) {
                    if(map[i][j] == '^' || map[i][j] == '>' ||
                            map[i][j] == 'v' || map[i][j] == '<') {
                        tankRow = i;
                        tankCol = j;
                    }
                }
            }

            curTankShape = map[tankRow][tankCol]; // 탱크 형태 초기화

//			System.out.println(tankX + " " + tankY);

            curCmdSize = Integer.parseInt(br.readLine());

            curCmdArr = br.readLine().toCharArray();

            // 명령어 만큼 루프 돌기
            for (char curCmd : curCmdArr) {
//				System.out.println(curCmd);
                switch (curCmd) {
                    case 'U':
                        changeShape('^');
                        moveTank(tankRow-1, tankCol);
                        break;

                    case 'D':
                        changeShape('v');
                        moveTank(tankRow+1, tankCol);
                        break;

                    case 'L':
                        changeShape('<');
                        moveTank(tankRow, tankCol-1);
                        break;

                    case 'R':
                        changeShape('>');
                        moveTank(tankRow, tankCol+1);
                        break;

                    case 'S':
                        // 바라보는 방향으로 포탄 발사
                        switch (curTankShape) {

                            case '^':
                                shoot(-1, 0);
                                break;

                            case 'v':
                                shoot(1, 0);
                                break;

                            case '>':
                                shoot(0, 1);
                                break;

                            case '<':
                                shoot(0, -1);
                                break;

                            default:
                                break;
                        }

                        break;

                    default:
                        break;
                }
//				System.out.println(Arrays.deepToString(map));
            }

            // 최종 출력
            System.out.print("#"+cNum+" ");
            for (int i = 0; i < curMapH; i++) {
                for (int j = 0; j < curMapW; j++) {
                    System.out.print(map[i][j]);
                }System.out.println();
            }

        }
    }

//	0<=movRow && movRow < curMapH && 0<=movCol && movCol < curMapW

    static void shoot(int dx, int dy) {
//		System.out.println(tankRow + " " + tankCol + " " + dx + " " + dy + " ");
        int movRow = tankRow; // 먼저 가보는 위치 변수 초기화.. 아래 반복문에서 진행..
        int movCol = tankCol;
//		System.out.println(movRow + " " + movCol);
        while(true) {
            movRow += dx; // 뻥 뚫려있을때 총알 전진..
            movCol += dy;

            if(!(0<=movRow && movRow < curMapH && 0<=movCol && movCol < curMapW)) { // 맵을 벗어났다면..
                break;

            }else if (map[movRow][movCol] == '*') { // 벽돌이 있다면..
                map[movRow][movCol] = '.';
                break;

            }else if (map[movRow][movCol] == '#') { // 강철이 있다면..
                break;
            }

        }
    }


    static boolean checkFlat(int moveRow, int moveCol) {
        // 해당 위치가 평지인지 체크한다.
        if(0<=moveRow && moveRow < curMapH && 0<=moveCol && moveCol < curMapW &&
                map[moveRow][moveCol] == '.') { // 정상 범위면서 평지면..
            return true;
        }else {
            return false; // 아니면...
        }
    }


    static void moveTank(int moveRow, int moveCol) {
        // 현재 위치를 평지로 두고 탱크를 원하는 위치로 옮긴다.
        // 해당 좌표가 평지면..
        if(checkFlat(moveRow, moveCol)) {
            map[tankRow][tankCol] = '.'; // 원래 있던 자리를 평지로 바꾸고
            map[moveRow][moveCol] = curTankShape; // 목표자리에 현재 탱크 모습을 복사
            tankRow = moveRow;
            tankCol = moveCol;
        }

    }


    static void changeShape(char tankShape) {
        // 받은 모습으로 현 위치의 탱크 모습을 바꾼다
        map[tankRow][tankCol] = tankShape;
        curTankShape = tankShape;
    }


}
