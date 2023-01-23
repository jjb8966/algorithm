package stack_queue;

import java.util.*;

public class Solution6 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int currentIndex = 0; currentIndex < prices.length; currentIndex++) {
            int count = 0;

            for (int nextIndex = currentIndex + 1; nextIndex < prices.length; nextIndex++) {
                count++;
                if (prices[currentIndex] > prices[nextIndex]) {
                    break;
                }
            }

            answer[currentIndex] = count;
        }

        return answer;
    }

    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;  // 가격이 떨어진 인덱스의 답
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();    // 가격이 떨어지지 않은 인덱스의 답
            answer[index] = prices.length - index - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution6 prob = new Solution6();
        int[] prices = {1, 2, 3, 2, 3};

        Arrays.stream(prob.solution(prices)).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Arrays.stream(prob.solution2(prices)).forEach(n -> System.out.print(n + " "));
    }
}
