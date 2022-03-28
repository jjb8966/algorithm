package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2217 {

    private static int numberOfRope;
    private static int[] ropes;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfRope = Integer.parseInt(br.readLine());

        ropes = new int[numberOfRope];

        for (int i = 0; i < numberOfRope; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);
    }

    private static void process() {
        int maxWeight = Integer.MIN_VALUE;

        for (int i = 0; i < numberOfRope; i++) {
            maxWeight = Math.max(maxWeight, ropes[i] * (numberOfRope - i));
        }

        System.out.println(maxWeight);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
