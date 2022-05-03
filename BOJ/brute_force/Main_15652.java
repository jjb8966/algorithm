package brute_force;

import java.util.Scanner;

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
                }

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
