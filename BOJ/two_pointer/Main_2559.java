package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2559 {

    private static int numberOfDays;
    private static int sequenceDay;
    private static int[] temperature;
    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfDays = Integer.parseInt(st.nextToken());
        sequenceDay = Integer.parseInt(st.nextToken());

        temperature = new int[numberOfDays];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfDays; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void process() {
        int right = 0;
        int sum = 0;
        int countDay = 0;

        for (int left = 0; left < numberOfDays; left++) {

            while (countDay < sequenceDay && right < numberOfDays) {
                sum += temperature[right];
                right++;
                countDay++;
            }

            if (sum > maxSum && countDay == sequenceDay) {
                maxSum = sum;
            }

            sum -= temperature[left];
            countDay--;
        }
    }

    private static void output() {
        System.out.println(maxSum);
    }

}
