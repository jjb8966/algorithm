package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726 {

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

        dp = new int[targetNumber + 1];
    }

    private static void process() {
        if (targetNumber <= 3) {
            dp = new int[3 + 1];
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int number = 4; number <= targetNumber; number++) {
            dp[number] = dp[number - 1] + dp[number - 2];
            dp[number] %= 10_007;
        }
    }

    private static void output() {
        System.out.println(dp[targetNumber]);
    }

}