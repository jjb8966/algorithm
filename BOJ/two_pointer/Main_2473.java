package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473 {

    private static int numberOfSolutions;
    private static long minimumSum = Long.MAX_VALUE;
    private static int[] solutions;
    private static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfSolutions = Integer.parseInt(br.readLine());

        solutions = new int[numberOfSolutions];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfSolutions; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        Arrays.sort(solutions);

        for (int index = 0; index < numberOfSolutions; index++) {
            int target = solutions[index];

            updateResult(target, index + 1);
        }
    }

    private static void updateResult(int target, int leftIndex) {
        int left = leftIndex;
        int right = numberOfSolutions - 1;

        while (left < right) {
            long sumLeftRight = (long) solutions[left] + solutions[right];
            long currentSum = target + sumLeftRight;

            if (Math.abs(currentSum) < minimumSum) {
                minimumSum = Math.abs(currentSum);

                result[0] = target;
                result[1] = solutions[left];
                result[2] = solutions[right];
            }

            if (sumLeftRight == -target) {
                return;
            }

            if (sumLeftRight < -target) {
                left++;
            }

            if (sumLeftRight > -target) {
                right--;
            }
        }
    }

    private static void output() {
        for (int i = 0; i < 3; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
