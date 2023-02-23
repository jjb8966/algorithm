package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719 {

    static int height;
    static int width;
    static int result;
    static int[] blocks;
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

        blocks = new int[width];
        map = new int[width][height];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < width; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        drawMap();

        for (int y = 0; y < height; y++) {
            int left = -1;
            int right;

            for (int x = 0; x < width; x++) {
                if (map[x][y] == 1 && left == -1) {
                    left = x;
                    continue;
                }

                if (map[x][y] == 1 && left != -1) {
                    right = x;
                    result += right - left - 1;
                    left = right;
                }
            }
        }
    }

    private static void drawMap() {
        for (int x = 0; x < width; x++) {
            int block = blocks[x];
            int y = height - 1;

            for (int count = 0; count < block; count++) {
                map[x][y] = 1;
                y--;
            }
        }
    }

    private static void output() {
        System.out.println(result);
    }

}