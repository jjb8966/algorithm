package hash;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothMap = new HashMap<>();

        for (String[] cloth : clothes) {
            int count = clothMap.getOrDefault(cloth[1], 1);

            clothMap.put(cloth[1], ++count);
        }

        for (Integer value : clothMap.values()) {
            answer *= value;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        Solution4 prob = new Solution4();
        String[][] clothes1 = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        String[][] clothes2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        System.out.println(prob.solution(clothes1));
    }
}
