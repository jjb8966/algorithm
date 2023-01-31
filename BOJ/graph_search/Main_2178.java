package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {

    static int height;
    static int width;
    static int result;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] map;
    static boolean[][] visited;

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

        visited = new boolean[width + 1][height + 1];
        map = new int[width + 1][height + 1];

        for (int y = 1; y <= height; y++) {
            String[] row = br.readLine().split("");

            for (int x = 1; x <= width; x++) {
                map[x][y] = Integer.parseInt(row[x - 1]);
            }
        }
    }

    private static void process() {
        bfs(1, 1);
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();

        visited[startX][startY] = true;
        queue.offer(startX);
        queue.offer(startY);
        queue.offer(1);

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();
            Integer count = queue.poll();

            if (x == width && y == height) {
                result = count;
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];

                if (newX <= 0 || newY <= 0 || newX > width || newY > height) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] == 0) {
                    continue;
                }

                visited[newX][newY] = true;
                queue.add(newX);
                queue.add(newY);
                queue.add(count + 1);
            }
        }
    }

    private static void output() {
        System.out.println(result);
    }

}