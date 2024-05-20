package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2667 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[][] direction = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        for (int y = 0; y < n; y++) {
            String[] row = br.readLine().split("");

            for (int x = 0; x < n; x++) {
                map[x][y] = Integer.parseInt(row[x]);
            }
        }

        // process
        int numberOfVillage = 0;
        List<Integer> result = new ArrayList<>();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[x][y] == 0) {
                    continue;
                }

                if (visited[x][y]) {
                    continue;
                }

                numberOfVillage++;
//                int numberOfHouse = dfs(x, y, map, visited, direction);
                int numberOfHouse = bfs(x, y, map, visited, direction);
                result.add(numberOfHouse);
            }
        }

        // output
        System.out.println(numberOfVillage);
        result.sort((o1, o2) -> o1 - o2);
        result.forEach(System.out::println);
    }

    private static int dfs(int x,
                           int y,
                           int[][] map,
                           boolean[][] visited,
                           int[][] direction) {
        visited[x][y] = true;
        int n = map.length;
        int result = 1;

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + direction[dir][0];
            int newY = y + direction[dir][1];

            if (newX < 0 || newY < 0 || newX >= n || newY >= n) {
                continue;
            }

            if (visited[newX][newY]) {
                continue;
            }

            if (map[newX][newY] == 0) {
                continue;
            }

            result += dfs(newX, newY, map, visited, direction);
        }

        return result;
    }

    private static int bfs(int startX,
                           int startY,
                           int[][] map,
                           boolean[][] visited,
                           int[][] direction) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.offer(startX);
        queue.offer(startY);
        int n = map.length;
        int result = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];

                if (newX < 0 || newY < 0 || newX >= n || newY >= n) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] == 0) {
                    continue;
                }

                visited[newX][newY] = true;
                result++;
                queue.offer(newX);
                queue.offer(newY);
            }
        }

        return result;
    }
}