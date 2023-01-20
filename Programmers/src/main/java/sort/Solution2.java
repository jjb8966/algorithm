package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {

    public String solution(int[] numbers) {
        boolean allZero = Arrays.stream(numbers)
                .noneMatch(n -> n != 0);

        if (allZero) {
            return "0";
        }

        List<String> collect = Arrays.stream(numbers)
                .mapToObj(n -> String.valueOf(n))
                .collect(Collectors.toList());

        Collections.sort(collect, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        String answer = collect.stream()
                .reduce((s1, s2) -> s1 + s2).get();

        return answer;
    }

    public static void main(String[] args) {
        Solution2 prob = new Solution2();
        int[] numbers = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};
        int[] numbers3 = {0, 0, 0, 0};

        System.out.println("1".compareTo("2"));

        System.out.println(prob.solution(numbers));
        System.out.println(prob.solution(numbers2));
        System.out.println(prob.solution(numbers3));
    }

}