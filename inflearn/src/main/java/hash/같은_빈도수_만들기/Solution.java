package hash.같은_빈도수_만들기;

import java.util.*;

class Solution {
	public int[] solution(String s){
		int[] answer = new int[5];

        Map<Character, Integer> countMap = new HashMap<>();
        int maxCount = 0;

        for (char character : s.toCharArray()) {
            int count = countMap.getOrDefault(character, 0) + 1;
            countMap.put(character, count);

            maxCount = Math.max(maxCount, count);
        }

        for (int index = 0; index < 5; index++) {
            char alphabet = (char) (index + 97);
            int count = countMap.getOrDefault(alphabet, 0);
            int needCount = maxCount - count;
            answer[index] = needCount;
        }

		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
