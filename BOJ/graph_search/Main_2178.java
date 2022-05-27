package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS 로 최단거리 구하는 문제
 * DFS 는 불가!!
 */
public class Main_2178 {

    private static int height;
    private static int width;
    private static int[][] map;
    private static int[][] minDistance;
    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static boolean[][] visited;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height + 1][width + 1]; // index : 1 ~ value
        minDistance = new int[height + 1][width + 1];
        visited = new boolean[height + 1][width + 1];

        for (int i = 1; i <= height; i++) {
            st = new StringTokenizer(br.readLine());
            String[] temp = st.nextToken().split("");

            for (int j = 1; j <= width; j++) {
                map[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }
    }

    private static void process() {
        bfs(1, 1);
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startX);
        queue.add(startY);
        visited[startX][startY] = true;
        minDistance[startX][startY] = 1;    // 1,1 (자기 자신)까지의 거리 = 1

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            int newX;
            int newY;

            for (int i = 0; i < 4; i++) {
                newX = x + direction[i][0];
                newY = y + direction[i][1];

                if (newX < 1 || newY < 1 || newX > height || newY > width) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] == 0) {
                    continue;
                }

                queue.add(newX);
                queue.add(newY);
                visited[newX][newY] = true;
                minDistance[newX][newY] = minDistance[x][y] + 1;
            }
        }
    }

    private static void output() {
        System.out.println(minDistance[height][width]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
