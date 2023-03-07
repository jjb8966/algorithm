package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182 {

    static int lengthOfSequence;
    static int targetNumber;
    static int result;
    static int[] sequence;

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
        backtracking(0, 0);

        if (targetNumber == 0) {
            result--;
        }
    }

    private static void backtracking(int index, int sum) {
        if (index == lengthOfSequence) {
            if (sum == targetNumber) {
                result++;
            }

            return;
        }

        backtracking(index + 1, sum);
        backtracking(index + 1, sum + sequence[index]);
    }

    private static void output() {
        System.out.println(result);
    }

}