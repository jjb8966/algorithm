package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182 {

    private static int numberOfSequence;
    private static int targetSum;
    private static int[] sequence;
    private static int sum = 0;
    private static int result;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfSequence = Integer.parseInt(st.nextToken());
        targetSum = Integer.parseInt(st.nextToken());

        sequence = new int[numberOfSequence + 1]; // 1 ~ numberOfSequence

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int firstIndex = 1;

        recurrenceFunction(firstIndex, sum);

        if (targetSum == 0) {
            result--;
        }
    }

    private static void recurrenceFunction(int startIndex, int sum) {
        if (startIndex > numberOfSequence) {
            if (sum == targetSum) {
                result++;
            }
        } else {
            // 해당 인덱스 자리의 숫자를 더하는 경우
            recurrenceFunction(startIndex + 1, sum + sequence[startIndex]);

            // 해당 인덱스 자리의 숫자를 더하지 않는 경우
            recurrenceFunction(startIndex + 1, sum);
        }
    }


    private static void output() {
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}