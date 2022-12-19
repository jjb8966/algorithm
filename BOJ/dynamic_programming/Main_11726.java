package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726 {

    private static int targetNumber;
    private static long[] result = new long[1000 + 1];

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        targetNumber = Integer.parseInt(br.readLine());
    }

    private static void process() {
        result[1] = 1;
        result[2] = 2;

        for (int index = 3; index <= targetNumber; index++) {
            result[index] = (result[index - 1] + result[index - 2]) % 10_007;
        }
    }

    private static void output() {
        System.out.println(result[targetNumber]);
    }

}