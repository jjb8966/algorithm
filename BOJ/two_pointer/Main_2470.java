package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Scanner를 쓰면 시간초과가 나고 BufferedReader를 쓰면 정답이되는 문제... 웬만하면 BufferedReader 쓰는게 좋을듯
//static Scanner sc = new Scanner(System.in);
public class Main_2470 {

    private static int numberOfSolution;
    private static int[] solutions;
    private static int[] result = new int[2];

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
        int left = 0;
        int right = numberOfSolution - 1;
        int currentSum = 0;
        int resultSum = Integer.MAX_VALUE;

        Arrays.sort(solutions);

        while (left < right) {
            currentSum = solutions[left] + solutions[right];

            if (resultSum > Math.abs(currentSum)) {
                resultSum = Math.abs(currentSum);
                result[0] = solutions[left];
                result[1] = solutions[right];
            }

            if (currentSum < 0) {
                left++;
                continue;
            }

            if (currentSum > 0) {
                right--;
                continue;
            }

            if (currentSum == 0) {
                result[0] = solutions[left];
                result[1] = solutions[right];
                break;
            }
        }
    }

    private static void output() {
        System.out.println(result[0] + " " + result[1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
