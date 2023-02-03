package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {

    static int width;
    static int height;
    static int layer;
    static int result;
    static int[][][] map;
    static int[][] direction = {
            {0, 0, 1}, {0, 0, -1},      // 위, 아래
            {1, 0, 0}, {-1, 0, 0},      // 오른쪽, 왼쪽
            {0, 1, 0}, {0, -1, 0}       // 앞, 뒤
    };
    static boolean[][][] visited;
    static Queue<Tomato> queue = new LinkedList<>();

    static class Tomato {
        int x;
        int y;
        int z;
        int day;

        public Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        layer = Integer.parseInt(st.nextToken());

        map = new int[width][height][layer];
        visited = new boolean[width][height][layer];

        for (int z = 0; z < layer; z++) {
            for (int y = 0; y < height; y++) {
                st = new StringTokenizer(br.readLine());

                for (int x = 0; x < width; x++) {
                    map[x][y][z] = Integer.parseInt(st.nextToken());

                    if (map[x][y][z] == 1) {
                        visited[x][y][z] = true;
                        queue.offer(new Tomato(x, y, z, 0));
                    }

                    if (map[x][y][z] == -1) {
                        visited[x][y][z] = true;
                    }
                }
            }
        }
    }

    private static void process() {
        if (allVisit()) {
            result = 0;
            return;
        }

        bfs();

        if (!allVisit()) {
            result = -1;
        }
    }

    private static boolean allVisit() {
        for (int z = 0; z < layer; z++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (!visited[x][y][z]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            int x = tomato.x;
            int y = tomato.y;
            int z = tomato.z;
            int day = tomato.day;

            result = Math.max(result, day);

            for (int dir = 0; dir < 6; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];
                int newZ = z + direction[dir][2];

                if (newX < 0 || newY < 0 || newZ < 0 || newX >= width || newY >= height || newZ >= layer) {
                    continue;
                }

                if (visited[newX][newY][newZ]) {
                    continue;
                }

                visited[newX][newY][newZ] = true;
                queue.add(new Tomato(newX, newY, newZ, day + 1));
            }
        }
    }

    private static void output() {
        System.out.println(result);
    }

}