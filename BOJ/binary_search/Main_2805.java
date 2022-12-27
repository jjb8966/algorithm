package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805 {

    private static int numberOfTree;
    private static int targetHeight;
    private static int maxHeight;
    private static int[] trees;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfTree = Integer.parseInt(st.nextToken());
        targetHeight = Integer.parseInt(st.nextToken());

        trees = new int[numberOfTree];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfTree; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        binarySearch();
    }

    private static void binarySearch() {
        long start = 0L;
        long end = 2_000_000_000L;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (isAvailableHeight(mid)) {
                maxHeight = (int) mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    private static boolean isAvailableHeight(long height) {
        long sumTrees = cutTrees(height);

        return sumTrees >= targetHeight;
    }

    private static long cutTrees(long height) {
        long sum = 0;

        for (int treeHeight : trees) {
            if (treeHeight > height) {
                sum += treeHeight - height;
            }
        }

        return sum;
    }

    private static void output() {
        System.out.println(maxHeight);
    }

}