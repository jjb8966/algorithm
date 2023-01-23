package greedy;

public class Solution3 {

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int next = 0;

        for (int i = 0; i < number.length() - k; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = index; j <= i + k; j++) {
                int current = number.charAt(j) - '0';

                if (current > max) {
                    max = current;
                    next = j + 1;
                }
            }

            sb.append(max);
            index = next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution3 prob = new Solution3();

        String number = "1924";
        int k = 2;

        String number2 = "4177252841";
        int k2 = 4;

        System.out.println(prob.solution(number, k));
        System.out.println(prob.solution(number2, k2));
    }

}