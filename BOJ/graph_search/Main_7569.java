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
    static Queue<Integer> seed = new LinkedList<>();

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
                        seed.offer(x);
                        seed.offer(y);
                        seed.offer(z);
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
        Queue<Integer> queue = new LinkedList<>();

        while (!seed.isEmpty()) {
            Integer seedX = seed.poll();
            Integer seedY = seed.poll();
            Integer seedZ = seed.poll();

            visited[seedX][seedY][seedZ] = true;

            queue.offer(seedX);
            queue.offer(seedY);
            queue.offer(seedZ);
            queue.offer(0);
        }

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();
            Integer z = queue.poll();
            Integer day = queue.poll();

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
                queue.add(newX);
                queue.add(newY);
                queue.add(newZ);
                queue.add(day + 1);
            }
        }
    }

    private static void output() {
        System.out.println(result);
    }

}