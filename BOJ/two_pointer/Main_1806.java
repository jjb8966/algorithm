package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806 {

    private static int lengthOfSequence;
    private static int targetNumber;
    private static int minSize = Integer.MAX_VALUE;
    private static int[] sequence;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        lengthOfSequence = Integer.parseInt(st.nextToken());
        targetNumber = Integer.parseInt(st.nextToken());

        sequence = new int[lengthOfSequence];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lengthOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        twoPointer();
    }

    private static void twoPointer() {
        int right = 0;
        int currentSum = 0;
        int currentSize = 0;

        for (int left = 0; left < lengthOfSequence; left++) {
            while (right < lengthOfSequence && currentSum < targetNumber) {
                currentSum += sequence[right];
                right++;
            }

            if (currentSum >= targetNumber) {
                currentSize = right - left;
            }

            if (currentSize < minSize) {
                minSize = currentSize;
            }

            currentSum -= sequence[left];
        }
    }

    private static void output() {
        System.out.println(minSize);
    }

}