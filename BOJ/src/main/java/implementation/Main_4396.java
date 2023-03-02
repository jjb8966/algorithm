package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4396 {

    static int side;
    static int[][] direction = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},   // 상하좌우
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // 대각선
    };
    static char[][] map;
    static char[][] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        side = Integer.parseInt(br.readLine());

        map = new char[side][side];
        check = new char[side][side];

        for (int y = 0; y < side; y++) {
            String row = br.readLine();

            for (int x = 0; x < side; x++) {
                map[x][y] = row.charAt(x);
            }
        }

        for (int y = 0; y < side; y++) {
            String row = br.readLine();

            for (int x = 0; x < side; x++) {
                check[x][y] = row.charAt(x);
            }
        }
    }

    private static void process() {
        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                int count = 0;

                if (check[x][y] == '.') {
                    continue;
                }

                if (map[x][y] == '*') {
                    showAllStar();
                    continue;
                }

                for (int dir = 0; dir < 8; dir++) {
                    int newX = x + direction[dir][0];
                    int newY = y + direction[dir][1];

                    if (newX < 0 || newY < 0 || newX >= side || newY >= side) {
                        continue;
                    }

                    if (map[newX][newY] == '*') {
                        count++;
                    }
                }

                check[x][y] = (char) (count + '0');
            }
        }

        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                sb.append(check[x][y]);
            }
            sb.append('\n');
        }
    }

    private static void showAllStar() {
        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                if (map[x][y] == '*') {
                    check[x][y] = '*';
                }
            }
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}