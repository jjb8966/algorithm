package brute_force;

import java.util.Scanner;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * <p>
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
 * [입력]
 * 4 2
 * [출력]
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 * <p>
 * 순서 x -> 순서를 고려하지 않고 뽑기만 하면 됨
 */
//중복x, 순서x -> O(N C M) = N! / M!(N-M)!
public class Main_15650 {

    private static StringBuilder sb = new StringBuilder();
    private static int maxNumber;
    private static int maxDigit;
    private static int[] values;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        maxNumber = sc.nextInt();
        maxDigit = sc.nextInt();
        values = new int[maxDigit + 1];
    }

    static void recurrenceFunction(int startDigit) {
        if (startDigit == maxDigit + 1) {       // 1. 탐색이 끝난 경우
            for (int digit = 1; digit <= maxDigit; digit++) {
                sb.append(values[digit]).append(' ');
            }

            sb.append('\n');
        } else {        // 2. 탐색이 남은 경우
            for (int candidate = values[startDigit - 1] + 1; candidate <= maxNumber; candidate++) {
                // 앞 자리 숫자보다 작으면 안되고 똑같은 숫자를 사용할 수 없으므로 시작이 values[digit -1] + 1
                values[startDigit] = candidate;

                recurrenceFunction(startDigit + 1);

                values[startDigit] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recurrenceFunction(1);
        System.out.println(sb);
    }
}

