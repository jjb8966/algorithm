package backtracking;

import java.io.*;
import java.util.*;

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
        dfs(0, 0);

        // 아무것도 더하지 않은 공집합 제외
        if (targetNumber == 0) {
            result--;
        }
    }

    private static void dfs(int index, int sum) {
        if (index == lengthOfSequence) {
            if (sum == targetNumber) {
                result++;
            }

            return;
        }

        dfs(index + 1, sum);
        dfs(index + 1, sum + sequence[index]);
    }

    private static void output() {
        System.out.println(result);
    }

}