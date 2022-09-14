package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963 {

    private static int width;
    private static int height;
    private static int[][] map;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static boolean play;
    private static boolean[][] visited;
    private static int result;

    // 좌우, 위아래, 대각선
    private static int[][] direction = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public static void main(String[] args) throws IOException {
        inputWidthAndHeight();

        while (play) {
            input();
            process();
            output();

            inputWidthAndHeight();
        }
    }

    private static void checkPlay() {
        play = !(width == 0 && height == 0);
    }

    private static void inputWidthAndHeight() throws IOException {
        st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        checkPlay();
    }

    private static void input() throws IOException {
        map = new int[width][height];
        visited = new boolean[width][height];

        for (int y = 0; y < height; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < width; x++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        result = 0;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (visited[x][y] || map[x][y] == 0) {
                    continue;
                }

                dfs(x,y);
                result++;
            }
        }
    }

    private static void dfs(int startX, int startY) {
        int newX;
        int newY;

        visited[startX][startY] = true;

        for (int i = 0; i < 8; i++) {
            newX = startX + direction[i][0];
            newY = startY + direction[i][1];

            if (newX < 0 || newY < 0 || newX >= width || newY >= height) {
                continue;
            }

            if (map[newX][newY] == 0) {
                continue;
            }

            if (visited[newX][newY]) {
                continue;
            }

            dfs(newX, newY);
        }
    }

    private static void output() {
        System.out.println(result);
    }

}
