package brute_force;

import java.util.Scanner;

//중복x, 순서x -> O(N C M) = N! / M!(N-M)!
public class Main_15650 {

    private static StringBuilder sb = new StringBuilder();
    private static int maxNumber;
    private static int maxDigit;
    private static int[] used;
    private static int[] values;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        maxNumber = sc.nextInt();
        maxDigit = sc.nextInt();
        used = new int[maxNumber + 1];  // 1 ~ maxNumber
        values = new int[maxDigit + 1]; // 1 ~ maxDigit
    }

    private static void recurrenceFunction(int startDigit) {
        if (startDigit == maxDigit + 1) {
            for (int digit = 1; digit <= maxDigit; digit++) {
                sb.append(values[digit]).append(" ");
            }

            sb.append('\n');
        } else {
            for (int candidate = 1; candidate <= maxNumber; candidate++) {
                if (used[candidate] == 1) { // 중복 허용 x
                    continue;
                }

                values[startDigit] = candidate;
                used[candidate] = 1;

                if (values[startDigit - 1] < values[startDigit]) { // 오름차순
                    recurrenceFunction(startDigit + 1);
                }

                values[startDigit] = 0;
                used[candidate] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recurrenceFunction(1);
        System.out.println(sb);
    }
}

