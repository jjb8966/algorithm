package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10870 {

    private static int targetNumber;
    private static int[] fibonacciNumber = new int[21];

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
        fibonacciFunction();
    }

    private static void fibonacciFunction() {
        fibonacciNumber[0] = 0;
        fibonacciNumber[1] = 1;

        for (int i = 2; i <= 20; i++) {
            fibonacciNumber[i] = fibonacciNumber[i - 1] + fibonacciNumber[i - 2];
        }
    }

    private static void output() {
        System.out.println(fibonacciNumber[targetNumber]);
    }

}
