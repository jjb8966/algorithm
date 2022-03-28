package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579 {
    private static int numberOfStair;
    private static int[] stairs;
    private static int[][] dynamicSolution;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfStair = Integer.parseInt(br.readLine());

        stairs = new int[numberOfStair + 1];        // 인덱스 : 1 ~ numberOfStair
        dynamicSolution = new int[numberOfStair + 1][2];    // dynamicSolution[i][0] : i-2 -> i 계단으로 온 것 중 최대값
        // dynamicSolution[i][1] : i-1 -> i 계단으로 온 것 중 최대값

        for (int i = 1; i <= numberOfStair; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void process() {
        // 초기값
        dynamicSolution[0][0] = 0;
        dynamicSolution[0][1] = 0;
        dynamicSolution[1][0] = 0;
        dynamicSolution[1][1] = stairs[1];

        if (numberOfStair >= 2) {
            dynamicSolution[2][0] = stairs[2];
            dynamicSolution[2][1] = stairs[1] + stairs[2];

            // 점화식
            for (int i = 3; i <= numberOfStair; i++) {
                dynamicSolution[i][0] = Integer.max(dynamicSolution[i - 2][0], dynamicSolution[i - 2][1]) + stairs[i];
                dynamicSolution[i][1] = dynamicSolution[i - 1][0] + stairs[i];
            }
        }

        int result = Integer.max(dynamicSolution[numberOfStair][0], dynamicSolution[numberOfStair][1]);
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
