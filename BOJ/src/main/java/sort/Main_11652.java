package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11652 {

    private static int currentCount;
    private static int maxCount;
    private static int numberOfCards;
    private static long[] cards;
    private static long currentNumber;
    private static long maxNumber;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfCards = Integer.parseInt(br.readLine());

        cards = new long[numberOfCards];    // 인덱스 1 ~ numberOfCards -> 이렇게 하면 안됨!

        for (int i = 0; i < numberOfCards; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }
    }

    private static void process() {
        initialize();

        for (int i = 1; i < numberOfCards; i++) {
            if (cards[i] == currentNumber) {
                currentCount++;
            } else {
                currentNumber = cards[i];
                currentCount = 1;
            }

            if (maxCount < currentCount) {
                maxCount = currentCount;
                maxNumber = currentNumber;
            }
        }
    }

    private static void initialize() {
        Arrays.sort(cards);
        currentCount = 1;
        maxCount = currentCount;
        currentNumber = cards[0];
        maxNumber = currentNumber;
    }

    private static void output() {
        System.out.println(maxNumber);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}