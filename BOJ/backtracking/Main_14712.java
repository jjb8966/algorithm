package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14712 {

    static int width;
    static int height;
    static int result;
    static int[][] map;

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

        map = new int[width + 1][height + 1];
    }

    private static void process() {
//        dfs(1, 1);
        dfs2(0);
    }

    private static void dfs(int x, int y) {
        int newX;
        int newY;

        if (x == 1 && y == height + 1) {
            result++;
            return;
        }

        if (x < width) {
            newX = x + 1;
            newY = y;
        } else {
            newX = 1;
            newY = y + 1;
        }

        // 2x2가 되는 경우 -> x,y는 채우지 않고 건너뜀
        if (map[x - 1][y] == 1 && map[x - 1][y - 1] == 1 && map[x][y - 1] == 1) {
            dfs(newX, newY);
            return;
        }

        // 2x2가 안되는 경우
        // 1. x,y 안채움
        dfs(newX, newY);

        // 2. x,y 채움
        map[x][y] = 1;
        dfs(newX, newY);
        map[x][y] = 0;
    }

    static void dfs2(int count) {
        if (count == height * width) {
            result++;
            return;
        }

        int x = count % width + 1;
        int y = count / width + 1;

        if (map[x - 1][y] == 1 && map[x - 1][y - 1] == 1 && map[x][y - 1] == 1) {
            dfs2(count + 1);
        } else {
            dfs2(count + 1);

            map[x][y] = 1;
            dfs2(count + 1);
            map[x][y] = 0;
        }
    }

    private static void output() {
        System.out.println(result);
    }

}