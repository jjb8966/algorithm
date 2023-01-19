package search;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    int minDistance;
    int width;
    int height;
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited;

    static class Coordinate {
        int x;
        int y;
        int distance;

        public Coordinate(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int solution(int[][] maps) {
        height = maps.length;
        width = maps[0].length;

        visited = new boolean[width][height];

        bfs(maps);

        return minDistance == 0 ? -1 : minDistance;
    }

    private void bfs(int[][] maps) {
        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(new Coordinate(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            int x = coordinate.x;
            int y = coordinate.y;
            int distance = coordinate.distance;

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];

                if (newX < 0 || newY < 0 || newX >= width || newY >= height) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (maps[newY][newX] == 0) {
                    continue;
                }

                if (newX == width - 1 && newY == height - 1) {
                    minDistance = distance + 1;
                    return;
                }

                queue.add(new Coordinate(newX, newY, distance + 1));
                visited[newX][newY] = true;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 prob = new Solution2();

        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int[][] maps2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        System.out.println(prob.solution(maps));
    }

}