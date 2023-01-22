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
            int neededDay = (int) Math.ceil(remain / (double) speeds[i]);

            if (neededDay > max) {
                max = neededDay;
                stack.push(1);
            } else {
                stack.push(stack.pop() + 1);
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