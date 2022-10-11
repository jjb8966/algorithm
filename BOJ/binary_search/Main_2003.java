package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2003 {

    private static int lengthOfSequence;
    private static int targetNumber;
    private static int[] sequence;
    private static int result;

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
        int right = 0;
        int sum = 0;

        for (int left = 0; left < lengthOfSequence; left++) {

            while (sum < targetNumber && right < lengthOfSequence) {
                sum += sequence[right];
                right++;
            }

            if (sum == targetNumber) {
                result++;
            }

            sum -= sequence[left];
        }
    }

    private static void output() {
        System.out.println(result);
    }

}
