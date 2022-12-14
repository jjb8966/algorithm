package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_3055 {

    private static int height;
    private static int width;
    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][] waterMinDistance;
    private static int[][] hedgehogMinDistance;
    private static char[][] map;
    private static boolean[][] visited;
    private static Coordinate start;
    private static Coordinate destination;
    private static Queue<Coordinate> waterQueue = new LinkedList<>();
    private static StringBuilder sb = new StringBuilder();

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

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

        map = new char[width + 1][height + 1];
        waterMinDistance = new int[width + 1][height + 1];
        hedgehogMinDistance = new int[width + 1][height + 1];
        visited = new boolean[width + 1][height + 1];

        for (int y = 1; y <= height; y++) {
            temp = br.readLine().split("");

            for (int x = 1; x <= width; x++) {
                map[x][y] = temp[x - 1].charAt(0);

                if (map[x][y] == 'S') {
                    start = new Coordinate(x, y);
                }

                if (map[x][y] == 'D') {
                    destination = new Coordinate(x, y);
                }

                if (map[x][y] == '*') {
                    waterQueue.add(new Coordinate(x, y));
                    waterMinDistance[x][y] = 0;
                    visited[x][y] = true;
                }
            }
        }

    }

    private static void process() {
        bfsWater();
        bfsHedgehog();

        if (hedgehogMinDistance[destination.x][destination.y] == 0) {
            sb.append("KAKTUS");
        } else {
            sb.append(hedgehogMinDistance[destination.x][destination.y]);
        }
    }

    private static void bfsWater() {
        while (!waterQueue.isEmpty()) {
            Coordinate water = waterQueue.poll();
            int x = water.x;
            int y = water.y;

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];

                if (newX <= 0 || newY <= 0 || newX > width || newY > height) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] != '.') {
                    continue;
                }

                waterMinDistance[newX][newY] = waterMinDistance[x][y] + 1;
                visited[newX][newY] = true;
                waterQueue.add(new Coordinate(newX, newY));
            }
        }
    }

    private static void bfsHedgehog() {
        Queue<Coordinate> queue = new LinkedList<>();
        visited = new boolean[width + 1][height + 1];

        queue.add(start);
        hedgehogMinDistance[start.x][start.y] = 0;
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Coordinate hedgehog = queue.poll();
            int x = hedgehog.x;
            int y = hedgehog.y;

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];

                if (newX <= 0 || newY <= 0 || newX > width || newY > height) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] == 'X' || map[newX][newY] == '*') {
                    continue;
                }

                if (waterMinDistance[newX][newY] != 0 && (hedgehogMinDistance[x][y] + 1 >= waterMinDistance[newX][newY])) {
                    continue;
                }

                hedgehogMinDistance[newX][newY] = hedgehogMinDistance[x][y] + 1;
                visited[newX][newY] = true;
                queue.add(new Coordinate(newX, newY));
            }
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}