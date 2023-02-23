package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1300 {

    private static long n;
    private static long k;
    private static long result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
    }

    private static void process() {
        binarySearch(1, n * n);
    }

    private static void binarySearch(long start, long end) {
        long mid = (start + end) / 2;

        if (start > end) {
            return;
        }

        if (isRight(mid)) {
            result = mid;
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        binarySearch(start, end);
    }

    private static boolean isRight(long mid) {
        long count = 0;

        for (int i = 1; i <= n; i++) {
            long temp = mid / i;

            if (temp > n) {
                temp = n;
            }

            count += temp;
        }

        return count >= k;
    }

    private static void output() {
        System.out.println(result);
    }
}
