package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17626 {

    static int targetNumber;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        targetNumber = Integer.parseInt(br.readLine());

        dp = new int[50_000 + 1];
    }

    private static void process() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int number = 4; number <= targetNumber; number++) {
            int sqr = 1;
            int min = Integer.MAX_VALUE;

            while (number >= sqr * sqr) {
                min = Math.min(min, 1 + dp[number - sqr * sqr]);
                sqr++;
            }

            dp[number] = min;
        }
    }

    private static void output() {
        System.out.println(dp[targetNumber]);
    }

}