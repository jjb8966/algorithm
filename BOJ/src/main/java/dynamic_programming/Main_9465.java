package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9465 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int testCase;
    private static int numberOfColumn;
    private static int[][] scoreOfSticker;
    private static int[][] maxScore;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();
            process();
        }

        output();
    }

    private static void input() throws IOException {
        StringTokenizer st;

        numberOfColumn = Integer.parseInt(br.readLine());

        scoreOfSticker = new int[2][numberOfColumn];
        maxScore = new int[3][numberOfColumn];      // 0행, 1행, 선택 x -> 최대값
        result = new int[numberOfColumn];

        for (int row = 0; row < 2; row++) {
            st = new StringTokenizer(br.readLine());

            for (int column = 0; column < numberOfColumn; column++) {
                scoreOfSticker[row][column] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        // 초기값
        maxScore[0][0] = scoreOfSticker[0][0];
        maxScore[1][0] = scoreOfSticker[1][0];
        maxScore[2][0] = 0;

        result[0] = findMaxScore(0);

        // 점화식
        for (int column = 1; column < numberOfColumn; column++) {
            maxScore[0][column] = scoreOfSticker[0][column] + Math.max(maxScore[1][column - 1], maxScore[2][column - 1]);
            maxScore[1][column] = scoreOfSticker[1][column] + Math.max(maxScore[0][column - 1], maxScore[2][column - 1]);
            maxScore[2][column] = result[column - 1];

            result[column] = findMaxScore(column);
        }

        sb.append(result[numberOfColumn - 1]).append("\n");
    }

    private static int findMaxScore(int column) {
        int max = -1;

        for (int row = 0; row < 3; row++) {
            if (maxScore[row][column] > max) {
                max = maxScore[row][column];
            }
        }

        return max;
    }

    private static void output() {
        System.out.println(sb);
    }

}
