package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int targetNumber;
    private static int[] result = new int[11 + 1];

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        process();

        for (int i = 0; i < testCase; i++) {
            input();
        }

        output();
    }

    private static void input() throws IOException {
        targetNumber = Integer.parseInt(br.readLine());
        sb.append(result[targetNumber]).append('\n');
    }

    private static void process() {
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;

        for (int index = 4; index <= 11; index++) {
            result[index] = result[index - 1] + result[index - 2] + result[index - 3];
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}