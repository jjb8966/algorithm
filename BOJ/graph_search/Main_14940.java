package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940 {

    private static int height;
    private static int width;
    private static int[][] map;
    private static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int[][] distance;
    private static boolean[][] wall;
    private static boolean[][] visited;
    private static Coordinate start;
    private static StringBuilder sb = new StringBuilder();

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
        distance = new int[height + 1][width + 1];
        wall = new boolean[height + 1][width + 1];
        visited = new boolean[height + 1][width + 1];

        for (int x = 1; x <= height; x++) {
            st = new StringTokenizer(br.readLine());

            for (int y = 1; y <= width; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());

                if (map[x][y] == 0) {
                    wall[x][y] = true;
                }

                if (map[x][y] == 2) {
                    start = new Coordinate(x, y, 0);
                }
            }
        }
    }

    private static void process() {
        bfs();
    }

    private static void bfs() {
        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(start);
        distance[start.x][start.y] = 0;
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Coordinate vertex = queue.poll();
            int x = vertex.x;
            int y = vertex.y;

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];

                if (newX <= 0 || newY <= 0 || newX > height || newY > width) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] == 0) {
                    continue;
                }

                visited[newX][newY] = true;
                distance[newX][newY] = vertex.distance + 1;
                queue.add(new Coordinate(newX, newY, vertex.distance + 1));
            }
        }
    }

    private static void output() {
        for (int x = 1; x <= height; x++) {
            for (int y = 1; y <= width; y++) {
                if (distance[x][y] == 0 && !wall[x][y] && (x != start.x || y != start.y)) {
                    distance[x][y] = -1;
                }

                sb.append(distance[x][y]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}
