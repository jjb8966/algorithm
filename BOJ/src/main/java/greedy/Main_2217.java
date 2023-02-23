package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main_2217 {

    static int numberOfLope;
    static int result;
    static Integer[] lopes;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfLope = Integer.parseInt(br.readLine());

        lopes = new Integer[numberOfLope];

        for (int i = 0; i < numberOfLope; i++) {
            lopes[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void process() {
        result = Integer.MIN_VALUE;
        Arrays.sort(lopes, Comparator.reverseOrder());

        for (int index = 0; index < lopes.length; index++) {
            int countLope = index + 1;

            result = Math.max(result, lopes[index] * countLope);
        }
    }

    private static void output() {
        System.out.println(result);
    }

}