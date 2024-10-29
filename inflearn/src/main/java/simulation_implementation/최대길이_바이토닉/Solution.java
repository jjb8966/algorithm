package simulation_implementation.최대길이_바이토닉;

import java.util.*;

class Solution {
    public int solution(int[] nums){
        int answer = 0;

        int size = nums.length;
        int previousNum = nums[0];
        boolean isBitonic = false;

        for (int i = 1; i < size; i++) {
            int num = nums[i];

            if (num == previousNum) {
                previousNum = num;
                continue;
            }

            if (num < previousNum && !isBitonic) {
                previousNum = num;
                continue;
            }

        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}