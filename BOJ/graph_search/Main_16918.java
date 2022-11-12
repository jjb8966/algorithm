package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16918 {

    private static int height;
    private static int width;
    private static int time;
    private static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //위, 아래, 왼쪽, 오른쪽
    private static char[][] map;
    private static boolean[][] existBomb;
    private static ArrayList<Coordinate> seeds = new ArrayList<>();

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
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
        time = Integer.parseInt(st.nextToken());

        map = new char[height][width];
        existBomb = new boolean[height][width];

        for (int x = 0; x < height; x++) {
            String[] oneRow = br.readLine().split("");

            for (int y = 0; y < width; y++) {
                map[x][y] = oneRow[y].charAt(0);
            }
        }
    }

    private static void process() {
        findSeed();

        for (int i = 1; i <= time; i++) {
            int play = i % 2;

            if (play == 0) {
                fillBomb();
            }

            if (play == 1 && i != 1) {
                for (Coordinate seed : seeds) {
                    explodeBomb(seed);
                }

                seeds = new ArrayList<>();

                findSeed();
            }
        }
    }

    private static void findSeed() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (map[x][y] == 'O') {
                    seeds.add(new Coordinate(x, y));
                }
            }
        }
    }

    private static void fillBomb() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                existBomb[x][y] = true;
                map[x][y] = 'O';
            }
        }
    }

    private static void explodeBomb(Coordinate seed) {
        int x = seed.x;
        int y = seed.y;

        existBomb[x][y] = false;
        map[x][y] = '.';

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + direction[dir][0];
            int newY = y + direction[dir][1];

            if (newX < 0 || newY < 0 || newX >= height || newY >= width) {
                continue;
            }

            if (!existBomb[newX][newY]) {
                continue;
            }

            existBomb[newX][newY] = false;
            map[newX][newY] = '.';
        }
    }

    private static void output() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                System.out.print(map[x][y]);
            }
            System.out.println();
        }
    }
}
