package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798 {

    private static int numberOfCard;
    private static int targetNumber;
    private static int resultSum;
    private static int[] resultCards = new int[3];
    private static int[] cards;
    private static boolean[] used = new boolean[3];

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfCard = Integer.parseInt(st.nextToken());
        targetNumber = Integer.parseInt(st.nextToken());

        cards = new int[numberOfCard];
        used = new boolean[numberOfCard];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfCard; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        chooseCard(0);
    }

    private static void chooseCard(int index) {
        if (index >= 3) {
            updateSum();
            return;
        }

        for (int candidate = 0; candidate < numberOfCard; candidate++) {
            if (used[candidate]) {
                continue;
            }

            resultCards[index] = cards[candidate];

            used[candidate] = true;
            chooseCard(index + 1);
            used[candidate] = false;
        }
    }

    private static void updateSum() {
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            sum += resultCards[i];
        }

        if (sum <= targetNumber && isCloser(sum)) {
            resultSum = sum;
        }
    }

    private static boolean isCloser(int sum) {
        return targetNumber - sum < targetNumber - resultSum;
    }

    private static void output() {
        System.out.println(resultSum);
    }

}
