package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {

    private static int height;
    private static int width;
    private static int[][] startAndDestination = new int[2][2];
    private static char[][] map;
    private static int[][] waterDistance;
    private static int[][] hedgehogDistance;
    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static boolean[][] visited;
    private static Queue<Integer> waterQueue = new LinkedList<>();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new char[height][width];
        waterDistance = new int[height][width];
        hedgehogDistance = new int[height][width];
        visited = new boolean[height][width];

        for (int x = 0; x < height; x++) {
            String temp = br.readLine();

            for (int y = 0; y < width; y++) {
                map[x][y] = temp.charAt(y);

                if (map[x][y] == '*') {
                    waterQueue.add(x);
                    waterQueue.add(y);
                    visited[x][y] = true;
                    waterDistance[x][y] = 0;
                }

                if (map[x][y] == 'S') {
                    startAndDestination[0][0] = x;
                    startAndDestination[0][1] = y;
                }

                if (map[x][y] == 'D') {
                    startAndDestination[1][0] = x;
                    startAndDestination[1][1] = y;
                }
            }
        }
    }

    private static void process() {
        waterBfs();
        resetVisit();
        hedgehogBfs();
    }

    private static void resetVisit() {
//        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static void waterBfs() {
        // 데이터 입력 시 물의 좌표 큐에 넣고 visit check 함
        while (!waterQueue.isEmpty()) {
            int x = waterQueue.poll();
            int y = waterQueue.poll();
            int newX;
            int newY;

            for (int i = 0; i < 4; i++) {
                newX = x + direction[i][0];
                newY = y + direction[i][1];

                if (newX < 0 || newY < 0 || newX > height - 1 || newY > width - 1) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] == 'X' || map[newX][newY] == 'D') {
                    continue;
                }

                waterQueue.add(newX);
                waterQueue.add(newY);
                visited[newX][newY] = true;
                waterDistance[newX][newY] = waterDistance[x][y] + 1;
            }
        }
    }

    private static void hedgehogBfs() {
        Queue<Integer> queue = new LinkedList<>();
        int startX = startAndDestination[0][0];
        int startY = startAndDestination[0][1];

        queue.add(startX);
        queue.add(startY);
        visited[startX][startY] = true;
        hedgehogDistance[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            int newX;
            int newY;

            for (int i = 0; i < 4; i++) {
                newX = x + direction[i][0];
                newY = y + direction[i][1];

                if (newX < 0 || newY < 0 || newX > height - 1 || newY > width - 1) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] == 'X' || map[newX][newY] == '*') {
                    continue;
                }

                hedgehogDistance[newX][newY] = hedgehogDistance[x][y] + 1;

                // 지도에 물이 없는 경우 waterDistance 는 모두 0임
                if (waterDistance[newX][newY] != 0 && hedgehogDistance[newX][newY] >= waterDistance[newX][newY]) {
                    hedgehogDistance[newX][newY] = 0;
                    continue;
                }

                queue.add(newX);
                queue.add(newY);
                visited[newX][newY] = true;
            }
        }
    }

    private static void output() {
        int destinationX = startAndDestination[1][0];
        int destinationY = startAndDestination[1][1];
        int result = hedgehogDistance[destinationX][destinationY];

        if (result == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
