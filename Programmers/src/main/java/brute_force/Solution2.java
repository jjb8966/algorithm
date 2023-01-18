package brute_force;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution2 {

    public int[] solution(int[] answers) {
        int[] candidate1 = {1, 2, 3, 4, 5};
        int[] candidate2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] candidate3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[4];

        for (int i = 0; i < answers.length; i++) {
            int index1 = i % candidate1.length;
            int index2 = i % candidate2.length;
            int index3 = i % candidate3.length;

            if (answers[i] == candidate1[index1]) {
                count[1]++;
            }

            if (answers[i] == candidate2[index2]) {
                count[2]++;
            }

            if (answers[i] == candidate3[index3]) {
                count[3]++;
            }
        }

        int maxValue = Arrays.stream(count).max().getAsInt();

        return IntStream
                .range(0, count.length)
                .filter(i -> count[i] == maxValue)
                .toArray();
    }

    public static void main(String[] args) {
        Solution2 prob = new Solution2();

        int[] answers = {1, 3, 2, 4, 2};

        Arrays.stream(prob.solution(answers)).forEach(n -> System.out.print(n + " "));
    }
}
