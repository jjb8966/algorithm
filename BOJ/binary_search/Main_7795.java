package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 이분 탐색 기본 아이디어 : 오름차순 정렬된 배열에서 특정 숫자 x보다 작은 숫자가 몇개 있는지 세는 것
 * 정렬된 배열의 left, right을 정하고 그 중간값 mid를 x와 비교함
 * mid < x --> mid의 왼쪽 값은 안봐도 x보다 작다 --> left = mid + 1 / result = mid
 * mid > x --> mid의 오른쪽 값은 안봐도 x보다 크다 --> right = mid - 1
 * left > right --> 탐색 끝
 */
public class Main_7795 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int testCase;
    private static int numberOfA;
    private static int numberOfB;
    private static int[] valuesOfA;
    private static int[] valuesOfB;

    private static void input() throws IOException {
        String[] temp = br.readLine().split(" ");

        numberOfA = Integer.parseInt(temp[0]);
        numberOfB = Integer.parseInt(temp[1]);

        valuesOfA = new int[numberOfA];
        valuesOfB = new int[numberOfB];

        temp = br.readLine().split(" ");

        for (int i = 0; i < numberOfA; i++) {
            valuesOfA[i] = Integer.parseInt(temp[i]);
        }

        temp = br.readLine().split(" ");

        for (int i = 0; i < numberOfB; i++) {
            valuesOfB[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(valuesOfB);     // B를 정렬해놓고 A의 각 원소에 대해 이분탐색
    }

    // 이분탐색 기본 틀
    private static int binarySearch(int a) {
        int left = 0;
        int right = numberOfB - 1;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (valuesOfB[mid] < a) {
                result = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static void process() {
        int sum = 0;

        for (int a : valuesOfA) {
            sum += binarySearch(a);
        }

        sb.append(sum).append('\n');
    }

    private static void inputTestCase() throws IOException {
        testCase = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        inputTestCase();

        for (int i = 0; i < testCase; i++) {
            input();
            process();
        }

        System.out.println(sb);
    }
}
