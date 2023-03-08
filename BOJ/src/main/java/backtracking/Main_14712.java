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
        backtracking(1);
    }

    private static void backtracking(int count) {
        if (count == (height * width) + 1) {
            result++;
            return;
        }

        int x = (count - 1) % width + 1;
        int y = (count - 1) / width + 1;

        if (map[x - 1][y] == 1 && map[x - 1][y - 1] == 1 && map[x][y - 1] == 1) {
            backtracking(count + 1);
            return;
        }

        // 칸을 채우지 않는 경우
        backtracking(count + 1);

        // 칸을 채우는 경우
        map[x][y] = 1;
        backtracking(count + 1);
        map[x][y] = 0;
    }

    private static void output() {
        System.out.println(result);
    }

}