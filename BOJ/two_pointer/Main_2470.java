package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2470 {
    //Scanner를 쓰면 시간초과가 나고 BufferedReader를 쓰면 정답이되는 문제... 웬만하면 BufferedReader 쓰는게 좋을듯
    //static Scanner sc = new Scanner(System.in);
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;       //2~10만
    private static int[] values;

    public static void input() throws IOException {
        String[] temp;
        N = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");

        values = new int[N];

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(values);
    }

    public static void twoPointer() {
        int left = 0;
        int right = N - 1;
        int sum;
        int minimumSum = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {
            sum = values[left] + values[right];

            if (minimumSum > Math.abs(sum)) {
                minimumSum = Math.abs(sum);
                result[0] = values[left];
                result[1] = values[right];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
    }
}
