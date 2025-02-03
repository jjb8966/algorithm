package data_structure.최대_길이_연속수열;

import java.util.HashSet;

public class Answer {
    /**
     * 주어진 정수 배열에서 가장 긴 연속된 수열의 길이를 반환합니다.
     *
     * 알고리즘:
     * 1. 집합(Set)을 사용해 중복 요소 제거 및 O(1) 조회 시간 보장
     * 2. 각 숫자가 수열의 시작점인지 확인(x-1 이 존재하지 않을 때 시작점)
     * 3. 시작점부터 연속된 숫자 카운팅
     *
     * @param nums 정수 배열 입력
     * @return 가장 긴 연속 수열의 길이
     */
    public int solution(int[] nums) {
        int maxLength = 0;
        HashSet<Integer> numSet = new HashSet<>();

        // 배열 요소를 집합에 저장 (중복 제거)
        for (int num : nums) {
            numSet.add(num);
        }

        // 모든 고유 숫자에 대해 탐색
        for (int currentNum : numSet) {
            // 현재 숫자가 연속 수열의 시작점이 아니라면 건너뜀
            if (numSet.contains(currentNum - 1)) {
                continue;
            }

            // 현재 숫자부터 연속된 수열의 길이 계산
            int length = 0;
            while (numSet.contains(currentNum)) {
                length++;
                currentNum++;
            }

            // 최대 길이 갱신
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Answer T = new Answer();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3})); // 5
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0})); // 10
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3})); // 1
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1})); // 5
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7})); // 3
    }
}