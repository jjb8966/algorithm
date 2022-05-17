package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {

    private static int lengthOfSequence;
    private static int numberOfGoodNumber;
    private static int[] sequence;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        lengthOfSequence = Integer.parseInt(br.readLine());

        sequence = new int[lengthOfSequence];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lengthOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        Arrays.sort(sequence);

        for (int candidate = 0; candidate < lengthOfSequence; candidate++) {
            // 다른 위치의 같은 숫자가 있을 수 있으므로 sequence 의 인덱스 값을 넘겨야 함
            if (isGoodNumber(candidate)) {
                numberOfGoodNumber++;
            }
        }
    }

    public static boolean isGoodNumber(int candidateIndex) {
        int left = 0;
        int right = lengthOfSequence - 1;

        while (left < right) {
            int sum = sequence[left] + sequence[right];

            // 서로 다른 두 수의 합이 sequence[candidateIndex] 이 되면 good number
            if (left == candidateIndex) {
                left++;
                continue;
            }

            if (right == candidateIndex) {
                right--;
                continue;
            }

            if (sum < sequence[candidateIndex]) {
                left++;
            }

            if (sum > sequence[candidateIndex]) {
                right--;
            }

            if (sum == sequence[candidateIndex]) {
                return true;
            }
        }
        return false;
    }

    private static void output() {
        System.out.println(numberOfGoodNumber);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
