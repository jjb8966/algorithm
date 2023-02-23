package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470 {

    private static int numberOfSolution;
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
        twoPointer();
    }

    private static void twoPointer() {
        int left = 0;
        int right = numberOfSolution - 1;
        int currentSum;
        int minSum = Integer.MAX_VALUE;

        Arrays.sort(solutions);

        while (left < right) {
            currentSum = solutions[left] + solutions[right];

            if (Math.abs(currentSum) < minSum) {
                minSum = Math.abs(currentSum);
                result[0] = solutions[left];
                result[1] = solutions[right];
            }

            if (currentSum == 0) {
                break;
            }

            if (currentSum < 0) {
                left++;
            }

            if (currentSum > 0) {
                right--;
            }
        }
    }

    private static void output() {
        System.out.println(result[0] + " " + result[1]);
    }

}