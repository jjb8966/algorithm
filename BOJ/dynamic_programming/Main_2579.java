package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579 {

    private static int numberOfStair;
    private static int[] stairs;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfStair = Integer.parseInt(br.readLine());

        stairs = new int[numberOfStair + 1];
        result = new int[numberOfStair + 1][2];

        for (int i = 1; i <= numberOfStair; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void process() {
        result[1][1] = stairs[1];

        if (numberOfStair >= 2) {
            result[2][0] = stairs[2];
            result[2][1] = stairs[1] + stairs[2];
        }

        for (int stair = 3; stair <= numberOfStair; stair++) {
            result[stair][0] = Math.max(result[stair - 2][0], result[stair - 2][1]) + stairs[stair];
            result[stair][1] = result[stair - 1][0] + stairs[stair];
        }
    }

    private static void output() {
        System.out.println(Math.max(result[numberOfStair][0], result[numberOfStair][1]));
    }

}