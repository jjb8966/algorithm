package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399 {

    static int numberOfPeople;
    static int result;
    static int[] times;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfPeople = Integer.parseInt(br.readLine());

        times = new int[numberOfPeople];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < times.length; i++) {
            int time = Integer.parseInt(st.nextToken());

            times[i] = time;
        }
    }

    private static void process() {
        int currentTime = 0;

        Arrays.sort(times);

        for (int time : times) {
            currentTime += time;
            result += currentTime;
        }
    }

    private static void output() {
        System.out.println(result);
    }

}