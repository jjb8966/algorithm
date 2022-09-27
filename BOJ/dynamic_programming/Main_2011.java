package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2011 {

    private static String encryptedNumbers;
    private static int lengthOfNumbers;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        encryptedNumbers = br.readLine();
        lengthOfNumbers = encryptedNumbers.length();

        result = new int[lengthOfNumbers];
    }

    private static void process() {
        if (encryptedNumbers.charAt(0) == '0') {
            result[lengthOfNumbers - 1] = 0;
            return;
        }

        // 초기값
        result[0] = 1;

        for (int digit = 1; digit < lengthOfNumbers; digit++) {
            int resultByOneDigit = 0;
            int resultByTwoDigit = 0;
            int targetNumber = encryptedNumbers.charAt(digit) - '0';

            if (targetNumber != 0) {
                resultByOneDigit = result[digit - 1];
            }

            if (isInterpretable(digit-1, digit)) {
                if (digit == 1) {
                    resultByTwoDigit = 1;
                } else {
                    resultByTwoDigit = result[digit - 2];
                }
            }

            result[digit] = (resultByOneDigit + resultByTwoDigit) % 1_000_000;
        }
    }

    private static boolean isInterpretable(int leftDigit, int rightDigit) {
        int leftNumber = encryptedNumbers.charAt(leftDigit) - '0';
        int rightNumber = encryptedNumbers.charAt(rightDigit) - '0';

        if (leftNumber == 0) {
            return false;
        }

        if (Integer.parseInt(leftNumber + "" + rightNumber) > 26) {
            return false;
        }

        return true;
    }

    private static void output() {
        System.out.println(result[lengthOfNumbers - 1]);
    }

}