package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sumOfNumber = Long.parseLong(br.readLine());

        // process
        long result = binarySearch(1L, sumOfNumber);

        // output
        System.out.println(result);
    }

    private static long binarySearch(long min, long sumOfNumber) {
        long result = 0L;
        long max = sumOfNumber;

        while (min <= max) {
            long mid = (min + max) / 2;

            if (isPossible(mid, sumOfNumber)) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return result;
    }

    private static boolean isPossible(long mid, long sumOfNumber) {
        long sum = (1 + mid) * mid / 2;

        return sum <= sumOfNumber;
    }
}