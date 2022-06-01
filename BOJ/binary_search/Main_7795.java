package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이분 탐색 기본 아이디어 : 오름차순 정렬된 배열에서 특정 숫자 x보다 작은 숫자가 몇개 있는지 세는 것
 * 정렬된 배열의 left, right을 정하고 그 중간값 mid를 x와 비교함
 * mid < x --> mid의 왼쪽 값은 안봐도 x보다 작다 --> left = mid + 1 / result = mid
 * mid > x --> mid의 오른쪽 값은 안봐도 x보다 크다 --> right = mid - 1
 * left > right --> 탐색 끝
 */
public class Main_7795 {

    private static int numberOfTestcase;
    private static int numberOfA;
    private static int numberOfB;
    private static int[] valuesForA;
    private static int[] valuesForB;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static void input() throws IOException {
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfA = Integer.parseInt(st.nextToken());
        numberOfB = Integer.parseInt(st.nextToken());

        valuesForA = new int[numberOfA];
        valuesForB = new int[numberOfB];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfA; i++) {
            valuesForA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfB; i++) {
            valuesForB[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int sum = 0;

        Arrays.sort(valuesForB);

        for (int a : valuesForA) {
            sum += binarySearch(a);
        }

        sb.append(sum).append('\n');
    }

    private static int binarySearch(int a) {
        int start = 0;
        int end = numberOfB - 1;
        int mid;
        int result = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (valuesForB[mid] < a) {
                result = mid + 1;
                start = mid + 1;
            }

            if (valuesForB[mid] >= a) {
                end = mid - 1;
            }
        }

        return result;
    }

    private static void output() {
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        numberOfTestcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfTestcase; i++) {
            input();
            process();
        }

        output();
    }
}
