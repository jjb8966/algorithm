package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6236 {

    private static int numberOfDay;
    private static int numberOfWithdraw;
    private static int[] costOfOneDay;
    private static int minWithdrawMoney;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfDay = Integer.parseInt(st.nextToken());
        numberOfWithdraw = Integer.parseInt(st.nextToken());

        costOfOneDay = new int[numberOfDay];

        for (int i = 0; i < numberOfDay; i++) {
            costOfOneDay[i] = Integer.parseInt(br.readLine());
        }

    }

    private static void process() {
        int sum = Arrays.stream(costOfOneDay).sum();
        int max = Arrays.stream(costOfOneDay).max().getAsInt();

        binarySearch(0, sum);

        if (minWithdrawMoney < max) {
            minWithdrawMoney = max;
        }
    }

    private static void binarySearch(int minMoney, int maxMoney) {
        int currentMoney = (minMoney + maxMoney) / 2;
        int restMoney = currentMoney;
        int countWithdraw = 1;

        if (minMoney > maxMoney) {
            return;
        }

        for (int day = 0; day < numberOfDay; day++) {
            if (costOfOneDay[day] > restMoney) {
                restMoney = currentMoney;
                countWithdraw++;
            }

            restMoney -= costOfOneDay[day];
        }

        if (countWithdraw <= numberOfWithdraw) {
            minWithdrawMoney = currentMoney;
            maxMoney = currentMoney - 1;
        }

        if (countWithdraw > numberOfWithdraw) {
            minMoney = currentMoney + 1;
        }

        binarySearch(minMoney, maxMoney);
    }

    private static void output() {
        System.out.println(minWithdrawMoney);
    }

}
