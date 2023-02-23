package array;

import java.util.Scanner;

/**
 * #int -> String
 * Integer.toString() - 매개변수로 null을 받는 경우 NullPointerException을 발생시킬 수 있음
 * String.valueOf() - 매개변수로 null을 받는 경우 문자열 "null"을 만들어서 반환
 * ---> 결론 : NPE 예외를 발생시킬 수 있는 toString()보다 valueOf() 쓰는게 더 좋음
 * <p>
 * #println을 반복적으로 사용하는 대시 StringBuilder를 사용해 결과를 출력하는 이유
 * println을 사용할 경우 synchronized 하는데 이 과정에서 오버헤드가 발생할 수 있음
 * 따라서 결과를 출력할 때 println을 반복적으로 사용하기 보다 StringBuilder에 결과를 저장하고
 * 마지막에 한번만 출력하는게 더 성능에 좋음.
 * 이 문제의 경우 결과를 출력하는데 개행이 필요한데 StringBuilder에 "\n"을 추가함으로써 구현할 수 있음
 * <p>
 * #char, 숫자(1~9) 비교 : char - '0' == 숫자
 */
public class Main_2577 {
    public static void main(String[] args) {
        int A, B, C, result;
        int[] numberArray = new int[10];
        String resultArray;
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        result = A * B * C;
        resultArray = String.valueOf(result);

        for (int i = 0; i < resultArray.length(); i++) {
            for (int j = 0; j < 10; j++) {
                if (resultArray.charAt(i) - '0' == j) {
                    numberArray[j]++;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            sb.append(numberArray[i]).append("\n");
        }
        sb.append(numberArray[9]);

        System.out.print(sb);
    }
}
