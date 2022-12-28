package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13144 {

    private static int lengthOfSequence;
    private static int[] sequence;
    private static long result;

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
        twoPointer();
    }

    private static void twoPointer() {
        int right = 0;
        boolean[] used = new boolean[100_000 + 1];

        for (int left = 0; left < lengthOfSequence; left++) {
            while (right < lengthOfSequence && !used[sequence[right]]) {
                used[sequence[right]] = true;
                right++;
            }

            result += right - left;

            used[sequence[left]] = false;
        }
    }

    private static void output() {
        System.out.println(result);
    }

}