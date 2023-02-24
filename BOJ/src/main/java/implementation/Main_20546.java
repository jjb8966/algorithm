package implementation;

import java.io.*;
import java.util.*;

public class Main_20546 {

    static int totalMoney;
    static int[] stockPrices = new int[14];
    static int[] stock = new int[2];
    static int[] money = new int[2];
    static int[] asset = new int[2];
    static String result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        totalMoney = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stockPrices[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        calculateBNP();
        calculateTiming();

        if (asset[0] > asset[1]) {
            result = "BNP";
        }

        if (asset[0] < asset[1]) {
            result = "TIMING";
        }

        if (asset[0] == asset[1]) {
            result = "SAMESAME";
        }
    }

    private static void calculateBNP() {
        money[0] = totalMoney;

        for (int i = 0; i < 14; i++) {
            if (stockPrices[i] <= money[0]) {
                int numberOfPurchase = money[0] / stockPrices[i];

                stock[0] += numberOfPurchase;
                money[0] -= numberOfPurchase * stockPrices[i];

                break;
            }
        }

        asset[0] = (stock[0] * stockPrices[13]) + money[0];
//        System.out.println("stock[0] = " + stock[0]);
//        System.out.println("money[0] = " + money[0]);
//        System.out.println("asset[0] = " + asset[0]);
    }

    private static void calculateTiming() {
        int up = 0;
        int down = 0;
        int previousPrice = stockPrices[0];
        money[1] = totalMoney;

        for (int day = 1; day < 14; day++) {
            int currentPrice = stockPrices[day];

            if (currentPrice == previousPrice) {
                up = 0;
                down = 0;

                continue;
            }

            if (currentPrice > previousPrice) {
                down = 0;
                up++;
            }

            if (currentPrice < previousPrice) {
                up = 0;
                down++;
            }

            previousPrice = currentPrice;

            if (down >= 3 && currentPrice <= money[1]) {
//                System.out.println("buy " + (day + 1));
                buy(currentPrice);
            }

            if (up >= 3 && stock[1] > 0) {
//                System.out.println("sell " + (day + 1));
                sell(currentPrice);
            }
        }

        asset[1] = (stock[1] * stockPrices[13]) + money[1];
//        System.out.println("stock[1] = " + stock[1]);
//        System.out.println("money[1] = " + money[1]);
//        System.out.println("asset[1] = " + asset[1]);
    }

    private static void buy(int stockPrice) {
        int numberOfPurchase = money[1] / stockPrice;

        stock[1] += numberOfPurchase;
        money[1] -= numberOfPurchase * stockPrice;
    }

    private static void sell(int stockPrice) {
        money[1] += stock[1] * stockPrice;
        stock[1] = 0;
    }

    private static void output() {
        System.out.println(result);
    }

}