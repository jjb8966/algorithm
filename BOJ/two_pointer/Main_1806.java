package two_pointer;

import java.util.Scanner;

/**
 * 두 포인터 - left, right 모두 왼쪽에서 시작하는 경우
 * right를 보낼 수 있는데까지 보냄
 * 거기서 left 하나씩 옮겨보면서 right을 옮길지 말지 결정
 */
public class Main_1806 {
    private static int sequenceLength;
    private static int targetNumber;
    private static int[] sequence;

    public static void input() {
        Scanner sc = new Scanner(System.in);

        sequenceLength = sc.nextInt();
        targetNumber = sc.nextInt();

        sequence = new int[sequenceLength];

        for (int i = 0; i < sequenceLength; i++) {
            sequence[i] = sc.nextInt();
        }
    }

    public static void twoPointer() {
        int right = 0;
        int sum = 0;
        int count = 0;
        int minCount = sequenceLength + 1;

        for (int left = 0; left < sequenceLength; left++) {
            // right를 옮길 수 있을 때 까지 옮기기
            while (right < sequenceLength && sum < targetNumber) {
                sum += sequence[right];
                right++;
            }

            if (sum >= targetNumber) {
                count = right - left;
            }

            // 정답 갱신
            if (minCount > count) {
                minCount = count;
            }

            // left - 1을 구간에서 제외
            sum -= sequence[left];
        }

        System.out.println(minCount);
    }

    public static void main(String[] args) {
        input();
        twoPointer();
    }
}
