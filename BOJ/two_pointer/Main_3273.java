package two_pointer;

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
        int left = 0;
        int right = lengthOfSequence - 1;

        Arrays.sort(sequence);

        while (left < right) {
            if (sequence[left] + sequence[right] == numberToMake) {
                result++;
            }

            if (sequence[left] + sequence[right] < numberToMake) {
                left++;
            } else {
                right--;
            }
        }
    }

    private static void output() {
        System.out.println(result);
    }
}