package stack_queue;

import java.util.Stack;

public class Solution3 {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char parenthesis : s.toCharArray()) {
            if (parenthesis == '(') {
                stack.push(parenthesis);
            }

            if (parenthesis == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution3 prob = new Solution3();
        String s = "(())()";

        System.out.println(prob.solution(s));
    }

}