package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2729 {

    static String operand1;
    static String operand2;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();
            process();
        }

        output();
    }

    private static void input() throws IOException {
        String[] operands = br.readLine().split(" ");
        operand1 = operands[0];
        operand2 = operands[1];
    }

    private static void process() {
        int carry = 0;
        int index1 = operand1.length() - 1;
        int index2 = operand2.length() - 1;
        int sum;
        StringBuilder result = new StringBuilder();

        while (index1 >= 0 || index2 >= 0) {
            sum = carry;

            if (index1 >= 0) {
                sum += operand1.charAt(index1) - '0';
                index1--;
            }

            if (index2 >= 0) {
                sum += operand2.charAt(index2) - '0';
                index2--;
            }

            carry = sum / 2;
            result.append(sum % 2);
        }

        if (carry == 1) {
            result.append(carry);
        }

        result = result.reverse();

        while (result.charAt(0) == '0') {
            if (result.length() == 1) {
                break;
            }

            result.deleteCharAt(0);
        }

        sb.append(result).append('\n');
    }

    private static void output() {
        System.out.println(sb);
    }

}