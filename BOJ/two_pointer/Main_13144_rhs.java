package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2개의 포인터 모두 왼쪽에서 시작해 같은 방향으로 이동
 * -> right를 최대한 보낼수 있는 곳 까지 보냄
 * -> 정답 갱신
 * -> left 이동 - for문의 변수를 left로 사용
 * ---> left 이동으로 바뀌는 값을 꼭 체크하고 넘어가기
 */
public class Main_13144_rhs {
    private static int lengthOfSequence;       //1~10만
    private static int[] sequence;             //각 숫자 : 1~10만
    private static int[] usedNumber = new int[100_000 + 1];
    // --> 결과 sum의 최댓값 : N + (N-1) + ... + 2 + 1 = 약 50억 -> 결과는 long 변수로 담아야함

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lengthOfSequence = Integer.parseInt(br.readLine());

        sequence = new int[lengthOfSequence + 1];     //right가 빈 공간 array[N]을 가리킬 수 있도록 N+1개로 만듦

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= lengthOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }


    public static void twoPointer() {
        long result = 0;        // 수열의 길이가 10만이고 모든 수가 10만인 경우 -> 10만 * 10만 = 100억
        int right = 0;

        for (int left = 1; left <= lengthOfSequence; left++) {
            // right을 옮길 수 있는 만큼 옮긴다.
            while (right + 1 <= lengthOfSequence && usedNumber[sequence[right + 1]] == 0) {
                right++;
                usedNumber[sequence[right]]++;
            }

            // 정답을 갱신한다
            int count = right - left + 1;

            result += count;

            // left 을 옮겨주면서 A[left] 의 개수를 감소시킨다.
            // 이 부분 까먹지 말기
            usedNumber[sequence[left]]--;
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
    }
}
