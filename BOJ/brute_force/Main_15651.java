package brute_force;

import java.util.Scanner;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 1 ≤ M ≤ N ≤ 7
 * [입력]
 * 3 2
 * [출력]
 * 1 1
 * 1 2
 * 1 3
 * 2 1
 * 2 2
 * 2 3
 * 3 1
 * 3 2
 * 3 3
 */
//중복o , 순서o -> O(N^M)
public class Main_15651 {

    private static StringBuilder sb = new StringBuilder();
    private static int maxNumber;
    private static int maxDigit;
    private static int[] values;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        maxNumber = sc.nextInt();
        maxDigit = sc.nextInt();
        values = new int[maxDigit + 1];        //1~M의 인덱스를 사용하기 위해
    }

    //k번째 자리부터 조건에 맞는 원소를 고르는 재귀 함수
    private static void recurrenceFunction(int startDigit) {
        // 1. 탐색이 끝난 경우
        if (startDigit == maxDigit + 1) {
            for (int digit = 1; digit <= maxDigit; digit++) {
                sb.append(values[digit] + " ");
            }

            sb.append("\n");
        } else {                // 2. 탐색이 남은 경우
            for (int candidate = 1; candidate <= maxNumber; candidate++) {     //k번째 자리에 올 수 있는 숫자 대입 후 k+1
                values[startDigit] = candidate;

                recurrenceFunction(startDigit + 1);

                values[startDigit] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recurrenceFunction(1);      //1번째 자리부터 올바른 원소를 고르는 함수\
        System.out.println(sb);
    }
}
