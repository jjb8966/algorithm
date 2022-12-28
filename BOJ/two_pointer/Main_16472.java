package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16472 {

    private static int kindOfAlphabet;
    private static int maxLength = Integer.MIN_VALUE;
    private static String[] expression;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        kindOfAlphabet = Integer.parseInt(br.readLine());
        expression = br.readLine().split("");
    }

    private static void process() {
        twoPointer();
    }

    private static void twoPointer() {
        int lengthOfExpression = expression.length;
        int right = 0;
        int totalCountOfAlphabet = 0;
        int currentLength;
        int[] countAlphabet = new int[26];

        for (int left = 0; left < lengthOfExpression; left++) {
            while (right < lengthOfExpression && totalCountOfAlphabet <= kindOfAlphabet) {
                char rightAlphabet = expression[right].charAt(0);

                if (countAlphabet[rightAlphabet - 97] == 0) {
                    totalCountOfAlphabet++;

                    if (totalCountOfAlphabet > kindOfAlphabet) {
                        totalCountOfAlphabet--;
                        break;
                    }
                }

                countAlphabet[rightAlphabet - 97]++;
                right++;
            }

            updateResult(right, left);

            totalCountOfAlphabet = initLeft(totalCountOfAlphabet, countAlphabet, left);
        }
    }

    private static void updateResult(int right, int left) {
        int currentLength = right - left;

        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
    }

    private static int initLeft(int totalCountOfAlphabet, int[] countAlphabet, int left) {
        char leftAlphabet = expression[left].charAt(0);

        if (--countAlphabet[leftAlphabet - 97] == 0) {
            totalCountOfAlphabet--;
        }

        return totalCountOfAlphabet;
    }

    private static void output() {
        System.out.println(maxLength);
    }

}