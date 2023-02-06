package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463 {

    static int number;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());

        dp = new int[number + 1];
    }

    private static void process() {
        if (number <= 3) {
            dp = new int[4];
        }

        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= number; i++) {
            int min = Integer.MAX_VALUE;

            if (i % 2 == 0) {
                min = Math.min(min, 1 + dp[i / 2]);
            }

            if (i % 3 == 0) {
                min = Math.min(min, 1 + dp[i / 3]);
            }

            min = Math.min(min, 1 + dp[i - 1]);

            dp[i] = min;
        }
    }

    private static void output() {
        System.out.println(dp[number]);
    }

}