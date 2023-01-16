package hash;

import java.util.*;

public class Solution1 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution1 prob = new Solution1();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};

        System.out.println(prob.solution(participant, completion));
    }

}