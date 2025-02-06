package sorting.이진수_정렬;

import java.util.Arrays;

public class Answer {
    /**
     * 주어진 정수 배열을 이진수 1의 개수를 기준으로 오름차순 정렬하고,
     * 1의 개수가 같을 경우 원래 숫자를 기준으로 오름차순 정렬하는 함수
     *
     * @param nums 정렬할 정수 배열
     * @return 정렬된 정수 배열
     */
    public int[] solution(int[] nums) {
        // 결과를 저장할 배열
        int[] answer = new int[nums.length];
        // 각 숫자의 원래 값과 이진수 1의 개수를 저장할 2차원 배열
        int[][] numAndOneCount = new int[nums.length][2];

        // 각 숫자에 대해 이진수 1의 개수를 계산하여 numAndOneCount 배열에 저장
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int oneCount = 0;

            // 이진수 1의 개수 계산
            while (num > 0) {
                oneCount += (num % 2);
                num /= 2;
            }

            numAndOneCount[i][0] = nums[i]; // 원래 숫자 저장
            numAndOneCount[i][1] = oneCount; // 이진수 1의 개수 저장
        }

        // numAndOneCount 배열을 정렬
        // 1의 개수를 기준으로 오름차순 정렬, 1의 개수가 같을 경우 원래 숫자를 기준으로 오름차순 정렬
        Arrays.sort(numAndOneCount, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        // 정렬된 결과를 answer 배열에 저장
        for (int i = 0; i < numAndOneCount.length; i++) {
            answer[i] = numAndOneCount[i][0];
        }

        // 정렬된 배열 반환
        return answer;
    }

    public static void main(String[] args) {
        Answer T = new Answer();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}