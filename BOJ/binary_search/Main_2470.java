package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470 {

    private static int numberOfSolution;
    private static int[] solutions;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfSolution = Integer.parseInt(br.readLine());

        solutions = new int[numberOfSolution];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < solutions.length; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);
    }

    private static int binarySearch(int left, int right, int standardNumber) {
        int result = right + 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (solutions[mid] >= standardNumber) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static void process() {
        int bestSum = Integer.MAX_VALUE;
        int[] resultSolutions = new int[2];

        for (int left = 0; left < numberOfSolution - 1; left++) {
            int candidate = binarySearch(left + 1, numberOfSolution - 1, -solutions[left]);

            // left < candidate 또는 candidate-1 <= N-1
            if (left < candidate - 1 && Math.abs(solutions[left] + solutions[candidate - 1]) < bestSum) {
                bestSum = Math.abs(solutions[left] + solutions[candidate - 1]);
                resultSolutions[0] = solutions[left];
                resultSolutions[1] = solutions[candidate - 1];
            }

            if (candidate < numberOfSolution && Math.abs(solutions[left] + solutions[candidate]) < bestSum) {
                bestSum = Math.abs(solutions[left] + solutions[candidate]);
                resultSolutions[0] = solutions[left];
                resultSolutions[1] = solutions[candidate];
            }
        }

        System.out.print(resultSolutions[0] + " " + resultSolutions[1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}