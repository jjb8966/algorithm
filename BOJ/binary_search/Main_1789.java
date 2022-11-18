package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789 {

    private static long targetNumber;
    private static long result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        targetNumber = Long.parseLong(br.readLine());
    }

    private static void process() {
        binarySearch(1L, targetNumber);
    }

    private static void binarySearch(long minCount, long maxCount) {
        long currentCount = (minCount + maxCount) / 2;

        if (minCount > maxCount) {
            return;
        }

        if (isPossible(currentCount)) {
            result = currentCount;
            minCount = currentCount + 1;
        } else {
            maxCount = currentCount - 1;
        }

        binarySearch(minCount, maxCount);
    }

    private static boolean isPossible(long currentCount) {
        long sum = 0;

        for (long i = 1; i <= currentCount; i++) {
            sum += i;
        }

        if (targetNumber >= sum) {
            return true;
        }

        return false;
    }

    private static void output() {
        System.out.println(result);
    }

}
