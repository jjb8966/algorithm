package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470 {

    private static int numberOfSolution;
    private static int[] solutions;

    private static int[] resultSolutions = new int[2];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfSolution = Integer.parseInt(br.readLine());

        solutions = new int[numberOfSolution];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfSolution; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        Arrays.sort(solutions);

        int bestSum = Integer.MAX_VALUE;

        for (int left = 0; left < numberOfSolution - 1; left++) {
            int candidate = lowerBound(left + 1, -solutions[left]);

            bestSum = getBestSum(bestSum, left, candidate - 1);
            bestSum = getBestSum(bestSum, left, candidate);
        }
    }

    private static int getBestSum(int bestSum, int left, int candidate) {
        if (left < candidate && candidate < numberOfSolution) {
            int abs = Math.abs(solutions[left] + solutions[candidate]);

            if (abs < bestSum) {
                bestSum = abs;
                resultSolutions[0] = solutions[left];
                resultSolutions[1] = solutions[candidate];
            }
        }
        return bestSum;
    }

    private static int lowerBound(int start, int target) {
        int result = numberOfSolution;
        int end = numberOfSolution - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (solutions[mid] >= target) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private static void output() {
        System.out.println(resultSolutions[0] + " " + resultSolutions[1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
