package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231 {

    private static int targetNumber;
    private static int result;

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
        for (int candidateNumber = 1; candidateNumber < targetNumber; candidateNumber++) {
            int decomposition = getDecomposition(candidateNumber);

            if (decomposition == targetNumber) {
                result = candidateNumber;
                return;
            }
        }
    }

    private static int getDecomposition(int number) {
        String temp = String.valueOf(number);
        String[] digitNumber = temp.split("");

        for (int i = 0; i < digitNumber.length; i++) {
            number += Integer.parseInt(digitNumber[i]);
        }

        return number;
    }

    private static void output() {
        System.out.println(result);
    }

}
