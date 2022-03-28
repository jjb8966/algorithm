package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095 {
    private static int numberOfTestCase;
    private static int[] numbers;
    private static int[] dynamicSolution;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfTestCase = Integer.parseInt(br.readLine());

        numbers = new int[numberOfTestCase];
        dynamicSolution = new int[12];     // 인덱스 : 1 ~ 11

        for (int i = 0; i < numberOfTestCase; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void process() {      // dynamicProgramming 배열을 미리 만들어 놓음
        // 초기값 설정
        dynamicSolution[1] = 1;
        dynamicSolution[2] = 2;
        dynamicSolution[3] = 4;

        // 점화식 작성
        for (int i = 4; i <= 11; i++) {
            dynamicSolution[i] = dynamicSolution[i - 1] + dynamicSolution[i - 2] + dynamicSolution[i - 3];
        }

        printResult();
    }

    private static void printResult() {
        for (int i = 0; i < numberOfTestCase; i++) {
            System.out.println(dynamicSolution[numbers[i]]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
