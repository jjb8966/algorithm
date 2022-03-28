package two_pointer;

import java.util.Scanner;

/**
 * 2개의 포인터 모두 왼쪽에서 시작해 같은 방향으로 이동
 * -> right를 최대한 보낼수 있는 곳 까지 보냄
 * -> 정답 갱신
 * -> left 이동 - for문의 변수를 left로 사용
 * ---> left 이동으로 바뀌는 값을 꼭 체크하고 넘어가기
 */
public class Main_1806_rhs {
    private static int sequenceLength;
    private static int targetNumber;
    private static int[] sequence;

    public static void input() {
        Scanner sc = new Scanner(System.in);

        sequenceLength = sc.nextInt();
        targetNumber = sc.nextInt();

        sequence = new int[sequenceLength + 1];

        for (int i = 1; i <= sequenceLength; i++) {
            sequence[i] = sc.nextInt();
        }
    }

    public static void twoPointer() {
        int right = 0;
        int sum = 0;
        int result = sequenceLength + 1;

        for (int left = 1; left <= sequenceLength; left++) {
            // left - 1 을 구간에서 제외하기
            sum -= sequence[left - 1];

            // right 을 옮길 수 있을 때 까지 옮기기
            while (right + 1 <= sequenceLength && sum < targetNumber) {
                right++;
                sum += sequence[right];
            }

            int count = right - left + 1;

            // [left ... right] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
            if (sum >= targetNumber) {
                result = Math.min(result, count);
            }
        }

        // result 값을 보고 불가능 판단하기
        if (result == sequenceLength + 1) {
            result = 0;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        twoPointer();
    }
}
