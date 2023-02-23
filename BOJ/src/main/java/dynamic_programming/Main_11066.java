package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11066 {

    private static int numberOfFile;
    private static int[] files;
    private static int[][] sum;
    private static int[][] result;

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

        numberOfFile = Integer.parseInt(br.readLine());

        files = new int[numberOfFile + 1];
        result = new int[numberOfFile + 1][numberOfFile + 1];
        sum = new int[numberOfFile + 1][numberOfFile + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfFile; i++) {
            files[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        init();

        for (int end = 3; end <= numberOfFile; end++) {
            for (int start = end; start >= 1; start--) {
                int min = Integer.MAX_VALUE;

                for (int boundary = start; boundary < end; boundary++) {
                    int temp = result[start][boundary] + result[boundary + 1][end] + sum[start][end];

                    if (temp < min) {
                        min = temp;
                        result[start][end] = min;
                    }
                }
            }
        }

        sb.append(result[1][numberOfFile]).append('\n');
    }

    private static void init() {
        for (int start = 1; start < numberOfFile; start++) {
            result[start][start + 1] = files[start] + files[start + 1];
        }

        for (int start = 1; start <= numberOfFile; start++) {
            for (int end = 1; end <= numberOfFile; end++) {
                sum[start][end] = sum(start, end);
            }
        }
    }

    private static int sum(int start, int end) {
        int result = 0;

        for (int i = start; i <= end; i++) {
            result += files[i];
        }

        return result;
    }

    private static void output() {
        System.out.println(sb);
    }

}