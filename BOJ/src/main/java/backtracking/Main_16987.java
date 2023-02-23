package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16987 {

    static int numberOfEgg;
    static int max;
    static int[] durability;
    static int[] weight;
    static boolean[] broken;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfEgg = Integer.parseInt(br.readLine());

        durability = new int[numberOfEgg];
        weight = new int[numberOfEgg];
        broken = new boolean[numberOfEgg];

        for (int i = 0; i < numberOfEgg; i++) {
            st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        dfs(0, 0);
    }

    private static void dfs(int digit, int count) {
        if (digit == numberOfEgg) {
            max = Math.max(max, count);
            return;
        }

        // digit이 깨졌거나 digit 빼고 다 깨진 경우
        if (broken[digit] || (count == numberOfEgg - 1)) {
            dfs(digit + 1, count);
            return;
        }

        for (int index = 0; index < numberOfEgg; index++) {
            int currentCount = count;

            if (digit == index) {
                continue;
            }

            if (broken[index]) {
                continue;
            }

            durability[digit] -= weight[index];
            durability[index] -= weight[digit];

            if (durability[digit] <= 0) {
                broken[digit] = true;
                currentCount++;
            }

            if (durability[index] <= 0) {
                broken[index] = true;
                currentCount++;
            }

            dfs(digit + 1, currentCount);

            durability[digit] += weight[index];
            durability[index] += weight[digit];

            broken[digit] = false;
            broken[index] = false;
        }
    }

    private static void output() {
        System.out.println(max);
    }

}