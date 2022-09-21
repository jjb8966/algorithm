package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//중복x, 순서x -> O(N C M) = N! / M!(N-M)!
public class Main_15650 {

    private static StringBuilder sb = new StringBuilder();
    private static int maxNumber;
    private static int maxDigit;
    private static int[] result;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        maxNumber = Integer.parseInt(st.nextToken());
        maxDigit = Integer.parseInt(st.nextToken());

        result = new int[maxDigit + 1];     // 1 ~ maxDigit
        used = new boolean[maxNumber + 1];
    }

    private static void process() {
        bruteForce(1);
    }

    private static void bruteForce(int digit) {
        if (digit == maxDigit + 1) {
            for (int i = 1; i <= maxDigit; i++) {
                sb.append(result[i]).append(" ");
            }

            sb.append("\n");
        } else {
            for (int currentNumber = 1; currentNumber <= maxNumber; currentNumber++) {
                if (used[currentNumber]) {
                    continue;
                }

                if (currentNumber < result[digit - 1]) {
                    continue;
                }

                result[digit] = currentNumber;
                used[currentNumber] = true;

                bruteForce(digit + 1);

                used[currentNumber] = false;
            }
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}
