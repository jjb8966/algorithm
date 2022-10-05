package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1654 {

    private static int numberOfLanCable;
    private static int numberOfNeededLanCable;
    private static long maxLengthOfLabCable;
    private static long[] lanCables;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfLanCable = Integer.parseInt(st.nextToken());
        numberOfNeededLanCable = Integer.parseInt(st.nextToken());

        lanCables = new long[numberOfLanCable];

        for (int i = 0; i < numberOfLanCable; i++) {
            lanCables[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void process() {
        long maxlength = Arrays.stream(lanCables).max().getAsLong();

        binarySearch(1, maxlength);
    }

    private static void binarySearch(long minLength, long maxLength) {
        long currentLength = (minLength + maxLength) / 2;
        long currentCount = 0;

        if (minLength > maxLength) {
            return;
        }

        for (int i = 0; i < numberOfLanCable; i++) {
            currentCount += lanCables[i] / currentLength;
        }

        if (currentCount >= numberOfNeededLanCable) {
            maxLengthOfLabCable = currentLength;
            minLength = currentLength + 1;
        }

        if (currentCount < numberOfNeededLanCable) {
            maxLength = currentLength - 1;
        }

        binarySearch(minLength, maxLength);
    }

    private static void output() {
        System.out.println(maxLengthOfLabCable);
    }

}
