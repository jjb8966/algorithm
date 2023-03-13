package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_20436 {

    static char startLeft;
    static char startRight;
    static char[][] keyboard = {
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ' '},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm', ' ', ' ', ' '}
    };
    static int result;
    static int[] leftCoordinate = new int[2];
    static int[] rightCoordinate = new int[2];
    static boolean[][] isLeft = new boolean[10][3];
    static String targetExp;
    static Map<Character, int[]> keyboardMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 10; col++) {
                if (keyboard[row][col] == ' ') {
                    continue;
                }

                keyboardMap.put(keyboard[row][col], new int[]{col, row});

                if (row < 2 && col < 5) {
                    isLeft[col][row] = true;
                }

                if (row == 2 && col < 4) {
                    isLeft[col][row] = true;
                }
            }
        }

        String[] characters = br.readLine().split(" ");
        startLeft = characters[0].charAt(0);
        startRight = characters[1].charAt(0);

        targetExp = br.readLine();

        leftCoordinate = keyboardMap.get(startLeft);
        rightCoordinate = keyboardMap.get(startRight);
    }

    private static void process() {
        int length = targetExp.length();

        for (int i = 0; i < length; i++) {
            char targetChar = targetExp.charAt(i);
            int distance;
            int time;

            distance = calculateDistance(targetChar);
            time = distance + 1;
            result += time;
        }
    }

    private static int calculateDistance(char targetChar) {
        int distance;
        int[] coordinate = keyboardMap.get(targetChar);

        if (isLeft[coordinate[0]][coordinate[1]]) {
            distance = Math.abs(leftCoordinate[0] - coordinate[0]) + Math.abs(leftCoordinate[1] - coordinate[1]);
            leftCoordinate = coordinate;
        } else {
            distance = Math.abs(rightCoordinate[0] - coordinate[0]) + Math.abs(rightCoordinate[1] - coordinate[1]);
            rightCoordinate = coordinate;
        }

        return distance;
    }

    private static void output() {
        System.out.println(result);
    }

}