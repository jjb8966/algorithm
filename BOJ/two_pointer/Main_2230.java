package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2230 {

    private static int n;
    private static int m;
    private static int[] numbers;
    private static int minimumGap = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

    }

    private static void process() {
        int left = 0;
        int right = 1;

        Arrays.sort(numbers);

        while (right < n) {
            if (numbers[right] - numbers[left] >= m) {
                if (numbers[right] - numbers[left] < minimumGap) {
                    minimumGap = numbers[right] - numbers[left];
                }

                left++;
                right = left + 1;
            } else {
                right++;
            }
        }
    }

    private static void output() {
        System.out.println(minimumGap);
    }

}
