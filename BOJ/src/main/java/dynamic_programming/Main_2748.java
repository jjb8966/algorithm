package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2748 {

    private static int targetNumber;
    private static long[] result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        targetNumber = Integer.parseInt(br.readLine());

        result = new long[targetNumber + 1];
    }

    private static void process() {
        if (targetNumber < 2) {
            result = new long[2];
        }

        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= targetNumber; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
    }

    private static void output() {
        System.out.println(result[targetNumber]);
    }

}
