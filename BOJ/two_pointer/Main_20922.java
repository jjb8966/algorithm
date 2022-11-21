package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20922 {

    private static int lengthOfSequence;
    private static int numberOfDuplicate;
    private static int[] sequence;
    private static int[] used = new int[100_001];
    private static int maxLength;

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
        numberOfDuplicate = Integer.parseInt(st.nextToken());

        sequence = new int[lengthOfSequence];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lengthOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int left = 0;
        int right = 0;

        while (left < lengthOfSequence && right < lengthOfSequence) {
            while (right < lengthOfSequence && used[sequence[right]] < numberOfDuplicate) {
                used[sequence[right]]++;
                right++;
            }

            int length = right - left;

            if (length > maxLength) {
                maxLength = length;
            }

            used[sequence[left]]--;
            left++;
        }
    }

    private static void output() {
        System.out.println(maxLength);
    }
}
