package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815 {

    private static int numberOfCard;
    private static int numberOfTarget;
    private static int[] cards;
    private static int[] targetCards;
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

        numberOfTarget = Integer.parseInt(br.readLine());

        targetCards = new int[numberOfTarget];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfTarget; i++) {
            targetCards[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        Arrays.sort(cards);

        for (int index = 0; index < numberOfTarget; index++) {
            binarySearch(0, numberOfCard - 1, targetCards[index]);
        }
    }

    private static void binarySearch(int left, int right, int target) {
        int mid = (left + right) / 2;

        if (left > right) {
            sb.append(0).append(" ");
            return;
        }

        if (cards[mid] == target) {
            sb.append(1).append(" ");
            return;
        }

        if (cards[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }

        binarySearch(left, right, target);
    }

    private static void output() {
        System.out.println(sb);
    }

}
