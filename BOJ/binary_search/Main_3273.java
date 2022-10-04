package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3273 {

    private static int lengthOfSequence;
    private static int[] sequence;
    private static int numberToMake;
    private static int result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        lengthOfSequence = Integer.parseInt(br.readLine());

        sequence = new int[lengthOfSequence];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lengthOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        numberToMake = Integer.parseInt(br.readLine());
    }

    private static void process() {
        Arrays.sort(sequence);

        for (int i = 0; i < lengthOfSequence; i++) {
            int leftOperand = sequence[i];
            int rightOperand = numberToMake - leftOperand;

            if (leftOperand < rightOperand) {
                binarySearch(0, lengthOfSequence - 1, rightOperand);
            }
        }
    }

    private static void binarySearch(int start, int end, int targetNumber) {
        int mid = (start + end) / 2;
        int currentNumber = sequence[mid];

        if (start > end) {
            return;
        }

        if (currentNumber == targetNumber) {
            result++;
            return;
        }

        if (currentNumber < targetNumber) {
            start = mid + 1;
        }

        if (currentNumber > targetNumber) {
            end = mid - 1;
        }

        binarySearch(start, end, targetNumber);
    }

    private static void output() {
        System.out.println(result);
    }

}
