package search;

public class Solution1 {

    int count = 0;
    int length;
    int[] operations;

    public int solution(int[] numbers, int target) {
        length = numbers.length;
        operations = new int[length];

        dfs(0, numbers, target);

        return count;
    }

    private void dfs(int digit, int[] numbers, int target) {
        if (digit == numbers.length) {
            int sum = 0;

            for (int i = 0; i < length; i++) {
                if (operations[i] == 0) {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }

            if (sum == target) {
                count++;
            }

            return;
        }

        for (int operation = 0; operation < 2; operation++) {
            operations[digit] = operation;

            dfs(digit + 1, numbers, target);
        }
    }

    public static void main(String[] args) {
        Solution1 prob = new Solution1();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;

        System.out.println(prob.solution(numbers2, target2));
    }

}