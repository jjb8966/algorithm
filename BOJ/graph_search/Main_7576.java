package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {

    private static int width;
    private static int height;
    private static int result;
    private static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};  // 위,아래,오른쪽,왼쪽
    private static int[][] adjacencyMatrix;
    private static boolean[][] visited;
    private static ArrayList<Coordinate> seeds = new ArrayList<>();

    static class Coordinate {
        int x;
        int y;
        int count;

        public Coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
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
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        adjacencyMatrix = new int[height + 1][width + 1];
        visited = new boolean[height + 1][width + 1];

        for (int x = 1; x <= height; x++) {
            st = new StringTokenizer(br.readLine());

            for (int y = 1; y <= width; y++) {
                adjacencyMatrix[x][y] = Integer.parseInt(st.nextToken());

                if (adjacencyMatrix[x][y] == 1) {
                    seeds.add(new Coordinate(x, y, 0));
                    visited[x][y] = true;
                }

                if (adjacencyMatrix[x][y] == -1) {
                    visited[x][y] = true;
                }
            }
        }

    }

    private static void process() {
        if (allVisit()) {
            result = 0;
            return;
        }

        bfs();

        if (!allVisit()) {
            result = -1;
        }
    }

    private static void bfs() {
        Queue<Coordinate> queue = new LinkedList<>();

        seeds.stream().forEach(seed -> queue.add(seed));

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            int x = coordinate.x;
            int y = coordinate.y;
            result = coordinate.count;

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];

                if (newX <= 0 || newY <= 0 || newX > height || newY > width) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (adjacencyMatrix[newX][newY] == -1) {
                    continue;
                }

                queue.add(new Coordinate(newX, newY, coordinate.count + 1));
                visited[newX][newY] = true;
            }
        }
    }

    private static boolean allVisit() {
        for (int x = 1; x <= height; x++) {
            for (int y = 1; y <= width; y++) {
                if (!visited[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void output() {
        System.out.println(result);
    }

}
