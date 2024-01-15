package binary_search;

import java.io.*;
import java.util.*;

public class Main_2512 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int numberOfRequest = Integer.parseInt(br.readLine());
        int[] requests = new int[numberOfRequest];
        int budget = 0;
        int max = 0;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfRequest; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, requests[i]);
        }

        budget = Integer.parseInt(br.readLine());

        // process
        result = binarySearch(1, max, requests, budget);

        // output
        System.out.println(result);
    }

    private static int binarySearch(int min, int max, int[] requests, int budget) {
        int result = 0;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (isPossible(mid, requests, budget)) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return result;
    }

    private static boolean isPossible(int mid, int[] requests, int budget) {
        int sum = 0;

        for (int request : requests) {
            if (request > mid) {
                sum += mid;
            } else {
                sum += request;
            }
        }

        return sum <= budget;
    }
}