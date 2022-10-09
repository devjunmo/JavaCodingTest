package CT.SWEA.D3;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.List;
        import java.util.stream.Collectors;

public class SWEA1208_Flatten {

    static int CNUM = 10;
    static List<Integer> buildingLst;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= CNUM; i++) {

            int dumpCnt = Integer.parseInt((br.readLine()));

            int[] buildingArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            buildingLst = Arrays.stream(buildingArr).boxed().collect(Collectors.toList());

            for (int j = 0; j < dumpCnt; j++) {

                int curMaxVal = Collections.max(buildingLst);
                int curMinVal = Collections.min(buildingLst);

                if(checkFlat(curMaxVal, curMinVal)) {
                    break;
                }

                int maxIdx = buildingLst.indexOf(curMaxVal);
                int minIdx = buildingLst.indexOf(curMinVal);

                dump(maxIdx, minIdx);

            }

            System.out.println("#" + i + " " + (Collections.max(buildingLst)-Collections.min(buildingLst)));

        }

    }

    public static void dump(int maxIdx, int minIdx) {

        int editMaxVal = buildingLst.get(maxIdx) - 1;
        int editMinVal = buildingLst.get(minIdx) + 1;

        buildingLst.set(maxIdx, editMaxVal);
        buildingLst.set(minIdx, editMinVal);



    }

    public static boolean checkFlat(int maxVal, int minVal) {

        if(maxVal-minVal <= 1) {
            return true;
        }else {
            return false;
        }

    }

}
