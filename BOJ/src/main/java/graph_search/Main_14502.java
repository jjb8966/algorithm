package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14502 {

    private static int height;
    private static int width;
    private static int maxSafeArea = Integer.MIN_VALUE;
    private static int[][] map;
    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height + 1][width + 1];

        for (int y = 1; y <= height; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 1; x <= width; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        buildWall(0, 1);
    }

    private static void buildWall(int countWall, int previousY) {
        if (countWall > 2) {
            int safeArea = countSafeArea();

            if (safeArea > maxSafeArea) {
                maxSafeArea = safeArea;
            }
        } else {
            for (int y = previousY; y <= height; y++) {
                for (int x = 1; x <= width; x++) {
                    if (map[y][x] == 1 || map[y][x] == 2) {
                        continue;
                    }

                    map[y][x] = 1;

                    buildWall(countWall + 1, y);

                    map[y][x] = 0;
                }
            }
        }
    }

    private static int countSafeArea() {
        int[][] updatedMap = new int[height + 1][width + 1];
        int result = 0;

        for (int row = 1; row <= height; row++) {
            updatedMap[row] = map[row].clone();
        }

        spreadVirus(updatedMap);

        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                if (updatedMap[y][x] == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    private static void spreadVirus(int[][] updatedMap) {
        boolean[][] visited = new boolean[height + 1][width + 1];

        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                if (visited[y][x]) {
                    continue;
                }

                if (updatedMap[y][x] == 0 || updatedMap[y][x] == 1) {
                    continue;
                }

                dfs(x, y, updatedMap, visited);
            }
        }
    }

    private static void dfs(int x, int y, int[][] updatedMap, boolean[][] visited) {
        visited[y][x] = true;

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + direction[dir][0];
            int newY = y + direction[dir][1];

            if (newX <= 0 || newY <= 0 || newX > width || newY > height) {
                continue;
            }

            if (visited[newY][newX]) {
                continue;
            }

            if (updatedMap[newY][newX] == 1 || updatedMap[newY][newX] == 2) {
                continue;
            }

            updatedMap[newY][newX] = 2;

            dfs(newX, newY, updatedMap, visited);
        }
    }

    private static void output() {
        System.out.println(maxSafeArea);
    }

}