package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789 {

    static long targetNumber;
    static long result;

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
        binarySearch(1, targetNumber);
    }

    private static void binarySearch(long min, long max) {
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

        return sum <= targetNumber;

        // 시간 초과
        // return LongStream.range(1, count + 1).sum() <= targetNumber;
    }

    private static void output() {
        System.out.println(result);
    }

}