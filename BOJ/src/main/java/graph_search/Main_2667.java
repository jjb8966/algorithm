package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667 {

    static int size;
    static int[][] map;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        visited = new boolean[size][size];

        for (int y = 0; y < size; y++) {
            String[] row = br.readLine().split("");

            for (int x = 0; x < size; x++) {
                map[x][y] = Integer.parseInt(row[x]);
            }
        }
    }

    private static void process() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (visited[x][y]) {
                    continue;
                }

                if (map[x][y] == 0) {
                    continue;
                }

//                int count = dfs(x, y);
                int count = bfs(x, y);

                result.add(count);
            }
        }

        sb.append(result.size()).append('\n');
        result.stream()
                .sorted()
                .forEach(r -> sb.append(r).append('\n'));
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + direction[dir][0];
            int newY = y + direction[dir][1];

            if (newX < 0 || newY < 0 || newX >= size || newY >= size) {
                continue;
            }

            if (visited[newX][newY]) {
                continue;
            }

            if (map[newX][newY] == 0) {
                continue;
            }

            count += dfs(newX, newY);
        }

        return count;
    }

    private static int bfs(int startX, int startY) {
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

                if (newX < 0 || newY < 0 || newX >= size || newY >= size) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] == 0) {
                    continue;
                }

                visited[newX][newY] = true;
                queue.offer(newX);
                queue.offer(newY);
            }
        }

        return count;
    }

    private static void output() {
        System.out.println(sb);
    }

}