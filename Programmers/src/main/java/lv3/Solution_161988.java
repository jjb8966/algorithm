package lv3;

import java.util.Arrays;

class Solution_161988 {
    public long solution(int[] sequence) {
        long answer = 0;
        int length = sequence.length;
        int[][] dp = new int[2][length];

        dp[0][0] = sequence[0];
        dp[1][0] = sequence[0] * -1;

        for (int index = 1; index < length; index++) {
            int number = sequence[index];

            if (index % 2 == 1) {
                dp[0][index] = Math.max(dp[0][index - 1] + (number * -1), number * -1);
                dp[1][index] = Math.max(dp[1][index - 1] + number, number);
            } else {
                dp[0][index] = Math.max(dp[0][index - 1] + number, number);
                dp[1][index] = Math.max(dp[1][index - 1] + (number * -1), number * -1);
            }
        }

        Arrays.sort(dp[0]);
        Arrays.sort(dp[1]);

        answer = Math.max(dp[0][length - 1], dp[1][length - 1]);

        return answer;
    }

    public static void main(String[] args) {
        Solution_161988 prob = new Solution_161988();
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};

        System.out.println(prob.solution(sequence));
    }
}