package lv2;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_181188 {

    public int solution(int[][] targets) {
        int answer = 0;
        int numberOfMissiles = targets.length;
        boolean[] visited = new boolean[numberOfMissiles];

        Arrays.sort(targets, Comparator.comparing(o -> o[0]));

        for (int idx1 = 0; idx1 < numberOfMissiles; idx1++) {
            if (visited[idx1]) {
                continue;
            }

            answer++;

            int[] missile = targets[idx1];

            for (int idx2 = idx1 + 1; idx2 < numberOfMissiles; idx2++) {
                int[] candidate = targets[idx2];

                if (candidate[0] >= missile[1]) {
                    break;
                }

                visited[idx2] = true;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_181188 prob = new Solution_181188();
        int[][] targets = {
                {4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}
        };

        int[][] targets2 = {
                {1, 4},
                {4, 8},
                {2, 7}
        };

        int[][] targets3 = {
                {3, 9},
                {2, 7},
                {3, 7},
                {1, 4}
        };

        int[][] targets4 = {
                {1, 4}, {2, 3}, {3, 5}
        };

        System.out.println(prob.solution(targets4));
    }

}