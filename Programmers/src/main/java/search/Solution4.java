package search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution4 {

    int wordLength;
    int[] distance;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        List<String> wordList = Arrays.stream(words).collect(Collectors.toList());
        wordList.add(begin);

        if (!wordList.contains(target)) {
            return 0;
        }

        wordLength = words[0].length();
        visited = new boolean[wordList.size()];
        distance = new int[wordList.size()];

        bfs(begin, wordList);

        return distance[wordList.indexOf(target)];
    }

    private void bfs(String begin, List<String> words) {
        Queue<Integer> queue = new LinkedList<>();
        int startIndex = words.indexOf(begin);

        queue.add(startIndex);
        visited[startIndex] = true;
        distance[startIndex] = 0;

        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            String word = words.get(index);

            for (int compareIndex = 0; compareIndex < words.size(); compareIndex++) {
                if (visited[compareIndex]) {
                    continue;
                }

                String compareWord = words.get(compareIndex);
                int diff = 0;

                for (int digit = 0; digit < wordLength; digit++) {
                    if (word.charAt(digit) != compareWord.charAt(digit)) {
                        diff++;
                    }
                }

                if (diff == 1) {
                    queue.add(compareIndex);
                    distance[compareIndex] = distance[index] + 1;
                    visited[compareIndex] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution4 prob = new Solution4();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(prob.solution(begin, target, words));
    }

}