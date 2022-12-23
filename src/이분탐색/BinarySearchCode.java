package 이분탐색;

import java.util.Arrays;

public class BinarySearchCode {

    // 라이브러리 사용
    static void bs_library(int[] nArr, int target) {
        int res = Arrays.binarySearch(nArr, target);
    }

    // 기본 구현
    static int bs_basic(int[] nArr, int target) {
        int start = 0;
        int end = nArr.length-1;
        int mid = (end+start)/2;

        while (start <= end) {
            if (mid > target) {
                end = mid-1;
            } else if (mid < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -(start + 1); // 0 이상의 수는 값이 있을 때 리턴해야 해서 충돌 방지
    }

    // lower bound (주어진 값보다 같거나 큰 값이 처음으로 나오는걸 리턴)
    static int bs_lower(int[] nArr, int target) {
        int start = 0;
        int end = nArr.length; // target이 배열의 값들중 가장 클수도 있어서
        while (start < end) {
            final int mid = start + (end-start)/2; // (s+e)/2 할때 s+e에서 오버플로 방지
            // lower는 같은 타겟벨류중 작은! 인덱스가 중요
            if (target <= nArr[mid]) {
                // 소원대로 타겟이 탐색한 값보다 작다면
                // 범위를 좁혀 재탐색 (왼쪽 지향)
                end = mid;
            } else {
                start = mid + 1; // 오른쪽 탐색
            }
        }
        return start; // 타겟 벨류의 첫번째 자리 리턴 
    }

    // upper bound
    static int bs_upper(int[] nArr, int target) {
        int start = 0;
        int end = nArr.length;
        while (start < end) {
            final int mid = start + (end - start) / 2;
            // upper는 같은 타겟벨류중 큰! 인덱스가 중요
            if (target >= nArr[mid]) {
                // 소원대로 타겟이 탐색 값 보다 크다면
                // 범위를 좁혀 재탐색 (오른쪽 지향)
                start = mid + 1;
            } else {
                end = mid; // 그렇지 않다면 왼쪽 탐색
            }
        }
        return start; // 타겟 벨류보다 하나 더 큰 값의 인덱스 리턴
    }

    public static void main(String[] args) {

    }
}
