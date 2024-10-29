package simulation_implementation.최대길이_바이토닉;

import java.util.ArrayList;

class Answer {
    public int solution(int[] nums) {
        int answer = 0; // 최대 길이를 저장할 변수
        int n = nums.length; // 배열의 길이
        ArrayList<Integer> peaks = new ArrayList<>(); // 피크 인덱스를 저장할 리스트

        // 배열을 순회하며 피크를 찾는 과정
        for (int i = 1; i < n - 1; i++) {
            // 현재 요소가 이전 요소보다 크고 다음 요소보다 클 때 피크로 간주
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                peaks.add(i); // 피크 인덱스를 리스트에 추가
            }
        }

        // 각 피크에 대해 왼쪽과 오른쪽으로 확장하며 바이토닉 길이를 계산
        for (int x : peaks) {
            int left = x; // 피크의 왼쪽 인덱스
            int right = x; // 피크의 오른쪽 인덱스
            int cnt = 1; // 현재 피크를 포함한 길이 카운트

            // 왼쪽으로 확장
            while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
                left--; // 왼쪽으로 이동
                cnt++; // 길이 증가
            }
            // 오른쪽으로 확장
            while (right + 1 < n && nums[right] > nums[right + 1]) {
                right++; // 오른쪽으로 이동
                cnt++; // 길이 증가
            }
            // 현재 바이토닉 수열의 최대 길이를 갱신
            answer = Math.max(answer, cnt);
        }
        return answer; // 최대 길이를 반환
    }

    public static void main(String[] args) {
        Answer T = new Answer();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1})); // 5
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2})); // 7
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1})); // 5
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1})); // 5
    }
}
