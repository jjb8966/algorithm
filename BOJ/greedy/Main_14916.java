package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14916 {

    private static int change;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        change = Integer.parseInt(br.readLine());
    }

    private static void process() {
        int remain = change;
        int countNumberTwo = 0;
        int countNumberFive = 0;
        int result;

        while (remain != 0) {
            if (remain % 5 == 0) {
                countNumberFive = remain / 5;
                break;
            } else {
                remain -= 2;
                countNumberTwo++;
            }

            if (remain < 0) {
                System.out.println("-1");
                return;
            }
        }

        result = countNumberTwo + countNumberFive;

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
