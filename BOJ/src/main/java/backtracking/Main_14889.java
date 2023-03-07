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
            int sumStart = 0;
            int sumLink = 0;

            for (int m1 = 0; m1 < numberOfPeople; m1++) {
                for (int m2 = 0; m2 < numberOfPeople; m2++) {
                    if (m1 == m2) {
                        continue;
                    }

                    if (isTeamStart[m1] && isTeamStart[m2]) {
                        sumStart += stats[m1][m2];
                    }

                    if (!isTeamStart[m1] && !isTeamStart[m2]) {
                        sumLink += stats[m1][m2];
                    }
                }
            }

            min = Math.min(min, Math.abs(sumStart - sumLink));

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