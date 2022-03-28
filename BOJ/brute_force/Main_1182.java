package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제
 * N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
 * <p>
 * 출력
 * 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
 * <p>
 * 예제 입력
 * 5 0
 * -7 -3 -2 5 8
 * 예제 출력
 * 1
 */
public class Main_1182 {

    private static int sizeOfSequence;
    private static int targetNumber;
    private static int[] sequence;
    private static int result = 0;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp;

        temp = br.readLine().split(" ");

        sizeOfSequence = Integer.parseInt(temp[0]);
        targetNumber = Integer.parseInt(temp[1]);

        sequence = new int[sizeOfSequence + 1];

        temp = br.readLine().split(" ");

        for (int i = 1; i <= temp.length; i++) {
            sequence[i] = Integer.parseInt(temp[i - 1]);
        }
    }

    private static void recurrenceFunction(int startDigit, int currentSum) {
        // 1. 탐색이 끝난 경우 -> 완성된 부분수열의 합이 targetNumber와 일치하는지 확인하기
        if (startDigit == sizeOfSequence + 1) {
            if (currentSum == targetNumber) {
                result++;
            }
        } else {        // 2. 탐색이 남은 경우
            // 2-1. startDigit 자리 수를 currentSum에 더하는 경우
            recurrenceFunction(startDigit + 1, currentSum + sequence[startDigit]);

            // 2-2. startDigit 자리 수를 currentSum에 더하지 않는 경우
            recurrenceFunction(startDigit + 1, currentSum);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        recurrenceFunction(1, 0);

        if (targetNumber == 0) {
            result--;
        }

        System.out.println(result);
    }
}
