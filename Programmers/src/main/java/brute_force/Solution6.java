package brute_force;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution6 {

    int length;
    int minGap = Integer.MAX_VALUE;
    boolean[] visited;
    ArrayList<Integer>[] adjacencyList;

    public int solution(int n, int[][] wires) {
        length = wires.length;
        adjacencyList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        for (int index = 0; index < length; index++) {
            int a = wires[index][0];
            int b = wires[index][1];
            int result;
            visited = new boolean[n + 1];

            ArrayList<Integer>[] testCase = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                testCase[i] = (ArrayList<Integer>) adjacencyList[i].clone();
            }

            testCase[a].remove((Integer) b);
            testCase[b].remove((Integer) a);

            result = bfs(1, testCase);

            int gap = Math.abs(result - (n - result));

            if (gap < minGap) {
                minGap = gap;
            }
        }

        return minGap;
    }

    private int bfs(int start, ArrayList<Integer>[] testCase) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        count++;

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            for (Integer nextVertex : testCase[vertex]) {
                if (visited[nextVertex]) {
                    continue;
                }

                queue.add(nextVertex);
                visited[nextVertex] = true;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution6 prob = new Solution6();

        int n = 9;
        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };

        int n2 = 7;
        int[][] wires2 = {
                {1, 2},
                {2, 7},
                {3, 7},
                {3, 4},
                {4, 5},
                {6, 7}
        };

        System.out.println(prob.solution(n2, wires2));
    }

}