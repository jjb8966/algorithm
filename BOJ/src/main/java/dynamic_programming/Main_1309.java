package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1309 {

    private static int numberOfRow;
    private static int[][] caseOfPlaceLion;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfRow = Integer.parseInt(br.readLine());

        caseOfPlaceLion = new int[numberOfRow][3];  // 0열, 1열, 존재x
        result = new int[numberOfRow];
    }

    private static void process() {
        // 초기값
        caseOfPlaceLion[0][0] = 1;
        caseOfPlaceLion[0][1] = 1;
        caseOfPlaceLion[0][2] = 1;
        result[0] = caseOfPlaceLion[0][0] + caseOfPlaceLion[0][1] + caseOfPlaceLion[0][2];

        // 점화식
        for (int row = 1; row < numberOfRow; row++) {
            caseOfPlaceLion[row][0] = caseOfPlaceLion[row - 1][1] + caseOfPlaceLion[row - 1][2];
            caseOfPlaceLion[row][1] = caseOfPlaceLion[row - 1][0] + caseOfPlaceLion[row - 1][2];
            caseOfPlaceLion[row][2] = result[row - 1];

            result[row] = (caseOfPlaceLion[row][0] + caseOfPlaceLion[row][1] + caseOfPlaceLion[row][2]) % 9901;
        }
    }

    private static void output() {
        System.out.println(result[numberOfRow - 1]);
    }

}
