package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156 {

    private static int numberOfCup;
    private static int[] quantityOfWine;
    private static int[][] maxDrinkingQuantity;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfCup = Integer.parseInt(br.readLine());

        quantityOfWine = new int[numberOfCup];
        maxDrinkingQuantity = new int[numberOfCup][2];  // drink or not
        result = new int[numberOfCup];

        for (int i = 0; i < numberOfCup; i++) {
            quantityOfWine[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void process() {
        // 초기값
        initStartValue();

        // 점화식
        for (int cup = 2; cup < numberOfCup; cup++) {
            int dontDrinkPrevious;
            int drinkPrevious;

            // 현재 잔 안 마심
            maxDrinkingQuantity[cup][0] = result[cup - 1];

            // 현재 잔 마심
            dontDrinkPrevious = quantityOfWine[cup] + maxDrinkingQuantity[cup - 1][0];
            drinkPrevious = quantityOfWine[cup] + quantityOfWine[cup - 1] + maxDrinkingQuantity[cup - 2][0];
            maxDrinkingQuantity[cup][1] = Math.max(dontDrinkPrevious, drinkPrevious);

            result[cup] = Math.max(maxDrinkingQuantity[cup][0], maxDrinkingQuantity[cup][1]);
        }
    }

    private static void initStartValue() {
        if (numberOfCup == 1) {
            maxDrinkingQuantity[0][1] = quantityOfWine[0];
            result[0] = maxDrinkingQuantity[0][1];

            return;
        }

        maxDrinkingQuantity[0][1] = quantityOfWine[0];
        maxDrinkingQuantity[1][0] = maxDrinkingQuantity[0][1];
        maxDrinkingQuantity[1][1] = quantityOfWine[0] + quantityOfWine[1];
        result[0] = maxDrinkingQuantity[0][1];
        result[1] = maxDrinkingQuantity[1][1];
    }

    private static void output() {
        System.out.println(result[numberOfCup - 1]);
    }

}
