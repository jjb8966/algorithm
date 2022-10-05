package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2512 {

    private static int numberOfRegion;
    private static int[] budgetRequests;
    private static int totalBudget;
    private static int upperLimitBudget;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfRegion = Integer.parseInt(br.readLine());

        budgetRequests = new int[numberOfRegion];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfRegion; i++) {
            budgetRequests[i] = Integer.parseInt(st.nextToken());
        }

        totalBudget = Integer.parseInt(br.readLine());
    }

    private static void process() {
        int maxBudget = Arrays.stream(budgetRequests).max().getAsInt();

        binarySearch(1, maxBudget);
    }

    private static void binarySearch(int minBudget, int maxBudget) {
        int currentBudget = (minBudget + maxBudget) / 2;
        int sumOfBudget = 0;

        if (minBudget > maxBudget) {
            return;
        }

        for (int region = 0; region < numberOfRegion; region++) {
            if (budgetRequests[region] <= currentBudget) {
                sumOfBudget += budgetRequests[region];
            } else {
                sumOfBudget += currentBudget;
            }
        }

        if (sumOfBudget <= totalBudget) {
            upperLimitBudget = currentBudget;
            minBudget = currentBudget + 1;
        }

        if (sumOfBudget > totalBudget) {
            maxBudget = currentBudget - 1;
        }

        binarySearch(minBudget, maxBudget);
    }

    private static void output() {
        System.out.println(upperLimitBudget);
    }

}
