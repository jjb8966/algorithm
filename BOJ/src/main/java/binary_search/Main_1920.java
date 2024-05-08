package binary_search;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1920 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int numberOfSequence = Integer.parseInt(br.readLine());
        int[] sequence = new int[numberOfSequence];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int numberOfFindNumber = Integer.parseInt(br.readLine());
        int[] findNumbers = new int[numberOfFindNumber];
        int[] results = new int[numberOfFindNumber];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfFindNumber; i++) {
            findNumbers[i] = Integer.parseInt(st.nextToken());
        }

        // process
        Arrays.sort(sequence);

        for (int i = 0; i < numberOfFindNumber; i++) {
            int findNumber = findNumbers[i];

            if (isExist(sequence, findNumber)) {
                results[i] = 1;
            } else {
                results[i] = 0;
            }
        }

        // output
        Arrays.stream(results).forEach(System.out::println);
    }

    private static boolean isExist(int[] sequence, int findNumber) {
        int min = 0;
        int max = sequence.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            int number = sequence[mid];

            if (number == findNumber) {
                return true;
            }

            if (number < findNumber) {
                min = mid + 1;
            }

            if (number > findNumber) {
                max = mid - 1;
            }
        }

        return false;
    }
}
