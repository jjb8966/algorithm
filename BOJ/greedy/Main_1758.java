package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.sort(tips, Comparator.reverseOrder());

        for (int order = 0; order < tips.length; order++) {
            int money = tips[order] - order;

            if (money <= 0) {
                break;
            }

            result += money;
        }
    }

    private static void output() {
        System.out.println(result);
    }

}