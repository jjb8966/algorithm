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
    static int[] numberOfOperation = new int[4];

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
            numberOfOperation[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        backtracking(1, sequence[0]);
//        backtracking2(0, new int[lengthOfSequence - 1]);
    }

    private static void backtracking(int index, int sum) {
        if (index == lengthOfSequence) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);

            return;
        }

        for (int op = 0; op < 4; op++) {
            if (numberOfOperation[op] <= 0) {
                continue;
            }

            numberOfOperation[op]--;

            if (op == 0) {
                backtracking(index + 1, sum + sequence[index]);
            }

            if (op == 1) {
                backtracking(index + 1, sum - sequence[index]);
            }

            if (op == 2) {
                backtracking(index + 1, sum * sequence[index]);
            }

            if (op == 3) {
                backtracking(index + 1, sum / sequence[index]);
            }

            numberOfOperation[op]++;
        }
    }

    private static void backtracking2(int index, int[] opCandidate) {
        if (index == lengthOfSequence - 1) {
            int sum = sequence[0];

            for (int i = 0; i < opCandidate.length; i++) {
                if (opCandidate[i] == 0) {
                    sum += sequence[i + 1];
                }

                if (opCandidate[i] == 1) {
                    sum -= sequence[i + 1];
                }

                if (opCandidate[i] == 2) {
                    sum *= sequence[i + 1];
                }

                if (opCandidate[i] == 3) {
                    sum /= sequence[i + 1];
                }
            }

            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        for (int op = 0; op < 4; op++) {
            if (numberOfOperation[op] > 0) {
                numberOfOperation[op]--;
                opCandidate[index] = op;

                backtracking2(index + 1, opCandidate);

                opCandidate[index] = 0;
                numberOfOperation[op]++;
            }
        }
    }

    private static void output() {
        System.out.println(max);
        System.out.println(min);
    }

}