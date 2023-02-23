package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5547 {

    private static int height;
    private static int width;
    private static int result;
    private static int[][] map;
    private static int[][] oddDirection = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {1, 1}};
    private static int[][] evenDirection = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}};
    private static boolean[][] visited;
    private static boolean[][] isOuterWall;

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

        map = new int[height + 1][width + 1];
        visited = new boolean[height + 1][width + 1];
        isOuterWall = new boolean[height + 1][width + 1];

        for (int y = 1; y <= height; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 1; x <= width; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        updateOuterWall();

        visited = new boolean[height + 1][width + 1];

        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                if (visited[y][x]) {
                    continue;
                }

                if (map[y][x] == 0) {
                    continue;
                }

                calculateWall(y, x);
            }
        }
    }

    private static void calculateWall(int y, int x) {
        visited[y][x] = true;

        for (int dir = 0; dir < 6; dir++) {
            int newX;
            int newY;

            if (y % 2 == 0) {
                newX = x + evenDirection[dir][0];
                newY = y + evenDirection[dir][1];
            } else {
                newX = x + oddDirection[dir][0];
                newY = y + oddDirection[dir][1];
            }

            if (newX <= 0 || newY <= 0 || newX > width || newY > height) {
                result++;
                continue;
            }

            if (visited[newY][newX]) {
                continue;
            }

            if (map[newY][newX] == 0) {
                if (isOuterWall[newY][newX]) {
                    result++;
                }

                continue;
            }

            calculateWall(newY, newX);
        }
    }

    private static void updateOuterWall() {
        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                if (visited[y][x]) {
                    continue;
                }

                if (map[y][x] == 1) {
                    continue;
                }

                checkOuterWall(y, x);
            }
        }
    }

    private static void checkOuterWall(int y, int x) {
        for (int dir = 0; dir < 6; dir++) {
            int newX;
            int newY;

            if (y % 2 == 0) {
                newX = x + evenDirection[dir][0];
                newY = y + evenDirection[dir][1];
            } else {
                newX = x + oddDirection[dir][0];
                newY = y + oddDirection[dir][1];
            }

            if (newX <= 0 || newY <= 0 || newX > width || newY > height) {
                isOuterWall[y][x] = true;
                break;
            }
        }

        if (isOuterWall[y][x]) {
            propagate(y, x);
        }
    }

    private static void propagate(int y, int x) {
        visited[y][x] = true;

        for (int dir = 0; dir < 6; dir++) {
            int newX;
            int newY;

            if (y % 2 == 0) {
                newX = x + evenDirection[dir][0];
                newY = y + evenDirection[dir][1];
            } else {
                newX = x + oddDirection[dir][0];
                newY = y + oddDirection[dir][1];
            }

            if (newX <= 0 || newY <= 0 || newX > width || newY > height) {
                continue;
            }

            if (visited[newY][newX]) {
                continue;
            }

            if (map[newY][newX] == 1) {
                continue;
            }

            isOuterWall[newY][newX] = true;
            propagate(newY, newX);  // 이 부분을 쓰지 않아서 계속 틀림!
        }
    }

    private static void output() {
        System.out.println(result);
    }

}
