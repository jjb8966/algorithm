package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {

    private static int numberOfSequence;
    private static int numberOfFindNumber;
    private static int[] sequence;
    private static int[] findNumbers;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfSequence = Integer.parseInt(br.readLine());

        sequence = new int[numberOfSequence];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        numberOfFindNumber = Integer.parseInt(br.readLine());

        findNumbers = new int[numberOfFindNumber];
        result = new int[numberOfFindNumber];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfFindNumber; i++) {
            findNumbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        Arrays.sort(sequence);

        for (int targetIndex = 0; targetIndex < numberOfFindNumber; targetIndex++) {
            binarySearch(0, numberOfSequence - 1, targetIndex);
        }
    }

    private static void binarySearch(int start, int end, int targetIndex) {
        int mid = (start + end) / 2;
        int currentNumber = sequence[mid];
        int targetNumber = findNumbers[targetIndex];

        if (start > end) {
            return;
        }

        if (currentNumber == targetNumber) {
            result[targetIndex] = 1;

            return;
        }

        if (currentNumber < targetNumber) {
            start = mid + 1;
        }

        if (currentNumber > targetNumber) {
            end = mid - 1;
        }

        binarySearch(start, end, targetIndex);
    }

    private static void output() {
        Arrays.stream(result).forEach(System.out::println);
    }

}
