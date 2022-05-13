package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 포인터 - left, right 모두 왼쪽에서 시작하는 경우
 * right를 보낼 수 있는데까지 보냄
 * 거기서 left 하나씩 옮겨보면서 right을 옮길지 말지 결정
 */
public class Main_1806 {

    private static int numberOfSequence;
    private static int targetSum;
    private static int minLength = Integer.MAX_VALUE;
    private static int[] sequence;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfSequence = Integer.parseInt(st.nextToken());
        targetSum = Integer.parseInt(st.nextToken());

        sequence = new int[numberOfSequence + 1];   // index : 1 ~ numberOfSequence

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int right = 1;
        int currentSum = 0;
        int currentLength = 0;

        for (int left = 1; left <= numberOfSequence; left++) {
            // right 를 옮길 수 있을 때 까지 옮기기
            while (right <= numberOfSequence && currentSum < targetSum) {
                currentSum += sequence[right];
                right++;
            }

            // right 가 맨 끝까지 갔는데도 currentSum 이 targetSum 보다 작은 경우를 제외해야함
            if (currentSum >= targetSum) {
                currentLength = right - left;
            }

            // 정답 갱신
            if (minLength > currentLength) {
                minLength = currentLength;
            }

            // left 에 해당하는 값을 뻄
            currentSum -= sequence[left];
        }
    }

    private static void output() {
        System.out.println(minLength);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}