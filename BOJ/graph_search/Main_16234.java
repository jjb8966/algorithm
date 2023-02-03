package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234 {

    static int mapSize;
    static int minGap;
    static int maxGap;
    static int sum;
    static int count;
    static int day;
    static int[][] map;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean move = true;
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
        mapSize = Integer.parseInt(st.nextToken());
        minGap = Integer.parseInt(st.nextToken());
        maxGap = Integer.parseInt(st.nextToken());

        map = new int[mapSize][mapSize];

        for (int y = 0; y < mapSize; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < mapSize; x++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }

    }

    private static void process() {
        while (true) {
            move = false;
            visited = new boolean[mapSize][mapSize];

            for (int y = 0; y < mapSize; y++) {
                for (int x = 0; x < mapSize; x++) {
                    if (visited[x][y]) {
                        continue;
                    }

                    sum = 0;
                    count = 0;
                    Queue<Integer> queue = new LinkedList<>();

                    dfs(x, y, queue);

                    if (count == 1) {
                        continue;
                    }

                    while (!queue.isEmpty()) {
                        Integer changeX = queue.poll();
                        Integer changeY = queue.poll();

                        map[changeX][changeY] = sum / count;
                    }
                }
            }

            if (!move) {
                break;
            }

            day++;
        }
    }

    private static void dfs(int x, int y, Queue<Integer> queue) {
        visited[x][y] = true;
        queue.offer(x);
        queue.offer(y);
        sum += map[x][y];
        count++;

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + direction[dir][0];
            int newY = y + direction[dir][1];
            int gap;

            if (newX < 0 || newY < 0 || newX >= mapSize || newY >= mapSize) {
                continue;
            }

            if (visited[newX][newY]) {
                continue;
            }

            gap = Math.abs(map[x][y] - map[newX][newY]);

            if (gap < minGap || gap > maxGap) {
                continue;
            }

            move = true;
            dfs(newX, newY, queue);
        }
    }

    private static void output() {
        System.out.println(day);
    }

}