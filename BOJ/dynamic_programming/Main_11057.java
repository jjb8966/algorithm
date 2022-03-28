package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class   Main_11057 {
    private static int length;
    private static int[][] dynamicSolution;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());
        dynamicSolution = new int[length + 1][10];
    }

    private static void process() {
        // 초기값
        for (int i = 0; i <= 9; i++) {
            dynamicSolution[1][i] = 1;
        }

        // 점화식
        if (length >= 2) {
            for (int i = 2; i <= length; i++) {
                for (int j = 0; j <= 9; j++) {
                    for (int k = 0; k <= j; k++) {
                        dynamicSolution[i][j] += dynamicSolution[i - 1][k] % 10007;
                    }
                }
            }
        }

        int result = 0;

        for (int i = 0; i <= 9; i++) {
            result += dynamicSolution[length][i] % 10007;
        }

        result %= 10007;

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
