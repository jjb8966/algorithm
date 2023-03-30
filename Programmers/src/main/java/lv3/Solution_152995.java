package lv3;

import java.util.Arrays;

public class Solution_152995 {

    public int solution(int[][] scores) {
        int answer = 1;
        int maxPeerReviewScore = 0; // 현재까지 동료 평가 점수 최댓값
        int[] whScore = scores[0]; // 완호의 근무 태도 점수
        int whSum = whScore[0] + whScore[1];

        // 근무 태도 점수 내림차순, 동료 평가 점수 오름차순으로 정렬
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        for (int i = 0; i < scores.length; i++) {
            int[] curScore = scores[i];

            if (maxPeerReviewScore > curScore[1]) {     // 동료 평가 점수가 더 낮으면 무조건 인센티브 못받음 (근무 태도 점수로 내림차순한 상태이므로)
                if (whScore[0] == curScore[0] && whScore[1] == curScore[1]) {
                    return -1;
                }
            } else {
                if (whSum < curScore[0] + curScore[1]) {
                    answer++;
                }

                maxPeerReviewScore = curScore[1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_152995 prob = new Solution_152995();
        int[][] scores = {
                {2, 2},
                {1, 4},
                {3, 2},
                {3, 2},
                {2, 1}
        };

        System.out.println(prob.solution(scores));
    }

}