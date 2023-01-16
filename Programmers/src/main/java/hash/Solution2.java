package hash;

import java.util.*;

public class Solution2 {

    public int solution(int[] nums) {
        int answer = 0;
        int count = nums.length / 2;

        Set<Integer> set = new HashSet<>();

        for (int number : nums) {
            set.add(number);
        }

        if (set.size() > count) {
            answer = count;
        } else {
            answer = set.size();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution2 prob = new Solution2();
        int[] nums = {3, 3, 3, 2, 2, 4};

        System.out.println(prob.solution(nums));
    }

}