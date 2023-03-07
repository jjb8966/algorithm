package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_1758 {

    static int numberOfPeople;
    static long result;
    static Integer[] tips;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfPeople = Integer.parseInt(br.readLine());

        tips = new Integer[numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void process() {
        Arrays.sort(tips, Collections.reverseOrder());

        for (int order = 0; order < numberOfPeople; order++) {
            int tip = tips[order] - order;

            if (tip <= 0) {
                continue;
            }

            result += tip;
        }
    }

    private static void output() {
        System.out.println(result);
    }

}