package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234 {

    static int size;
    static int minGap;
    static int maxGap;
    static int result;
    static int[][] map;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
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
        size = Integer.parseInt(st.nextToken());
        minGap = Integer.parseInt(st.nextToken());
        maxGap = Integer.parseInt(st.nextToken());

        map = new int[size][size];

        for (int y = 0; y < size; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < size; x++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        int day = 0;

        while (move()) {
            day++;
            visited = new boolean[size][size];

            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    if (visited[x][y]) {
                        continue;
                    }

//                    bfs(x, y);

                    Queue<Integer> connected = new LinkedList<>();
                    dfs(x, y, connected);
                    updateMap(connected);
                }
            }
        }

        result = day;
    }

    private static void dfs(int x, int y, Queue<Integer> connected) {
        visited[x][y] = true;
        connected.offer(x);
        connected.offer(y);

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + direction[dir][0];
            int newY = y + direction[dir][1];

            if (newX < 0 || newY < 0 || newX >= size || newY >= size) {
                continue;
            }

            if (visited[newX][newY]) {
                continue;
            }

            int absGap = Math.abs(map[newX][newY] - map[x][y]);

            if (absGap < minGap || absGap > maxGap) {
                continue;
            }

            dfs(newX, newY, connected);
        }
    }

    private static void updateMap(Queue<Integer> connected) {
        int sum = 0;
        int count = 0;
        Queue<Integer> copy = new LinkedList<>(connected);

        while (!connected.isEmpty()) {
            Integer x = connected.poll();
            Integer y = connected.poll();

            sum += map[x][y];
            count++;
        }

        while (!copy.isEmpty()) {
            Integer x = copy.poll();
            Integer y = copy.poll();

            map[x][y] = sum / count;
        }
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> connected = new LinkedList<>();
        int sum;
        int count;

        sum = map[startX][startY];
        count = 1;
        connected.offer(startX);
        connected.offer(startY);

        visited[startX][startY] = true;
        queue.offer(startX);
        queue.offer(startY);

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];

                if (newX < 0 || newY < 0 || newX >= size || newY >= size) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                int absGap = Math.abs(map[newX][newY] - map[x][y]);

                if (absGap < minGap || absGap > maxGap) {
                    continue;
                }

                sum += map[newX][newY];
                count++;
                connected.offer(newX);
                connected.offer(newY);

                visited[newX][newY] = true;
                queue.offer(newX);
                queue.offer(newY);
            }
        }

        int value = sum / count;

        while (!connected.isEmpty()) {
            Integer x = connected.poll();
            Integer y = connected.poll();

            map[x][y] = value;
        }
    }

    private static boolean move() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                for (int dir = 0; dir < 4; dir++) {
                    int newX = x + direction[dir][0];
                    int newY = y + direction[dir][1];

                    if (newX < 0 || newY < 0 || newX >= size || newY >= size) {
                        continue;
                    }

                    int absGap = Math.abs(map[newX][newY] - map[x][y]);

                    if (absGap >= minGap && absGap <= maxGap) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static void output() {
        System.out.println(result);
    }

}