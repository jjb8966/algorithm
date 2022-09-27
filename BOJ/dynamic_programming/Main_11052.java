package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052 {

    private static int numberOfCardToBuy;
    private static int[] pricePerCount;
    private static int[] maxPrice;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfCardToBuy = Integer.parseInt(st.nextToken());

        pricePerCount = new int[numberOfCardToBuy + 1];
        maxPrice = new int[numberOfCardToBuy + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfCardToBuy; i++) {
            pricePerCount[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int halfNumber;

        maxPrice[1] = pricePerCount[1];

        for (int targetNumber = 2; targetNumber <= numberOfCardToBuy; targetNumber++) {
            halfNumber = targetNumber / 2;

            for (int leftNumber = 1; leftNumber <= halfNumber; leftNumber++) {
                int rightNumber = targetNumber - leftNumber;
                int result = maxPrice[leftNumber] + maxPrice[rightNumber];

                if (result > maxPrice[targetNumber]) {
                    maxPrice[targetNumber] = result;
                }
            }

            if (pricePerCount[targetNumber] > maxPrice[targetNumber]) {
                maxPrice[targetNumber] = pricePerCount[targetNumber];
            }
        }
    }

    private static void output() {
        System.out.println(maxPrice[numberOfCardToBuy]);
    }

}
