package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int numberOfCards = Integer.parseInt(br.readLine());
//        Set<Object> numbers = new HashSet<>();
        int[] numbers = new int[numberOfCards];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfCards; i++) {
//            numbers.add(Integer.parseInt(st.nextToken()));
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int numberOfSearches = Integer.parseInt(br.readLine());
        int[] searches = new int[numberOfSearches];
        int[] result = new int[numberOfSearches];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfSearches; i++) {
            searches[i] = Integer.parseInt(st.nextToken());
        }

        // process
        // sol1) set 사용해서 풀기
//        for (int index = 0; index < numberOfSearches; index++) {
//            if (numbers.contains(searches[index])) {
//                result[index] = 1;
//            } else {
//                result[index] = 0;
//            }
//        }

        // sol2) 이분탐색
        Arrays.sort(numbers);
        for (int index = 0; index < numberOfSearches; index++) {
            result[index] = binarySearch(0, numberOfCards - 1, searches[index], numbers);
        }

        // output
        StringBuilder sb = new StringBuilder();
        for (int number : result) {
            sb.append(number).append(" ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int min, int max, int target, int[] numbers) {
        while (min <= max) {
            int mid = (min + max) / 2;

            if (numbers[mid] == target) {
                return 1;
            }

            if (numbers[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return 0;
    }
}