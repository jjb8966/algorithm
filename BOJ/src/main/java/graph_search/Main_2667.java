package graph_search;

import java.io.*;
import java.util.*;

public class Main_2667 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] map = new int[size + 1][size + 1];
        for (int y = 1; y <= size; y++) {
            String[] row = br.readLine().split("");

            for (int x = 1; x <= size; x++) {
                map[x][y] = Integer.parseInt(row[x - 1]);
            }
        }

        boolean[][] visited = new boolean[size + 1][size + 1];
        int[][] direction = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        // process
        int numberOfVillage = 1;
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                if (map[x][y] == 1 && !visited[x][y]) {
//                    int countOfHouse = dfs(x, y, size, map, visited, direction);
                    int countOfHouse = bfs(x, y, size, map, visited, direction);
                    resultMap.put(numberOfVillage, countOfHouse);
                    numberOfVillage++;
                }
            }
        }

        // output
        System.out.println(--numberOfVillage);

        List<Integer> resultList = new ArrayList<>();

        for (int village = 1; village <= numberOfVillage; village++) {
            resultList.add(resultMap.get(village));
        }
        resultList.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static int dfs(int x,
                           int y,
                           int size,
                           int[][] map,
                           boolean[][] visited,
                           int[][] direction) {
        visited[x][y] = true;
        int count = 1;

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + direction[dir][0];
            int newY = y + direction[dir][1];

            if (newX <= 0 || newX > size || newY <= 0 || newY > size) {
                continue;
            }

            if (visited[newX][newY]) {
                continue;
            }

            if (map[newX][newY] == 1) {
                visited[newX][newY] = true;
                count += dfs(newX, newY, size, map, visited, direction);
            }
        }

        return count;
    }

    private static int bfs(int startX,
                           int startY,
                           int size,
                           int[][] map,
                           boolean[][] visited,
                           int[][] direction) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        visited[startX][startY] = true;
        queue.offer(startX);
        queue.offer(startY);

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();
            count++;

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];

                if (newX <= 0 || newX > size || newY <= 0 || newY > size) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    queue.offer(newX);
                    queue.offer(newY);
                }
            }
        }

        return count;
    }
}