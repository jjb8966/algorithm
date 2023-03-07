package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14916 {

    static int money;
    static int result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        money = Integer.parseInt(br.readLine());
    }

    private static void process() {
        while (money >= 0) {
            if (money % 5 == 0) {
                result += money / 5;
                return;
            }

            money -= 2;
            result++;
        }

        result = -1;
    }

    private static void output() {
        System.out.println(result);
    }

}