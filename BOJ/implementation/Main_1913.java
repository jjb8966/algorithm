package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1913 {

    static int number;
    static int targetNumber;
    static int currentNumber = 1;
    static int[][] map;
    static Coordinate currentCoordinate;
    static Coordinate targetCoordinate;
    static StringBuilder sb = new StringBuilder();

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        number = Integer.parseInt(br.readLine());
        targetNumber = Integer.parseInt(br.readLine());

        map = new int[number + 1][number + 1];
    }

    private static void process() {
        int center = (number / 2) + 1;

        map[center][center] = currentNumber++;
        currentCoordinate = new Coordinate(center, center);

        for (int n = 3; n <= number; n += 2) {
            drawMap(n);
        }
    }

    private static void drawMap(int n) {
        int countRight = n - 2;
        int count = n - 1;

        //up
        move(1, () -> currentCoordinate.y--);

        //right
        move(countRight, () -> currentCoordinate.x++);

        //down
        move(count, () -> currentCoordinate.y++);

        //left
        move(count, () -> currentCoordinate.x--);

        //up
        move(count, () -> currentCoordinate.y--);
    }

    private static void move(int count, Runnable runnable) {
        for (int i = 0; i < count; i++) {
            runnable.run();

            if (currentNumber == targetNumber) {
                targetCoordinate = new Coordinate(currentCoordinate.x, currentCoordinate.y);
            }

            map[currentCoordinate.x][currentCoordinate.y] = currentNumber++;
        }
    }

    private static void output() {
        for (int y = 1; y <= number; y++) {
            for (int x = 1; x <= number; x++) {
                sb.append(map[x][y] + " ");

                if (map[x][y] == targetNumber) {
                    targetCoordinate = new Coordinate(x, y);
                }
            }

            sb.append('\n');
        }

        sb.append(targetCoordinate.y).append(" ").append(targetCoordinate.x);

        System.out.println(sb);
    }

}