package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789 {

    static long sumOfNumber;
    static long result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sumOfNumber = Long.parseLong(br.readLine());
    }

    private static void process() {
//        binarySearch(1L, sumOfNumber);
        binarySearch2(1L, sumOfNumber);
    }

    private static void binarySearch(long min, long max) {
        if (min > max) {
            return;
        }

        long mid = (min + max) / 2;

        if (isPossible(mid)) {
            result = mid;
            min = mid + 1;
        } else {
            max = mid - 1;
        }

        binarySearch(min, max);
    }

    private static void binarySearch2(long min, long max) {
        while (min <= max) {
            long mid = (min + max) / 2;

            if (isPossible(mid)) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
    }

    private static boolean isPossible(long count) {
        long sum = 0;

        for (long number = 1; number <= count; number++) {
            sum += number;
        }

        return sum <= sumOfNumber;
    }

    private static void output() {
        System.out.println(result);
    }

}