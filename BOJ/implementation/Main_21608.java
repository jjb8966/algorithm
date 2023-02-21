package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_21608 {

    static int n;
    static int result;
    static int[] students;
    static int[][] map;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<Integer>[] favorites;

    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int favorite;
        int empty;

        public Coordinate(int x, int y, int favorite, int empty) {
            this.x = x;
            this.y = y;
            this.favorite = favorite;
            this.empty = empty;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.favorite != o.favorite) {
                return o.favorite - this.favorite;
            }

            if (this.empty != o.empty) {
                return o.empty - this.empty;
            }

            if (this.y != o.y) {
                return this.y - o.y;
            }

            return this.x - o.x;
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

        n = Integer.parseInt(br.readLine());

        students = new int[(n * n) + 1];
        map = new int[n + 1][n + 1];
        favorites = new ArrayList[(n * n) + 1];

        for (int i = 1; i <= n * n; i++) {
            favorites[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());

            students[i] = student;

            for (int j = 0; j < 4; j++) {
                favorites[student].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    private static void process() {
        for (int index = 1; index <= n * n; index++) {
            findPosition(students[index]);
        }

        calculateSatisfaction();
    }

    private static void calculateSatisfaction() {
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                int student = map[x][y];
                int count = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int newX = x + direction[dir][0];
                    int newY = y + direction[dir][1];

                    if (newX <= 0 || newY <= 0 || newX > n || newY > n) {
                        continue;
                    }

                    if (favorites[student].contains(map[newX][newY])) {
                        count++;
                    }
                }

                if (count == 1) {
                    result += 1;
                }

                if (count == 2) {
                    result += 10;
                }

                if (count == 3) {
                    result += 100;
                }

                if (count == 4) {
                    result += 1000;
                }
            }
        }
    }

    private static void findPosition(int student) {
        Queue<Coordinate> queue = new PriorityQueue<>();
        int positionX;
        int positionY;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                int favorite = 0;
                int empty = 0;

                if (map[x][y] != 0) {
                    continue;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int newX = x + direction[dir][0];
                    int newY = y + direction[dir][1];

                    if (newX <= 0 || newY <= 0 || newX > n || newY > n) {
                        continue;
                    }

                    if (map[newX][newY] == 0) {
                        empty++;
                        continue;
                    }

                    if (favorites[student].contains(map[newX][newY])) {
                        favorite++;
                    }
                }

                queue.add(new Coordinate(x, y, favorite, empty));
            }
        }

        Coordinate coordinate = queue.peek();
        positionX = coordinate.x;
        positionY = coordinate.y;

        map[positionX][positionY] = student;
    }

    private static void output() {
        System.out.println(result);
    }

}