package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {

    static int numberOfTrees;
    static int targetHeight;
    static long result;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfTrees = Integer.parseInt(st.nextToken());
        targetHeight = Integer.parseInt(st.nextToken());

        trees = new int[numberOfTrees];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfTrees; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int maxHeight = Arrays.stream(trees)
                .max()
                .getAsInt();

        binarySearch(1, maxHeight);
    }

    private static void binarySearch(int min, int max) {
        while (min <= max) {
            int mid = (min + max) / 2;

            if (isPossible(mid)) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
    }

    private static boolean isPossible(int currentHeight) {
        long sum = 0;

        for (int i = 0; i < numberOfTrees; i++) {
            if (trees[i] > currentHeight) {
                sum += trees[i] - currentHeight;
            }
        }

        return sum >= targetHeight;
    }

    private static void output() {
        System.out.println(result);
    }

}