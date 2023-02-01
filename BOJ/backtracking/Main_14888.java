package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    private static void dfs(int nextIndex, int sum) {
        if (nextIndex == lengthOfSequence) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        for (int op = 0; op < 4; op++) {
            if (operations[op] <= 0) {
                continue;
            }

            operations[op]--;

            if (op == 0) {
                dfs(nextIndex + 1, sum + sequence[nextIndex]);
            }

            if (op == 1) {
                dfs(nextIndex + 1, sum - sequence[nextIndex]);
            }

            if (op == 2) {
                dfs(nextIndex + 1, sum * sequence[nextIndex]);
            }

            if (op == 3) {
                dfs(nextIndex + 1, sum / sequence[nextIndex]);
            }

            operations[op]++;
        }
    }

    private static void output() {
        System.out.println(max);
        System.out.println(min);
    }

}