package brute_force;

import java.util.Arrays;

public class Solution1 {

    public int solution(int[][] sizes) {
        int answer;
        int[] width = new int[sizes.length];
        int[] height = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                width[i] = sizes[i][0];
                height[i] = sizes[i][1];
            } else {
                height[i] = sizes[i][0];
                width[i] = sizes[i][1];
            }
        }

        int maxWidth = Arrays.stream(width).max().getAsInt();
        int maxHeight = Arrays.stream(height).max().getAsInt();

        answer = maxWidth * maxHeight;

        return answer;
    }

    public static void main(String[] args) {
        Solution1 prob = new Solution1();

        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };

        System.out.println(prob.solution(sizes));
    }

}
