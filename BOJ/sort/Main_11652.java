package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제
 * 준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -262보다 크거나 같고, 262보다 작거나 같다.
 *
 * 준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
 *
 * 입력
 * 첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
 *
 * 출력
 * 첫째 줄에 준규가 가장 많이 가지고 있는 정수를 출력한다.
 *
 * 예제 입력
 * 5
 * 1
 * 2
 * 1
 * 2
 * 1
 * 예제 출력
 * 1
 */
public class Main_11652 {
    private static int N;               //카드의 갯수 : 1~10만
    private static long[] cards;        //카드의 값 : -2^62 ~ 2^62


    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cards = new long[N];

        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextLong();
        }
    }

    public static void process() {
        Arrays.sort(cards);                //카드의 값 오름차순으로 정렬

        int currentCount = 1;
        int maxCount = currentCount;       //만약 가장 많이 가지고 있는 정수가 여러가지라면 가장 작은 것을 출력해야하므로
        long currentNumber = cards[0];
        long maxNumber = currentNumber;

        for (int i = 1; i < cards.length; i++) {
            if (currentNumber == cards[i]) {
                currentCount++;
            } else {
                currentNumber = cards[i];
                currentCount = 1;
            }

            if (maxCount < currentCount) {      // 같은 갯수면 작은 숫자가 출력되어야 하므로 같으면 안됨
                maxCount = currentCount;
                maxNumber = currentNumber;
            }
        }

        System.out.println(maxNumber);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
