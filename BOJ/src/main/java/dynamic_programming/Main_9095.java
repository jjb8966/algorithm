package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095 {

    static int targetNumber;
    static int[] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();
            process();
        }

        output();
    }

    private static void input() throws IOException {
        targetNumber = Integer.parseInt(br.readLine());
        dp = new int[targetNumber + 1];
    }

    private static void process() {
        if (targetNumber <= 3) {
            dp = new int[3 + 1];
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int number = 4; number <= targetNumber; number++) {
            dp[number] = dp[number - 1] + dp[number - 2] + dp[number - 3];
        }

        sb.append(dp[targetNumber]).append('\n');
    }

    private static void output() {
        System.out.println(sb);
    }

}