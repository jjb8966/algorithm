package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1764 {

    private static int numberOfNeverHeard;
    private static int numberOfNeverSeen;
    private static String[] neverHeard;
    private static String[] neverSeen;
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfNeverHeard = Integer.parseInt(st.nextToken());
        numberOfNeverSeen = Integer.parseInt(st.nextToken());

        neverHeard = new String[numberOfNeverHeard];
        neverSeen = new String[numberOfNeverSeen];

        for (int i = 0; i < numberOfNeverHeard; i++) {
            neverHeard[i] = br.readLine();
        }

        for (int i = 0; i < numberOfNeverSeen; i++) {
            neverSeen[i] = br.readLine();
        }
    }

    private static void process() {
        Arrays.sort(neverHeard);
        Arrays.sort(neverSeen);

        for (int targetIndex = 0; targetIndex < numberOfNeverHeard; targetIndex++) {
            binarySearch(0, numberOfNeverSeen - 1, neverHeard[targetIndex]);
        }

        result.sort(String::compareToIgnoreCase);
    }

    private static void binarySearch(int start, int end, String targetName) {
        int mid = (start + end) / 2;
        String currentName = neverSeen[mid];

        if (start > end) {
            return;
        }

        if (currentName.equals(targetName)) {
            result.add(targetName);
            return;
        }

        if (currentName.compareToIgnoreCase(targetName) < 0) {
            start = mid + 1;
        }

        if (currentName.compareToIgnoreCase(targetName) > 0) {
            end = mid - 1;
        }

        binarySearch(start, end, targetName);
    }

    private static void output() {
        System.out.println(result.size());
        result.stream().forEach(System.out::println);
    }

}
