package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3184 {

    private static int width;
    private static int height;
    private static char[][] map;
    private static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[][] visited;
    private static int numberOfLiveSheep;
    private static int numberOfLiveWolves;

    static class NumberOfAnimal {
        private int sheep;
        private int wolves;

        public int getSheep() {
            return sheep;
        }

        public int getWolves() {
            return wolves;
        }

        public void plusSheep() {
            sheep++;
        }

        public void plusWolves() {
            wolves++;
        }

        public boolean isZero() {
            return sheep == 0 && wolves == 0;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new char[width][height];
        visited = new boolean[width][height];

        for (int y = 0; y < height; y++) {
            String[] line = br.readLine().split("");

            for (int x = 0; x < width; x++) {
                map[x][y] = line[x].charAt(0);
            }
        }
    }

    private static void process() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (!visited[x][y] && map[x][y] != '#') {
                    NumberOfAnimal numberOfAnimal = new NumberOfAnimal();

                    dfs(x, y, numberOfAnimal);

                    updateResult(numberOfAnimal);
                }
            }
        }
    }

    private static void dfs(int startX, int startY, NumberOfAnimal numberOfAnimal) {
        int newX;
        int newY;
        char vertex = map[startX][startY];

        visited[startX][startY] = true;

        updateAnimal(numberOfAnimal, vertex);

        for (int i = 0; i < 4; i++) {
            newX = startX + direction[i][0];
            newY = startY + direction[i][1];

            if (!canGo(newX, newY)) {
                continue;
            }

            dfs(newX, newY, numberOfAnimal);
        }
    }

    private static boolean canGo(int newX, int newY) {
        if (newX < 0 || newY < 0 || newX >= width || newY >= height) {
            return false;
        }

        if (map[newX][newY] == '#') {
            return false;
        }

        if (visited[newX][newY]) {
            return false;
        }

        return true;
    }

    private static void updateAnimal(NumberOfAnimal numberOfAnimal, char vertex) {
        if (vertex == 'o') {
            numberOfAnimal.plusSheep();
        }

        if (vertex == 'v') {
            numberOfAnimal.plusWolves();
        }
    }

    private static void updateResult(NumberOfAnimal numberOfAnimal) {
        int numberOfSheep = numberOfAnimal.getSheep();
        int numberOfWolves = numberOfAnimal.getWolves();

        if (!numberOfAnimal.isZero()) {
            if (numberOfSheep > numberOfWolves) {
                numberOfLiveSheep += numberOfSheep;
            } else {
                numberOfLiveWolves += numberOfWolves;
            }
        }
    }

    private static void output() {
        System.out.println(numberOfLiveSheep + " " + numberOfLiveWolves);
    }

}
