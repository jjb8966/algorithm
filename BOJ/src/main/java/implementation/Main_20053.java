package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20053 {

    static int lengthOfNumber;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] numbers;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();
            process();
        }

        output();
    }

    private static void input() throws IOException {
        StringTokenizer st;

        lengthOfNumber = Integer.parseInt(br.readLine());

        numbers = new int[lengthOfNumber];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lengthOfNumber; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        min = Arrays.stream(numbers).min().getAsInt();
        max = Arrays.stream(numbers).max().getAsInt();

        sb.append(min).append(" ").append(max).append('\n');
    }

    private static void output() {
        System.out.println(sb);
    }

}