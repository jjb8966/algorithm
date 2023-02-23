package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15988 {

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
        if (maxNumber <= 3) {
            result = new long[3 + 1];
        }

        // 초기화
        result[1] = 1L;
        result[2] = 2L;
        result[3] = 4L;

        // 점화식
        if (maxNumber > 3) {
            for (int target = 4; target <= maxNumber ; target++) {
                result[target] = (result[target - 1] + result[target - 2] + result[target - 3]) % 1_000_000_009;
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
