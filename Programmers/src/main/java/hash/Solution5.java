package hash;

import java.util.*;

public class Solution5 {

    public int[] solution(String[] genres, int[] plays) {
        int length = genres.length;
        boolean[] visited = new boolean[length];
        Map<String, Integer> sumMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(sumMap.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<String, Integer> entry : entries) {
            String genre = entry.getKey();
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                if (genres[i].equals(genre)) {
                    list.add(plays[i]);
                }
            }

            Collections.sort(list, Comparator.reverseOrder());

            if (list.size() == 1) {
                Integer play = list.get(0);

                for (int i = 0; i < length; i++) {
                    if (plays[i] == play && !visited[i]) {
                        result.add(i);
                        visited[i] = true;
                    }
                }
            } else {
                Integer play1 = list.get(0);
                Integer play2 = list.get(1);

                for (int i = 0; i < length; i++) {
                    if (plays[i] == play1 && !visited[i]) {
                        result.add(i);
                        visited[i] = true;
                    }
                }

                for (int i = 0; i < length; i++) {
                    if (plays[i] == play2 && !visited[i]) {
                        result.add(i);
                    }
                }
            }
        }

        int[] answer = result.stream()
                .mapToInt(n -> n)
                .toArray();

        return answer;
    }

    public static void main(String[] args) {
        Solution5 prob = new Solution5();
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "kpop"};
        int[] plays = {500, 6000, 150, 800, 6000, 300};

        Arrays.stream(prob.solution(genres, plays)).forEach(n -> System.out.print(n + " "));
    }
}
