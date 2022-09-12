package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int testCase;
    private static int width;
    private static int height;
    private static int numberOfPoint;
    private static int map[][];
    private static int direction[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int result;
    private static boolean visited[][];

    public static void main(String[] args) throws IOException {
        testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();
            process();
            output();
            result = 0;
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        numberOfPoint = Integer.parseInt(st.nextToken());

        map = new int[width][height];
        visited = new boolean[width][height];

        for (int i = 0; i < numberOfPoint; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }
    }

    private static void process() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (!visited[x][y] && map[x][y] == 1) {
                    result++;
                    dfs(x, y);
                }
            }
        }
    }

    private static void dfs(int startX, int startY) {
        visited[startX][startY] = true;

        int newX;
        int newY;

        for (int i = 0; i < 4; i++) {
            newX = startX + direction[i][0];
            newY = startY + direction[i][1];

            if (newX < 0 || newY < 0 || newX >= width || newY >= height) {
                continue;
            }

            if (visited[newX][newY]) {
                continue;
            }

            if (map[newX][newY] != 1) {
                continue;
            }

            dfs(newX, newY);
        }
    }

    private static void output() {
        System.out.println(result);
    }

}
