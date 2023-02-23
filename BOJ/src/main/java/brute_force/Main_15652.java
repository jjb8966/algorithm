package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652 {

    private static int N;
    private static int M;
    private static int[] result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M + 1];
    }

    private static void process() {
        bruteForce(1);
    }

    private static void bruteForce(int digit) {
        if (digit == M + 1) {
            for (int index = 1; index <= M; index++) {
                sb.append(result[index]).append(" ");
            }

            sb.append('\n');

            return;
        }

        for (int candidate = 1; candidate <= N; candidate++) {
            if (result[digit - 1] > candidate) {
                continue;
            }

            result[digit] = candidate;

            bruteForce(digit + 1);
        }

    }

    private static void output() {
        System.out.println(sb);
    }

}