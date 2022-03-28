package brute_force;

import java.util.Scanner;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 * [입력]
 * 4 2
 * [출력]
 * 1 1
 * 1 2
 * 1 3
 * 1 4
 * 2 2
 * 2 3
 * 2 4
 * 3 3
 * 3 4
 * 4 4
 */
//중복o, 순서x -> O(N^M)보단 작음
public class Main_15652 {

    private static StringBuilder sb = new StringBuilder();
    private static int maxNumber;
    private static int maxDigit;
    private static int[] values;

    static void input() {
        Scanner sc = new Scanner(System.in);
        maxNumber = sc.nextInt();
        maxDigit = sc.nextInt();
        values = new int[maxDigit + 1];
    }

    private static void recurrenceFunction(int startDigit) {
        if (startDigit == maxDigit + 1) {       // 1. 탐색이 끝난 경우
            for (int digit = 1; digit <= maxDigit; digit++) {
                sb.append(values[digit] + " ");
            }

            sb.append("\n");
        } else {        // 2. 탐색이 남은 경우
            for (int candidate = 1; candidate <= maxNumber; candidate++) {
                values[startDigit] = candidate;

                // candidate가 앞자리 숫자보다 크거나 같아야 함
                if (values[startDigit - 1] <= values[startDigit]) {
                    recurrenceFunction(startDigit + 1);
                    values[startDigit] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        recurrenceFunction(1);
        System.out.println(sb);
    }
}
