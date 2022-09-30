package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2688 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int testCase;
    private static int numberOfDigit;
    private static long[][] caseOfNotReduceNumber;

    public static void main(String[] args) throws IOException {
        testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();
            process();
        }

        output();
    }

    private static void input() throws IOException {
        numberOfDigit = Integer.parseInt(br.readLine());

        caseOfNotReduceNumber = new long[numberOfDigit][10];     // 특정 자릿수에서 0~9 사이의 숫자를 선택했을 때 가능한 경우의 수
    }

    private static void process() {
        // 초기값
        for (int possibleNumber = 0; possibleNumber < 10; possibleNumber++) {
            caseOfNotReduceNumber[0][possibleNumber] = 1;
        }

        // 점화식
        for (int digit = 1; digit < numberOfDigit; digit++) {
            for (int candidateNumber = 0; candidateNumber < 10; candidateNumber++) {
                for (int availableNumber = 0; availableNumber <= candidateNumber; availableNumber++) {
                    caseOfNotReduceNumber[digit][candidateNumber] += caseOfNotReduceNumber[digit - 1][availableNumber];
                }
            }
        }

        long result = Arrays.stream(caseOfNotReduceNumber[numberOfDigit - 1]).sum();

        sb.append(result).append("\n");
    }

    private static void output() {
        System.out.println(sb);
    }

}