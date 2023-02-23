package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010 {

    static int n;
    static int r;
    static int[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();
            process();
//            process2();
        }

        output();
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][r + 1];
    }

    private static void process() {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= r; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                }

                if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= r; j++) {
                if (dp[i][j] != 0) {
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        sb.append(dp[n][r]).append('\n');
    }

    private static void process2() {
        sb.append(combination(n, r)).append('\n');
    }

    private static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            dp[n][r] = 1;

            return dp[n][r];
        }

        dp[n][r] = combination(n - 1, r) + combination(n - 1, r - 1);

        return dp[n][r];
    }

    private static void output() {
        System.out.println(sb);
    }

}