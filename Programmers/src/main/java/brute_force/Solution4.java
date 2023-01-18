package brute_force;

import java.util.Arrays;

public class Solution4 {

    public int[] solution(int brown, int yellow) {
        int width = 3;
        int[] answer = new int[2];
        boolean end = false;

        while (!end) {
            for (int height = 3; height <= width; height++) {
                int tempBrown = (width * 2) + (height * 2) - 4;
                int tempYellow = width * height - tempBrown;

                if (tempBrown == brown && tempYellow == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    end = true;
                }
            }

            width++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution4 prob = new Solution4();
        int brown = 8;
        int yellow = 1;

        Arrays.stream(prob.solution(brown, yellow)).forEach(n -> System.out.print(n + " "));
    }

}
