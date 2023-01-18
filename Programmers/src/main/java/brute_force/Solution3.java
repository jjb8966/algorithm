package brute_force;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    int length;
    int[] candidate;
    Set<Integer> set;
    boolean[] visited;

    public int solution(String numbers) {
        length = numbers.length();
        candidate = new int[length];
        set = new HashSet<>();

        for (int maxDigit = 0; maxDigit < length; maxDigit++) {
            visited = new boolean[length];

            bruteForce(0, maxDigit, numbers);
        }

        return set.size();
    }

    private void bruteForce(int digit, int maxDigit, String numbers) {
        if (digit > maxDigit) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i <= maxDigit; i++) {
                sb.append(candidate[i]);
            }

            int number = Integer.parseInt(sb.toString());

            if (number == 0 || number == 1) {
                return;
            }

            for (int divide = 2; divide < number; divide++) {
                if ((number % divide) == 0) {
                    return;
                }
            }

            set.add(number);

            return;
        }

        for (int index = 0; index < numbers.length(); index++) {
            if (visited[index]) {
                continue;
            }

            candidate[digit] = numbers.charAt(index) - '0';

            visited[index] = true;
            bruteForce(digit + 1, maxDigit, numbers);
            visited[index] = false;
        }
    }

    public static void main(String[] args) {
        Solution3 prob = new Solution3();
        String numbers = "011";

        System.out.println(prob.solution(numbers));
    }

}
