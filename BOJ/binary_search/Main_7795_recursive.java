package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7795_recursive {

    private static int numberOfA;
    private static int numberOfB;
    private static int tempResult;
    private static int result;
    private static int[] sequenceA;
    private static int[] sequenceB;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();
            process();
        }

        output();
    }

    private static void input() throws IOException {
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfA = Integer.parseInt(st.nextToken());
        numberOfB = Integer.parseInt(st.nextToken());

        sequenceA = new int[numberOfA + 1];
        sequenceB = new int[numberOfB + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfA; i++) {
            sequenceA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfB; i++) {
            sequenceB[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        Arrays.sort(sequenceB);
        result = 0;

        for (int index = 1; index <= numberOfA; index++) {
            tempResult = 0;
            binarySearch(1, numberOfB, sequenceA[index]);
        }

        sb.append(result).append('\n');
    }

    private static void binarySearch(int start, int end, int target) {
        if (start > end) {
            result += tempResult;
            return;
        }

        int mid = (start + end) / 2;

        if (sequenceB[mid] < target) {
            tempResult = mid;
            start = mid + 1;
        }

        if (sequenceB[mid] >= target) {
            end = mid - 1;
        }

        binarySearch(start, end, target);
    }

    private static void output() {
        System.out.println(sb);
    }

}