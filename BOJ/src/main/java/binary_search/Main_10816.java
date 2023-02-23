package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10816 {

    private static int numberOfCard;
    private static int numberOfFind;
    private static int[] cards;
    private static int[] findCards;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfCard = Integer.parseInt(br.readLine());
        cards = new int[numberOfCard];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfCard; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        numberOfFind = Integer.parseInt(br.readLine());
        findCards = new int[numberOfFind];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfFind; i++) {
            findCards[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        Arrays.sort(cards);

        for (int i = 0; i < numberOfFind; i++) {
            int findCard = findCards[i];
            int lowerBound = findLowerBound(0, numberOfCard - 1, findCard);
            int upperBound = findUpperBound(0, numberOfCard - 1, findCard);

            sb.append(upperBound - lowerBound + 1).append(" ");
        }
    }

    private static int findUpperBound(int start, int end, int findCard) {
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int currentCard = cards[mid];

            if (currentCard <= findCard) {
                start = mid + 1;

                if (currentCard == findCard) {
                    result = mid;
                }
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    private static int findLowerBound(int start, int end, int findCard) {
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int currentCard = cards[mid];

            if (currentCard >= findCard) {
                end = mid - 1;

                if (currentCard == findCard) {
                    result = mid;
                }
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private static void output() {
        System.out.println(sb);
    }

}