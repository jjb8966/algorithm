package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2178 {

    private static int height;
    private static int width;
    private static int[][] map;
    private static int[][] minimumDistance;
    private static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        height = Integer.parseInt(temp[0]);
        width = Integer.parseInt(temp[1]);

        map = new int[width + 1][height + 1];
        minimumDistance = new int[width + 1][height + 1];
        visited = new boolean[width + 1][height + 1];

        for (int y = 1; y <= height; y++) {
            temp = br.readLine().split("");

            for (int x = 1; x <= width; x++) {
                map[x][y] = Integer.parseInt(temp[x - 1]);
            }
        }
    }

    private static void process() {
        bfs(1, 1);
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startX);
        queue.add(startY);
        minimumDistance[startX][startY] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];

                if (newX <= 0 || newY <= 0 || newX > width || newY > height) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] == 0) {
                    continue;
                }

                queue.add(newX);
                queue.add(newY);
                visited[newX][newY] = true;
                minimumDistance[newX][newY] = minimumDistance[x][y] + 1;
            }
        }
    }

    private static void output() {
        System.out.println(minimumDistance[width][height]);
    }

}