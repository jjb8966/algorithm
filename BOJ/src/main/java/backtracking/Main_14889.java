package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889 {

    public static void main(String[] args) throws IOException {
        // init
        int numberOfPeople = 0;
        int minimumGap = 0;
        int[][] stat;
        boolean[] isTeamStart;
        StringTokenizer st;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfPeople = Integer.parseInt(br.readLine());

        stat = new int[numberOfPeople][numberOfPeople];
        isTeamStart = new boolean[numberOfPeople];

        for (int y = 0; y < numberOfPeople; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < numberOfPeople; x++) {
                stat[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        // process
        minimumGap = backtracking(0, 0, numberOfPeople, stat, isTeamStart);

        // output
        System.out.println(minimumGap);
    }

    private static int backtracking(int memberIndex,
                                    int countOfTeamStart,
                                    int numberOfPeople,
                                    int[][] stat,
                                    boolean[] isTeamStart) {
        int minimumGap = Integer.MAX_VALUE;

        if (countOfTeamStart == numberOfPeople / 2) {
            return calculateGap(numberOfPeople, stat, isTeamStart);
        }

        for (int index = memberIndex; index < numberOfPeople; index++) {
            isTeamStart[index] = true;

            int gap = backtracking(index + 1, countOfTeamStart + 1, numberOfPeople, stat, isTeamStart);
            minimumGap = Math.min(minimumGap, gap);

            isTeamStart[index] = false;
        }

        return minimumGap;
    }

    private static int calculateGap(int numberOfPeople,
                                    int[][] stat,
                                    boolean[] isTeamStart) {
        int sumOfStart = 0;
        int sumOfLink = 0;

        for (int y = 0; y < numberOfPeople; y++) {
            for (int x = 0; x < numberOfPeople; x++) {
                if (isTeamStart[x] && isTeamStart[y]) {
                    sumOfStart += stat[x][y];
                }

                if (!isTeamStart[x] && !isTeamStart[y]) {
                    sumOfLink += stat[x][y];
                }
            }
        }

        return Math.abs(sumOfStart - sumOfLink);
    }
}
