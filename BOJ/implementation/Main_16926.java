package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926 {

    static int width;
    static int height;
    static int numberOfRotation;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

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
        numberOfRotation = Integer.parseInt(st.nextToken());

        map = new int[width + 1][height + 1];

        for (int y = 1; y <= height; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 1; x <= width; x++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        for (int i = 0; i < numberOfRotation; i++) {
            rotate();
        }
    }

    private static void rotate() {
        int[][] tempMap = new int[width + 1][height + 1];
        int left = 1;
        int right = width;
        int top = 1;
        int bottom = height;

        while ((left < right) && (top < bottom)) {
            // top
            // 1. down
            tempMap[left][top + 1] = map[left][top];

            // 2. left
            for (int x = left + 1; x <= right; x++) {
                tempMap[x - 1][top] = map[x][top];
            }

            // middle
            for (int y = top + 1; y < bottom; y++) {
                tempMap[left][y + 1] = map[left][y];
                tempMap[right][y - 1] = map[right][y];
            }

            // bottom
            // 1. up
            tempMap[right][bottom - 1] = map[right][bottom];

            // 2. right
            for (int x = left; x < right; x++) {
                tempMap[x + 1][bottom] = map[x][bottom];
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        map = tempMap;
    }

    private static void output() {
        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                sb.append(map[x][y]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}