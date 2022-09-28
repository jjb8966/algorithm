package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2193 {

    private static int numberOfDigit;
    private static long[][] countOfCase;
    private static long[] result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfDigit = Integer.parseInt(br.readLine());

        countOfCase = new long[numberOfDigit][2];    // 0으로 끝나는지 1로 끝나는지
        result = new long[numberOfDigit];
    }

    private static void process() {
        if (numberOfDigit < 2) {
            countOfCase = new long[2][2];
            result = new long[2];
        }

        // 초기값
        countOfCase[0][1] = 1;
        countOfCase[1][0] = 1;
        result[0] = 1;
        result[1] = 1;

        // 점화식
        for (int digit = 2; digit < numberOfDigit; digit++) {
            // 현재 자릿수가 0으로 끝나는 경우
            countOfCase[digit][0] = result[digit - 1];

            // 현재 자릿수가 1로 끝나는 경우
            countOfCase[digit][1] = countOfCase[digit - 1][0];

            result[digit] = countOfCase[digit][0] + countOfCase[digit][1];
        }
    }

    private static void output() {
        System.out.println(result[numberOfDigit - 1]);
    }

}