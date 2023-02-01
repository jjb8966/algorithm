package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11047 {

    static int numberOfCoin;
    static int targetPrice;
    static int result;
    static Integer[] coins;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfCoin = Integer.parseInt(st.nextToken());
        targetPrice = Integer.parseInt(st.nextToken());

        coins = new Integer[numberOfCoin];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void process() {
        int count;
        Arrays.sort(coins, Comparator.reverseOrder());

        for (int index = 0; index < coins.length; index++) {
            if (targetPrice < coins[index]) {
                continue;
            }

            count = targetPrice / coins[index];

            result += count;
            targetPrice -= count * coins[index];
        }
    }

    private static void output() {
        System.out.println(result);
    }

}