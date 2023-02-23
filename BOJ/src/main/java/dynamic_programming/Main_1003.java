package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1003 {

    private static int testCase;
    private static int[] targetNumber;
    private static int[][] fibonacciSequence = new int[40 + 1][2];  // 피보나치 수열 결과 -> 0,1 갯수 저장;

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
    }

    private static void process() {
        fibonacciFunction();
    }

    private static void fibonacciFunction() {
        // 초기값 설정
        fibonacciSequence[0][0] = 1;
        fibonacciSequence[0][1] = 0;
        fibonacciSequence[1][0] = 0;
        fibonacciSequence[1][1] = 1;

        // 점화식 작성
        for (int target = 2; target <= 40; target++) {
            for (int digit = 0; digit < 2; digit++) {
                fibonacciSequence[target][digit] = fibonacciSequence[target - 1][digit] + fibonacciSequence[target - 2][digit];
            }
        }
    }

    private static void output() {
        for (int i = 0; i < testCase; i++) {
            int target = targetNumber[i];

            System.out.print(fibonacciSequence[target][0] + " " + fibonacciSequence[target][1]);
            System.out.println();
        }
    }
}
