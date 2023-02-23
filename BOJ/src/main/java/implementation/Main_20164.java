package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_20164 {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static String startNumber;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        startNumber = br.readLine();
    }

    private static void process() {
        bruteForce(startNumber, 0);
        sb.append(min).append(" ").append(max);
    }

    private static void bruteForce(String number, int sum) {
        int parseInt = Integer.parseInt(number);

        if (parseInt < 10) {
            if (parseInt % 2 != 0) {
                sum++;
            }

            min = Math.min(min, sum);
            max = Math.max(max, sum);

            return;
        }

        int length = number.length();
        sum += countOddNumber(number);

        if (length == 2) {
            int operand1 = number.charAt(0) - '0';
            int operand2 = number.charAt(1) - '0';
            int newNumber = operand1 + operand2;

            bruteForce(String.valueOf(newNumber), sum);

            return;
        }

        if (length > 2) {
            int operand1;
            int operand2;
            int operand3;
            int newNumber;

            for (int first = 0; first < length - 2; first++) {
                for (int second = first + 1; second < length - 1; second++) {
                    operand1 = Integer.parseInt(number.substring(0, first + 1));
                    operand2 = Integer.parseInt(number.substring(first + 1, second + 1));
                    operand3 = Integer.parseInt(number.substring(second + 1, length));

                    newNumber = operand1 + operand2 + operand3;

                    bruteForce(String.valueOf(newNumber), sum);
                }
            }
        }
    }

    private static int countOddNumber(String number) {
        int count = 0;

        for (int i = 0; i < number.length(); i++) {
            int oneDigit = number.charAt(i) - '0';

            if (oneDigit % 2 != 0) {
                count++;
            }
        }

        return count;
    }

    private static void output() {
        System.out.println(sb);
    }

}