package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15991 {

    private static StringBuilder sb = new StringBuilder();
    private static int testCase;
    private static int maxNumber;
    private static int[] targetNumber;
    private static long[] result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());

        targetNumber = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            targetNumber[i] = Integer.parseInt(br.readLine());
        }

        maxNumber = Arrays.stream(targetNumber).max().getAsInt();

        result = new long[maxNumber + 1];
    }

    private static void process() {
        if (maxNumber <= 6) {
            result = new long[6 + 1];
        }

        // 초기화
        result[1] = 1L;
        result[2] = 2L;
        result[3] = 2L;
        result[4] = 3L;
        result[5] = 3L;
        result[6] = 6L;

        // 점화식
        if (maxNumber > 6) {
            for (int target = 7; target <= maxNumber ; target++) {
                result[target] = (result[target - 2] + result[target - 4] + result[target - 6]) % 1_000_000_009;
            }
        }

        for (int i = 0; i < testCase; i++) {
            sb.append(result[targetNumber[i]]).append("\n");
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}
