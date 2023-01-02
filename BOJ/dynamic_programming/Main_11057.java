package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11057 {

    private static int lengthOfNumber;
    private static int[][] result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        lengthOfNumber = Integer.parseInt(br.readLine());

        result = new int[lengthOfNumber + 1][10];
    }

    private static void process() {
        for (int number = 0; number <= 9; number++) {
            result[1][number] = 1;
        }

        if (lengthOfNumber >= 2) {
            for (int digit = 2; digit <= lengthOfNumber; digit++) {
                for (int number = 0; number <= 9; number++) {
                    for (int lessThanNumber = 0; lessThanNumber <= number; lessThanNumber++) {
                        result[digit][number] += result[digit - 1][lessThanNumber] % 10_007;
                    }
                }
            }
        }

        updateResult();
    }

    private static void updateResult() {
        int sum = 0;

        for (int number = 0; number <= 9; number++) {
            sum += result[lengthOfNumber][number] % 10_007;
        }

        sb.append(sum % 10_007);
    }

    private static void output() {
        System.out.println(sb);
    }

}