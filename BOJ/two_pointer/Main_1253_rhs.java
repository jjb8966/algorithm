package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 각 포인터가 탐색 범위의 양 끝에서 시작해 서로를 향해 이동
 * -> left, right에 해당하는 값을 갱신한 뒤 둘 중 어떤 것을 옮길지 판단
 * --------------------------------------------------------
 * left, right 먼저 변수로 선언
 * while(left < right)로 정답 구함
 * --------------------------------------------------------
 * 수열의 각 숫자마다 good number가 될 수 있는지 판단하는 함수를 투 포인터로 구현
 */
public class Main_1253_rhs {

    private static int lengthOfSequence;           // 1~2000
    private static int[] sequence;                 // 각 숫자 : -10억~10억
    // 답을 찾는 과정에서 두 수를 더하는 경우 최대값이 20억을 넘지 않으므로 int로 충분

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        lengthOfSequence = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        sequence = new int[lengthOfSequence + 1];

        for (int i = 1; i <= lengthOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        // 최소, 최대를 빠르게 알기 위한 정렬
        Arrays.sort(sequence, 1, lengthOfSequence + 1);     // O(NlogN)
    }

    public static void twoPointer() {
        int result = 0;

        for (int index = 1; index <= lengthOfSequence; index++) {
            // index 번째 원소가 서로 다른 두 수의 합으로 표현이 되는가? isGoodNumber?
            if (isGoodNumber(index)) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static boolean isGoodNumber(int index) {
        int left = 1;
        int right = lengthOfSequence;
        int targetNumber = sequence[index];

        while(left < right) {       // targetNumber를 만드는 두 수를 찾는 것이기 때문에 등호 x
            if(left == index) {
                left++;
                continue;
            }

            if(right == index) {
                right--;
                continue;
            }

            if(sequence[left] + sequence[right] > targetNumber) {
                right--;
            } else if(sequence[left] + sequence[right] < targetNumber) {
                left ++;
            } else {
                return true;    // sequence[left] + sequence[right] == targetNumber
            }
        }

        // while문을 다 돌릴 동안 return이 안되면 targetNumber를 만들 수 있는 두 수가 없다는 뜻
        return false;
    }

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
    }
}
