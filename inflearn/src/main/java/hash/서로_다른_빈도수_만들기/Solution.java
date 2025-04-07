package hash.서로_다른_빈도수_만들기;

import java.util.*;

class Solution {
	public int solution(String s){
		int answer = 0;

		Map<Character, Integer> map = new HashMap<>();
		for (char character : s.toCharArray()) {
			map.put(character, map.getOrDefault(character, 0) + 1);
		}

		Set<Integer> countSet = new HashSet<>();
		for (Integer count : map.values()) {
			while(countSet.contains(count)) {
				answer++;
				count--;

                if (count == 0) {
                    break;
                }
			}

			countSet.add(count);
		}

		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution("aaabbbcc"));
		System.out.println(T.solution("aaabbc"));
		System.out.println(T.solution("aebbbbc"));
		System.out.println(T.solution("aaabbbcccde"));
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));
	}
}
