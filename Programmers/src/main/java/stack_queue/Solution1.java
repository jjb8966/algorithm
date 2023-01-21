package stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution1 {

    public int[] solution(int[] arr) {
        Queue<Integer> queue;
        Stack<Integer> stack = new Stack<>();

        stack.add(arr[0]);

        for (int n : arr) {
            if (stack.peek() == n) {
                continue;
            }

            stack.add(n);
        }

        queue = new LinkedList<>(stack);

        return queue.stream().mapToInt(n -> n).toArray();
    }

    public static void main(String[] args) {
        Solution1 prob = new Solution1();
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        Arrays.stream(prob.solution(arr)).forEach(n -> System.out.print(n + " "));
    }

}