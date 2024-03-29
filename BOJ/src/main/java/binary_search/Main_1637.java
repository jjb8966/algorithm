package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1637 {

    private static int n;
    private static long resultNumber;
    private static long resultCount;
    private static int[] startNumber;
    private static int[] multiple;
    private static int[] maxNumber;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        startNumber = new int[n];
        multiple = new int[n];
        maxNumber = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            startNumber[i] = Integer.parseInt(st.nextToken());
            maxNumber[i] = Integer.parseInt(st.nextToken());
            multiple[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        binarySearch(1L, Integer.MAX_VALUE);
    }

    private static void binarySearch(long minNumber, long maxNumber) {
        long currentNumber = (minNumber + maxNumber) / 2;

        if (minNumber > maxNumber) {
            return;
        }

        long sumCount = sumCount(currentNumber);

        if (isOdd(sumCount)) {
            resultNumber = currentNumber;
            resultCount = sumCount - sumCount(currentNumber - 1);
            maxNumber = currentNumber - 1;
        } else {
            minNumber = currentNumber + 1;
        }

        binarySearch(minNumber, maxNumber);
    }

    private static boolean isOdd(long sumCount) {
        return sumCount % 2 != 0;
    }

    private static long sumCount(long currentNumber) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += getCount(i, currentNumber);
        }

        return sum;
    }

    private static int getCount(int i, long currentNumber) {
        if (currentNumber < startNumber[i]) {
            return 0;
        }

        if (currentNumber >= maxNumber[i]) {
            return (maxNumber[i] - startNumber[i]) / multiple[i] + 1;
        }

        return (int) ((currentNumber - startNumber[i]) / multiple[i] + 1);
    }

    private static void output() {
        if (resultNumber == 0 && resultCount == 0) {
            System.out.println("NOTHING");

            return;
        }

        System.out.println(resultNumber + " " + resultCount);
    }

}
