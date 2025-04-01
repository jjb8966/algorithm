package hash.한_번만_사용한_최초문자;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s){
        int answer = -1;

        Map<Character, Integer> map = new HashMap<>();

        for (int index = 0; index < s.length(); index++) {
            char character = s.charAt(index);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        for (int index = 0; index < s.length(); index++) {
            char character = s.charAt(index);
            Integer count = map.get(character);

            if(count == 1) {
                return index;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}