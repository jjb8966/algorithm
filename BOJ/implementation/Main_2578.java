package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2578 {

    static int countBingo = 0;
    static int result;
    static int[] call = new int[25];
    static boolean[] row = new boolean[6];
    static boolean[] column = new boolean[6];
    static boolean[] diagonal = new boolean[2];
    static boolean[][] check = new boolean[6][6];
    static Map<Integer, int[]> numberMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int y = 1; y <= 5; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 1; x <= 5; x++) {
                int number = Integer.parseInt(st.nextToken());
                numberMap.put(number, new int[]{x, y});
            }
        }

        int index = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                call[index++] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        for (int i = 0; i < 25; i++) {
            if (countBingo >= 3) {
                result = i;
                return;
            }

            int[] coordinate = numberMap.get(call[i]);
            int x = coordinate[0];
            int y = coordinate[1];

            check[x][y] = true;

            checkBingo(x, y);
        }
    }

    private static void checkBingo(int x, int y) {
        if (!column[x]) {
            checkColumn(x);
        }

        if (!row[y]) {
            checkRow(y);
        }

        if (x == y && !diagonal[0]) {
            checkLeftDiagonal();
        }

        if ((x + y) == 6 && !diagonal[1]) {
            checkRightDiagonal();
        }
    }

    private static void checkColumn(int x) {
        for (int y = 1; y <= 5; y++) {
            if (!check[x][y]) {
                return;
            }
        }

        countBingo++;
        column[x] = true;
    }

    private static void checkRow(int y) {
        for (int x = 1; x <= 5; x++) {
            if (!check[x][y]) {
                return;
            }
        }

        countBingo++;
        row[y] = true;
    }

    private static void checkLeftDiagonal() {
        for (int n = 1; n <= 5; n++) {
            if (!check[n][n]) {
                return;
            }
        }

        countBingo++;
        diagonal[0] = true;
    }

    private static void checkRightDiagonal() {
        int x = 1;
        int y = 5;

        for (int i = 0; i < 4; i++) {
            if (!check[x][y]) {
                return;
            }

            x++;
            y--;
        }

        countBingo++;
        diagonal[1] = true;
    }

    private static void output() {
        System.out.println(result);
    }

}