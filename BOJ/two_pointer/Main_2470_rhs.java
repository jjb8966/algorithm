package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 각 포인터가 탐색 범위의 양 끝에서 시작해 서로를 향해 이동
 * -> left, right에 해당하는 값을 갱신한 뒤 둘 중 어떤 것을 옮길지 판단
 * --------------------------------------------------------
 * left, right 먼저 변수로 선언
 * while(left < right)로 정답 구함
 */
public class Main_2470_rhs {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int numberOfSolutions;       //2~10만
    private static int[] values;

    public static void input() throws IOException {
        String[] temp;
        numberOfSolutions = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");

        values = new int[numberOfSolutions + 1];

        for (int i = 1; i <= numberOfSolutions; i++) {
            values[i] = Integer.parseInt(temp[i - 1]);
        }

        // 최소, 최대 원소를 빠르게 찾기 위해서 정렬을 미리 해주자.
        Arrays.sort(values, 1, numberOfSolutions + 1);  // 인덱스 1 ~ numberOfSolution 정렬
    }

    public static void twoPointer() {
        int left = 1;
        int right = numberOfSolutions;
        int minimumSum = Integer.MAX_VALUE;
        int firstSolution = 0;
        int secondSolution = 0;

        while (left < right) {  // left == right 인 상황이면 용액이 한 개 뿐인 것이므로, left < right 일 때까지만 반복한다.
            if (minimumSum > Math.abs(values[left] + values[right])) {
                minimumSum = Math.abs(values[left] + values[right]);
                firstSolution = values[left];
                secondSolution = values[right];
            }

            if (values[left] + values[right] > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(firstSolution + " " + secondSolution);
    }

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
    }
}
