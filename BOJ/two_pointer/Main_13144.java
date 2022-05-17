package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13144 {

    private static int lengthOfSequence;
    // --> result 최댓값 : N + (N-1) + ... + 2 + 1 = 약 50억 -> 결과는 long 변수로 담아야함
    private static long result;
    private static int[] sequence;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        lengthOfSequence = Integer.parseInt(br.readLine());
        sequence = new int[lengthOfSequence + 1];   // right 가 수열의 (마지막 인덱스 + 1)을 가리킬 수 있도록

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lengthOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int right = 0;
        int[] count = new int[100001];

        for (int left = 0; left < lengthOfSequence; left++) {
            while (count[sequence[right]] != 1 && right < lengthOfSequence) {
                count[sequence[right]]++;
                right++;
            }

            result += right - left;
            count[sequence[left]]--;
        }
    }

    private static void output() {
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
