package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {

    private static int numberOfHouse;
    private static int numberOfRouter;
    private static int maxDistance;
    private static int[] houseCoordinate;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfHouse = Integer.parseInt(st.nextToken());
        numberOfRouter = Integer.parseInt(st.nextToken());

        houseCoordinate = new int[numberOfHouse + 1];

        for (int i = 1; i <= numberOfHouse; i++) {
            houseCoordinate[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void process() {
        binarySearch();
    }

    private static void binarySearch() {
        int start = 0;
        int end = 1_000_000_000;

        Arrays.sort(houseCoordinate);

        while (start <= end) {
            int mid = (start + end) / 2;

            if (isAvailable(mid)) {
                maxDistance = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    private static boolean isAvailable(int distance) {
        int countRouter = 1;
        int leftRouterCoordinate = houseCoordinate[1];

        for (int house = 2; house <= numberOfHouse; house++) {
            int rightRouterCoordinate = houseCoordinate[house];
            int gap = rightRouterCoordinate - leftRouterCoordinate;

            if (gap >= distance) {
                countRouter++;
                leftRouterCoordinate = rightRouterCoordinate;
            }
        }

        return countRouter >= numberOfRouter;
    }

    private static void output() {
        System.out.println(maxDistance);
    }

}