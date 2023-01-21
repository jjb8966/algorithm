package stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class Solution2 {

    public int[] solution(int[] progress, int[] speeds) {
        int length = progress.length;
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            int remain = 100 - progress[i];
            int neededDay;

            if (remain % speeds[i] == 0) {
                neededDay = remain / speeds[i];
            } else {
                neededDay = remain / speeds[i] + 1;
            }

            if (neededDay > max) {
                max = neededDay;
                stack.push(1);
            } else {
                Integer lastCount = stack.pop();
                lastCount++;
                stack.push(lastCount);
            }
        }

        return stack.stream()
                .mapToInt(n -> n)
                .toArray();
    }

    public static void main(String[] args) {
        Solution2 prob = new Solution2();
        int[] progress = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] progress2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        Arrays.stream(prob.solution(progress, speeds)).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Arrays.stream(prob.solution(progress2, speeds2)).forEach(n -> System.out.print(n + " "));
    }

}