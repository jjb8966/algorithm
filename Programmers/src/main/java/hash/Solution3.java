package hash;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();

        for (String exp : phone_book) {
            set.add(exp);
        }

        for (String exp : phone_book) {
            for (int i = 1; i < exp.length(); i++) {
                if (set.contains(exp.substring(0, i))) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution3 prob = new Solution3();
        String[] phone_book1 = {"123", "456", "789"};
        String[] phone_book2 = {"97674223", "119", "1195524421"};

        System.out.println(prob.solution(phone_book1));
    }
}
