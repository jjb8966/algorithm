package dynamic_programming;

import java.io.*;

public class Main_11726 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n + 1];

        // process
        result[1] = 1;

        if (n > 1) {
            result[2] = 2;
        }

        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
            result[i] %= 10007;
        }

        // output
        System.out.println(result[n]);
    }
}