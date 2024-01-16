package binary_search;

import java.io.*;
import java.util.*;

public class Main_2805 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int numberOfTree = 0;
        int target = 0;
        int result = 0;
        int maxHeight = 0;
        int[] trees;

        st = new StringTokenizer(br.readLine());
        numberOfTree = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        trees = new int[numberOfTree];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfTree; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        // process
        result = binarySearch(0, maxHeight, target, trees);

        // output
        System.out.println(result);
    }

    private static int binarySearch(int min, int max, int target, int[] trees) {
        int result = 0;
        int mid = 0;

        while (min <= max) {
            mid = (min + max) / 2;

            if (isPossible(mid, target, trees)) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return result;
    }

    private static boolean isPossible(int mid, int target, int[] trees) {
        long sum = 0;

        for (int treeHeight : trees) {
            int getTree = treeHeight - mid;

            if (getTree > 0) {
                sum += getTree;
            }
        }

        return sum >= target;
    }
}