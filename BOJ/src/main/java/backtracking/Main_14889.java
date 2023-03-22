package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889 {

    static int numberOfPeople;
    static int min = Integer.MAX_VALUE;
    static int[][] stats;
    static boolean[] isTeamStart;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfPeople = Integer.parseInt(br.readLine());

        stats = new int[numberOfPeople][numberOfPeople];
        isTeamStart = new boolean[numberOfPeople];

        for (int y = 0; y < numberOfPeople; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < numberOfPeople; x++) {
                stats[x][y] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        backtracking(0, 0);
    }

    private static void backtracking(int member, int count) {
        if (count == numberOfPeople / 2) {
            int sumOfStart = 0;
            int sumOfLink = 0;

            for (int y = 0; y < numberOfPeople; y++) {
                for (int x = 0; x < numberOfPeople; x++) {
                    if (x == y) {
                        continue;
                    }

                    if (isTeamStart[x] && isTeamStart[y]) {
                        sumOfStart += stats[x][y];
                    }

                    if (!isTeamStart[x] && !isTeamStart[y]) {
                        sumOfLink += stats[x][y];
                    }
                }
            }

            int gap = Math.abs(sumOfStart - sumOfLink);
            min = Math.min(min, gap);

            return;
        }

        if (member == numberOfPeople) {
            return;
        }

        backtracking(member + 1, count);

        isTeamStart[member] = true;
        backtracking(member + 1, count + 1);
        isTeamStart[member] = false;
    }

    private static void output() {
        System.out.println(min);
    }

}