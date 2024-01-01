package graph_search;

import java.io.*;
import java.util.*;

public class Main_7569 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int depth = Integer.parseInt(st.nextToken());

        int day = 0;
        int[][][] map = new int[depth][width][height];
        int[][] direction = {
                {0, 0 ,1},
                {0, 0 ,-1},
                {0, 1, 0},
                {0, -1, 0},
                {1, 0, 0},
                {-1, 0, 0}
        };

        for (int z = 0; z < depth; z++) {
            for (int y = 0; y < height; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < width; x++) {
                    map[z][x][y] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // process
        if (allVisit(map)) {
            System.out.println(day);
            return;
        }

        day = bfs(width, height, depth, map, direction);

        if (!allVisit(map)) {
            System.out.println(-1);
            return;
        }

        // output
        System.out.println(day);
    }

    private static boolean allVisit(int[][][] map) {
        return Arrays.stream(map)
                .flatMap(Arrays::stream)
                .flatMapToInt(Arrays::stream)
                .noneMatch(tomato -> tomato == 0);
    }

    private static int bfs(int width,
                           int height,
                           int depth,
                           int[][][] map,
                           int[][] direction) {
        Queue<Integer> queue = new LinkedList<>();
        int maxDay = 0;

        for (int z = 0; z < depth; z++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (map[z][x][y] == 1) {
                        queue.offer(x);
                        queue.offer(y);
                        queue.offer(z);
                        queue.offer(0);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();
            Integer z = queue.poll();
            Integer currentDay = queue.poll();

            for (int dir = 0; dir < 6; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];
                int newZ = z + direction[dir][2];

                if (newX < 0 || newX >= width ||
                        newY < 0 || newY >= height ||
                        newZ < 0 || newZ >= depth) {
                    continue;
                }

                if (map[newZ][newX][newY] == 1 || map[newZ][newX][newY] == -1) {
                    continue;
                }

                int nextDay = currentDay + 1;
                map[newZ][newX][newY] = 1;
                queue.offer(newX);
                queue.offer(newY);
                queue.offer(newZ);
                queue.offer(nextDay);

                maxDay = Math.max(maxDay, nextDay);
            }
        }

        return maxDay;
    }
}