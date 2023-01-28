package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14888 {

    static int lengthOfSequence;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] sequence;
    static int[] operations = new int[4];

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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        dfs(1, sequence[0]);
    }

    private static void dfs(int index, int sum) {
        if (index == lengthOfSequence) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operations[i] <= 0) {
                continue;
            }

            operations[i]--;

            if (i == 0) {
                dfs(index + 1, sum + sequence[index]);
            }

            if (i == 1) {
                dfs(index + 1, sum - sequence[index]);
            }

            if (i == 2) {
                dfs(index + 1, sum * sequence[index]);
            }

            if (i == 3) {
                dfs(index + 1, sum / sequence[index]);
            }

            operations[i]++;
        }
    }

    private static void output() {
        System.out.println(max);
        System.out.println(min);
    }

}