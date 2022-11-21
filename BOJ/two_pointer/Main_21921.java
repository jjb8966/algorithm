package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_21921 {

    private static int totalDays;
    private static int targetDays;
    private static int maxSum;
    private static int maxCount;
    private static int[] days;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        totalDays = Integer.parseInt(st.nextToken());
        targetDays = Integer.parseInt(st.nextToken());

        days = new int[totalDays];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalDays; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while (left < totalDays && right < totalDays) {
            while (right < totalDays && count < targetDays) {
                sum += days[right];
                right++;
                count++;
            }

            if (sum == maxSum) {
                maxCount++;
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxCount = 1;
            }

            sum -= days[left];
            left++;
            count--;
        }
    }

    private static void output() {
        if (maxSum != 0) {
            System.out.println(maxSum);
            System.out.println(maxCount);
        } else {
            System.out.println("SAD");
        }
    }

}
