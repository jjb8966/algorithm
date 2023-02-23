package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888 {

    private static int[] sequence;
    private static int[] numberOfOperator = new int[4];
    private static int[] orderOfOperator;
    private static int numberOfSequence;
    private static int numberOfUsedOperator;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfSequence = Integer.parseInt(st.nextToken());

        numberOfUsedOperator = numberOfSequence - 1;
        sequence = new int[numberOfSequence + 1];   // 1 ~ numberOfSequence
        orderOfOperator = new int[numberOfUsedOperator + 1]; // 1 ~ numberOfUsedOperator

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            numberOfOperator[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void recurrenceFunction(int startDigit) {    // startDigit 범위 : 1 ~ numberOfUsedOperator
        if (startDigit > numberOfUsedOperator) {    // 탐색이 끝난 경우
            int leftOperand = sequence[1];

            for (int i = 1; i <= numberOfUsedOperator; i++) {
                int operatorIndex = orderOfOperator[i];
                int rightOperand = sequence[i + 1];

                int tempResult = operate(operatorIndex, leftOperand, rightOperand);

                leftOperand = tempResult;
            }

            int result = leftOperand;

            updateResult(result);
        } else {        // 탐색이 남은 경우
            for (int operator = 0; operator <= 3; operator++) {   // 0,1,2,3 <> +,-,*,/
                if (numberOfOperator[operator] == 0) { // 해당 연산자 남은 갯수가 0개이면 pass
                    continue;
                }

                orderOfOperator[startDigit] = operator;
                numberOfOperator[operator]--;

                recurrenceFunction(startDigit + 1);

                orderOfOperator[startDigit] = 0;
                numberOfOperator[operator]++;
            }
        }
    }

    private static void updateResult(int result) {
        if (result > max) {
            max = result;
        }

        if (result < min) {
            min = result;
        }
    }

    private static int operate(int operatorIndex, int leftOperand, int rightOperand) {
        if (operatorIndex == 0) {
            return leftOperand + rightOperand;
        } else if (operatorIndex == 1) {
            return leftOperand - rightOperand;
        } else if (operatorIndex == 2) {
            return leftOperand * rightOperand;
        } else if (operatorIndex == 3) {
            return leftOperand / rightOperand;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        input();
        recurrenceFunction(1);
        System.out.println(max);
        System.out.println(min);
    }
}
