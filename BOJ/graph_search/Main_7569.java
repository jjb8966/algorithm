package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_7569 {

    private static int width;
    private static int height;
    private static int layer;
    private static int result;
    private static int[][] direction = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}}; //위,아래,뒤,앞,왼쪽,오른쪽
    private static int[][][] adjacencyMatrix;
    private static boolean[][][] visited;
    private static ArrayList<Coordinate> seeds = new ArrayList<>();

    static class Coordinate {
        int z;
        int x;
        int y;
        int count;

        public Coordinate(int z, int x, int y, int count) {
            this.z = z;
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
        layer = Integer.parseInt(st.nextToken());

        adjacencyMatrix = new int[layer + 1][height + 1][width + 1];
        visited = new boolean[layer + 1][height + 1][width + 1];

        for (int z = 1; z <= layer; z++) {
            for (int x = 1; x <= height; x++) {
                st = new StringTokenizer(br.readLine());

                for (int y = 1; y <= width; y++) {
                    adjacencyMatrix[z][x][y] = Integer.parseInt(st.nextToken());

                    if (adjacencyMatrix[z][x][y] == 1) {
                        seeds.add(new Coordinate(z, x, y, 0));
                        visited[z][x][y] = true;
                    }

                    if (adjacencyMatrix[z][x][y] == -1) {
                        visited[z][x][y] = true;
                    }
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
            int z = coordinate.z;
            int x = coordinate.x;
            int y = coordinate.y;
            result = coordinate.count;

            for (int dir = 0; dir < 6; dir++) {
                int newZ = z + direction[dir][0];
                int newX = x + direction[dir][1];
                int newY = y + direction[dir][2];

                if (newZ <= 0 || newX <= 0 || newY <= 0 || newZ > layer || newX > height || newY > width) {
                    continue;
                }

                if (visited[newZ][newX][newY]) {
                    continue;
                }

                if (adjacencyMatrix[newZ][newX][newY] == -1) {
                    continue;
                }

                queue.add(new Coordinate(newZ, newX, newY, coordinate.count + 1));
                visited[newZ][newX][newY] = true;
            }
        }
    }

    private static boolean allVisit() {
        for (int z = 1; z <= layer; z++) {
            for (int x = 1; x <= height; x++) {
                for (int y = 1; y <= width; y++) {
                    if (!visited[z][x][y]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static void output() {
        System.out.println(result);
    }

}