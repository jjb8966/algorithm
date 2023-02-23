package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815 {

    static int numberOfCards;
    static int numberOfSearches;
    static int[] cards;
    static int[] searches;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfCards = Integer.parseInt(br.readLine());

        cards = new int[numberOfCards];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfCards; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        numberOfSearches = Integer.parseInt(br.readLine());

        searches = new int[numberOfSearches];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfSearches; i++) {
            searches[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        Arrays.sort(cards);

        for (int index = 0; index < numberOfSearches; index++) {
            binarySearch(0, numberOfCards - 1, index);
        }
    }

    private static void binarySearch(int min, int max, int index) {
        while (min <= max) {
            int mid = (min + max) / 2;

            if (cards[mid] == searches[index]) {
                sb.append(1).append(" ");
                return;
            }

            if (cards[mid] < searches[index]) {
                min = mid + 1;
            }

            if (cards[mid] > searches[index]) {
                max = mid - 1;
            }
        }

        sb.append(0).append(" ");
    }

    private static void output() {
        System.out.println(sb);
    }

}