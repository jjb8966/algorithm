package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {

    static int numberOfRouters;
    static int numberOfHouses;
    static int result;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfHouses = Integer.parseInt(st.nextToken());
        numberOfRouters = Integer.parseInt(st.nextToken());

        houses = new int[numberOfHouses];

        for (int i = 0; i < numberOfHouses; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void process() {
        Arrays.sort(houses);

        int maxGap = houses[numberOfHouses - 1] - houses[0];

        binarySearch(0, maxGap);
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

    private static boolean isPossible(int distance) {
        int count = 1;
        int leftRouter = houses[0];

        for (int index = 1; index < numberOfHouses; index++) {
            int rightRouter = houses[index];

            if (rightRouter - leftRouter >= distance) {
                count++;
                leftRouter = rightRouter;
            }
        }

        return count >= numberOfRouters;
    }

    private static void output() {
        System.out.println(result);
    }

}