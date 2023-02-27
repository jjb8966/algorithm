package implementation;

import java.io.*;
import java.util.*;

public class Main_10994 {

    static int number;
    static int side;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());

        side = 1 + 4 * (number - 1);

        map = new char[side][side];

        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                map[x][y] = ' ';
            }
        }
    }

    private static void process() {
        int middle = side / 2;
        int left = 0;
        int right = side - 1;

        for (int y = 0; y <= middle; y++) {
            if (y % 2 == 0) {
                for (int x = left; x <= right; x++) {
                    map[x][y] = '*';
                }

                drawOutside(left, right, y);
            }

            if (y % 2 != 0) {
                map[left][y] = '*';
                map[right][y] = '*';

                drawOutside(left, right, y);

                left += 2;
                right -= 2;
            }
        }

        for (int y = middle + 1; y < side; y++) {
            int gap = y - middle;

            for (int x = 0; x < side; x++) {
                map[x][y] = map[x][middle - gap];
            }
        }

        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                sb.append(map[x][y]);
            }
            sb.append('\n');
        }
    }

    private static void drawOutside(int left, int right, int y) {
        int tempLeft = left;
        int tempRight = right;

        while ((tempLeft - 2) >= 0 && (tempRight + 2) < side) {
            tempLeft -= 2;
            tempRight += 2;

            map[tempLeft][y] = '*';
            map[tempRight][y] = '*';
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}