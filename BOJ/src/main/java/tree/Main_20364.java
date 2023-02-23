package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20364 {

    private static int numberOfLand;
    private static int numberOfDuck;
    private static int[] wantLand;
    private static boolean[] owned;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        numberOfLand = Integer.parseInt(st.nextToken());
        numberOfDuck = Integer.parseInt(st.nextToken());

        owned = new boolean[numberOfLand + 1];
        wantLand = new int[numberOfDuck];

        for (int i = 0; i < numberOfDuck; i++) {
            wantLand[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void process() {
        for (int i = 0; i < numberOfDuck; i++) {
            int land = wantLand[i];
            int parentLand = land;
            int result = 0;

            while (parentLand != 0) {
                if (owned[parentLand]) {
                    result = parentLand;
                }

                parentLand /= 2;
            }

            if (result == 0) {
                owned[land] = true;
            }

            sb.append(result).append('\n');
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}
