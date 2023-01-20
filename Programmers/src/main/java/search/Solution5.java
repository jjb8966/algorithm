package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution5 {

    int count = 1;
    boolean[] visited;
    List<String> result = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String start = "ICN";
        String[] answer;

        for (int index = 0; index < tickets.length; index++) {
            if (tickets[index][0].equals("ICN")) {
                visited = new boolean[tickets.length];

                visited[index] = true;
                dfs(index, count, start, tickets);
            }
        }

        Collections.sort(result);
        answer = result.get(0).split(" ");

        return answer;
    }

    private void dfs(int index, int count, String route, String[][] tickets) {
        if (count == tickets.length) {
            result.add(route + " " + tickets[index][1]);
            return;
        }

        String destination = tickets[index][1];

        for (int nextIndex = 0; nextIndex < tickets.length; nextIndex++) {
            if (visited[nextIndex]) {
                continue;
            }

            if (tickets[nextIndex][0].equals(destination)) {
                visited[nextIndex] = true;
                dfs(nextIndex, count + 1, route + " " + destination, tickets);
                visited[nextIndex] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution5 prob = new Solution5();
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        String[][] tickets2 = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };

        String[][] tickets3 = {
                {"ICN", "B"},
                {"B", "ICN"},
                {"ICN", "C"},
                {"C", "ICN"},
                {"C", "D"},
                {"D", "C"},
                {"D", "B"},
                {"B", "D"},
                {"ICN", "B"}
        };

        Arrays.stream(prob.solution(tickets3)).forEach(n -> System.out.print(n + " "));
    }

}