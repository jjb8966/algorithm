package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2512 {

    static int numberOfRegions;
    static int totalBudget;
    static int maxBudget;
    static int[] budgets;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfRegions = Integer.parseInt(br.readLine());

        budgets = new int[numberOfRegions];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfRegions; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }

        totalBudget = Integer.parseInt(br.readLine());
    }

    private static void process() {
        int max = Arrays.stream(budgets)
                .max()
                .getAsInt();

        binarySearch(0, max);
    }


    private static void binarySearch(int min, int max) {
        while (min <= max) {
            int mid = (min + max) / 2;

            if (isPossible(mid)) {
                maxBudget = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
    }

    private static boolean isPossible(int budget) {
        int sum = 0;

        for (int region = 0; region < numberOfRegions; region++) {
            if (budgets[region] > budget) {
                sum += budget;
            } else {
                sum += budgets[region];
            }
        }

        return sum <= totalBudget;
    }

    private static void output() {
        System.out.println(maxBudget);
    }

}