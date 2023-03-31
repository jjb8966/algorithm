package lv3;

import java.util.Arrays;

public class Solution_150367 {

    private int[] solution(long[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            String fullBinary = getFullBinary(numbers[i]);

            if (isCompleteBinaryTree(fullBinary)) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    private boolean isCompleteBinaryTree(String binary) {
        int length = binary.length();
        int root = length / 2;

        if (length == 1) {
            return true;
        }

        String leftSubTree = binary.substring(0, root);
        String rightSubTree = binary.substring(root + 1);

        if (binary.charAt(root) == '0') {
            return isZeroTree(leftSubTree) && isZeroTree(rightSubTree);
        }

        return isCompleteBinaryTree(leftSubTree) && isCompleteBinaryTree(rightSubTree);
    }

    private boolean isZeroTree(String binary) {
        return binary.chars().allMatch(character -> character == '0');
    }

    private String getFullBinary(long number) {
        String binary = Long.toBinaryString(number);
        int length = binary.length();
        int digit = 1;
        int multiple = 1;

        while (length > digit) {
            multiple *= 2;
            digit += multiple;
        }

        int gap = digit - length;

        return "0".repeat(gap) + binary;
    }

    public static void main(String[] args) {
        Solution_150367 prob = new Solution_150367();
        long[] numbers = {7, 42, 5};
        long[] numbers2 = {63, 111, 95};
        long[] numbers3 = {42};

        int[] solution = prob.solution(numbers2);
        Arrays.stream(solution).forEach(n -> System.out.print(n + " "));
    }

}