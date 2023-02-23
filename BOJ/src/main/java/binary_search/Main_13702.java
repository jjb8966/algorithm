package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13702 {

    private static int numberOfKettles;
    private static int numberOfPeople;
    private static long[] drinks;
    private static long maxDistributeAmount;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfKettles = Integer.parseInt(st.nextToken());
        numberOfPeople = Integer.parseInt(st.nextToken());

        drinks = new long[numberOfKettles];

        for (int i = 0; i < numberOfKettles; i++) {
            drinks[i] = Long.parseLong(br.readLine());
        }

    }

    private static void process() {
        binarySearch(0, Long.MAX_VALUE);
    }

    private static void binarySearch(long minAmount, long maxAmount) {
        long currentAmount = (minAmount + maxAmount) / 2;
        long numberOfCup = 0;

        if (minAmount > maxAmount) {
            return;
        }

        if (currentAmount == 0) {
            minAmount = currentAmount + 1;
            binarySearch(minAmount, maxAmount);

            return;
        }

        for (int kettle = 0; kettle < numberOfKettles; kettle++) {
            numberOfCup += drinks[kettle] / currentAmount;
        }

        if (numberOfCup >= numberOfPeople) {
            maxDistributeAmount = currentAmount;
            minAmount = currentAmount + 1;
        }

        if (numberOfCup < numberOfPeople) {
            maxAmount = currentAmount - 1;
        }

        binarySearch(minAmount, maxAmount);
    }

    private static void output() {
        System.out.println(maxDistributeAmount);
    }

}
