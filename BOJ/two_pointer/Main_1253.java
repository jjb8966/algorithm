package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {

    private static int lengthOfSequence;
    private static int result;
    private static int[] sequence;

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
    }

    private static void process() {
        Arrays.sort(sequence);

        for (int index = 0; index < lengthOfSequence; index++) {
            if (isGoodNumber(index)) {
                result++;
            }
        }
    }

    private static boolean isGoodNumber(int index) {
        int target = sequence[index];
        int left = 0;
        int right = lengthOfSequence - 1;
        int sum;

        while (left < right) {
            if (left == index) {
                left++;
                continue;
            }

            if (right == index) {
                right--;
                continue;
            }

            sum = sequence[left] + sequence[right];

            if (sum < target) {
                left++;
            }

            if (sum > target) {
                right--;
            }

            if (sum == target) {
                return true;
            }
        }

        return false;
    }

    private static void output() {
        System.out.println(result);
    }

}