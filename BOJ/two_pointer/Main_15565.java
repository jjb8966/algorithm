package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15565 {

    private static int numberOfDolls;
    private static int numberOfSequenceDoll;
    private static int[] dolls;
    private static int minSizeOfSet = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfDolls = Integer.parseInt(st.nextToken());
        numberOfSequenceDoll = Integer.parseInt(st.nextToken());

        dolls = new int[numberOfDolls];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfDolls; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int right = 0;
        int count = 0;

        for (int left = 0; left < numberOfDolls; left++) {
            while (count < numberOfSequenceDoll && right < numberOfDolls) {
                if (dolls[right] == 1) {
                    count++;
                }

                right++;
            }

            if ((right - left < minSizeOfSet) && count == numberOfSequenceDoll) {
                minSizeOfSet = right - left;
            }

            if (dolls[left] == 1) {
                count--;
            }
        }

        if (minSizeOfSet == Integer.MAX_VALUE) {
            minSizeOfSet = -1;
        }
    }

    private static void output() {
        System.out.println(minSizeOfSet);
    }

}
