package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470 {

    private static int numberOfSolution;
    private static int bestSum = Integer.MAX_VALUE;
    private static int[] solutions;
    private static int[] result = new int[2];

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

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

        for (int index = 0; index < numberOfSolution; index++) {
            int candidate = binarySearch(index + 1, -solutions[index]);

            updateResult(index, candidate - 1);
            updateResult(index, candidate);
        }

        Arrays.sort(result);
    }

    private static void updateResult(int index, int candidate) {
        if (index >= candidate) {
            return;
        }

        if (candidate >= numberOfSolution) {
            return;
        }

        if (Math.abs(solutions[index] + solutions[candidate]) < bestSum) {
            bestSum = Math.abs(solutions[index] + solutions[candidate]);
            result[0] = solutions[index];
            result[1] = solutions[candidate];
        }
    }

    private static int binarySearch(int start, int target) {
        int end = numberOfSolution - 1;
        int result = numberOfSolution;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (solutions[mid] >= target) {
                result = mid;
                end = mid - 1;
            }

            if (solutions[mid] < target) {
                start = mid + 1;
            }
        }

        return result;
    }

    private static void output() {
        System.out.println(result[0] + " " + result[1]);
    }

}