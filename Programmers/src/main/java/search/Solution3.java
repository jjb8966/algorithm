package search;

import java.util.ArrayList;

public class Solution3 {

    int count;
    boolean[] visited;
    ArrayList<Integer>[] adjacencyList;

    public int solution(int n, int[][] computers) {
        int length = computers.length;
        visited = new boolean[length];
        adjacencyList = new ArrayList[length];

        for (int i = 0; i < computers.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }

                if (computers[i][j] == 1) {
                    adjacencyList[i].add(j);
                }
            }
        }

        for (int vertex = 0; vertex < length; vertex++) {
            if (visited[vertex]) {
                continue;
            }

            dfs(vertex);
            count++;
        }

        return count;
    }

    private void dfs(int start) {
        visited[start] = true;

        for (Integer next : adjacencyList[start]) {
            if (visited[next]) {
                continue;
            }

            dfs(next);
            visited[next] = true;
        }
    }

    public static void main(String[] args) {
        Solution3 prob = new Solution3();
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int[][] computers2 = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };

        System.out.println(prob.solution(n, computers2));
    }

}