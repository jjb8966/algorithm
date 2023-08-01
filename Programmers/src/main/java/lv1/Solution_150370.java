package lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution_150370 {

    public static void main(String[] args) {
        Solution_150370 prob = new Solution_150370();

        System.out.println(prob.solution(
                "2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}
        ));
    }

    private int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();

        // 1. today 연/월/일 분리
        String[] todayInfo = today.split("\\.");
        int currentYear = Integer.parseInt(todayInfo[0]);
        int currentMonth = Integer.parseInt(todayInfo[1]);
        int currentDay = Integer.parseInt(todayInfo[2]);

        // 2. terms -> map
        HashMap<String, Integer> termToExpirationDateMap = new HashMap<>();

        for (String exp : terms) {
            String[] termInfo = exp.split(" ");
            String term = termInfo[0];
            int duration = Integer.parseInt(termInfo[1]);

            termToExpirationDateMap.put(term, duration);
        }

        for (int index = 1; index < privacies.length; index++) {
            String exp = privacies[index];

            // 3.1 privacies -> 날짜/약관 분리
            String[] privacyInfo = exp.split(" ");
            String date = privacyInfo[0];
            String[] dateInfo = date.split("\\.");
            int year = Integer.parseInt(dateInfo[0]);
            int month = Integer.parseInt(dateInfo[1]);
            int day = Integer.parseInt(dateInfo[2]);

            String term = privacyInfo[1];

            // 3.1 약관 만료일 구하기
            Integer duration = termToExpirationDateMap.get(term);

            // 3.2 만료 날짜 구하기
            int sumMonth = month + duration;

            if (sumMonth > 12) {
                year++;
            }

            // 3.3 현재 날짜와 비교해서 만료되었으면 결과에 추가
            int calcDay = currentDay - day;

            if (calcDay < 0) {

            }

        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}