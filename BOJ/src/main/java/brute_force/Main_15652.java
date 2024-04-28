package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652 {

    public static void main(String[] args) throws IOException {
        // init
        int N;
        int M;
        int[] result;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        // process
        StringBuilder sb = new StringBuilder();
        bruteForce(N, M, result, sb, 0);

        // output
        System.out.println(sb);
    }

    static void bruteForce(int N, int M, int[] result, StringBuilder sb, int digit) {
        if (digit == M) {
            for (int number : result) {
                sb.append(number).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int candidate = 1; candidate <= N; candidate++) {
            if (result[digit] > candidate) {
                continue;
            }

            result[digit] = candidate;
            bruteForce(N, M, result, sb, digit + 1);
        }
    }

}