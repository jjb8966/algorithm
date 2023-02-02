package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889 {

    static int numberOfPeople;
    static int min = Integer.MAX_VALUE;
    static int[][] stats;
    static boolean[] isTeamA;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfPeople = Integer.parseInt(br.readLine());

        stats = new int[numberOfPeople + 1][numberOfPeople + 1];
        isTeamA = new boolean[numberOfPeople + 1];

        for (int y = 1; y <= numberOfPeople; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 1; x <= numberOfPeople; x++) {
                stats[x][y] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
//        dfs(1,0);
        dfs2(1, 0);
    }

    private static void dfs(int memberIndex, int countOfTeamA) {
        if (countOfTeamA == (numberOfPeople / 2)) {
            int teamAStats = 0;
            int teamBStats = 0;

            for (int m1 = 1; m1 <= numberOfPeople; m1++) {
                for (int m2 = 1; m2 <= numberOfPeople; m2++) {
                    if (m1 == m2) {
                        continue;
                    }

                    if (isTeamA[m1] && isTeamA[m2]) {
                        teamAStats += stats[m1][m2];
                    }

                    if (!isTeamA[m1] && !isTeamA[m2]) {
                        teamBStats += stats[m1][m2];
                    }
                }
            }

            min = Math.min(min, Math.abs(teamAStats - teamBStats));

            return;
        }

        if (memberIndex == numberOfPeople) {
            return;
        }

        dfs(memberIndex + 1, countOfTeamA);

        isTeamA[memberIndex] = true;
        dfs(memberIndex + 1, countOfTeamA + 1);
        isTeamA[memberIndex] = false;
    }

    private static void dfs2(int memberIndex, int count) {
        if (count == (numberOfPeople / 2)) {
            int teamAStats = 0;
            int teamBStats = 0;

            for (int m1 = 1; m1 <= numberOfPeople; m1++) {
                for (int m2 = 1; m2 <= numberOfPeople; m2++) {
                    if (m1 == m2) {
                        continue;
                    }

                    if (isTeamA[m1] && isTeamA[m2]) {
                        teamAStats += stats[m1][m2];
                    }

                    if (!isTeamA[m1] && !isTeamA[m2]) {
                        teamBStats += stats[m1][m2];
                    }
                }
            }

            min = Math.min(min, Math.abs(teamAStats - teamBStats));

            return;
        }

        for (int index = memberIndex; index <= numberOfPeople; index++) {
            if (isTeamA[index]) {
                continue;
            }

            isTeamA[index] = true;
            dfs2(index + 1, count + 1);
            isTeamA[index] = false;
        }
    }

    private static void output() {
        System.out.println(min);
    }

}