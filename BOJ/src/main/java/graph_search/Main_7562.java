package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    public static final int NUMBER_OF_DIRECTION = 8;
    private static int testCase;
    private static int sizeOfChessboard;
    private static Point start;
    private static Point destination;
    private static boolean[][] visited;
    private static int[][] direction = {
            {2, 1}, {2, -1},    // 오른쪽 x+2
            {-2, 1}, {-2, -1},  // 왼쪽 x-2
            {-1, -2}, {1, -2},   // 위 y-2
            {-1, 2}, {1, 2}    // 아래 y+2
    };

    static class Point {
        private int x;
        private int y;
        private int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();
            process();
        }

        output();
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        sizeOfChessboard = Integer.parseInt(st.nextToken());
        visited = new boolean[sizeOfChessboard][sizeOfChessboard];

        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        st = new StringTokenizer(br.readLine());
        destination = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
    }

    private static void process() {
        bfs(start);
        sb.append(destination.getCount()).append("\n");
    }

    private static void bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(start);
        visited[start.getX()][start.getY()] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.getX();
            int y = point.getY();
            int count = point.getCount();
            int newX;
            int newY;

            for (int i = 0; i < NUMBER_OF_DIRECTION; i++) {
                newX = x + direction[i][0];
                newY = y + direction[i][1];

                if (newX < 0 || newY < 0 || newX >= sizeOfChessboard || newY >= sizeOfChessboard) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (newX == destination.getX() && newY == destination.getY()) {
                    destination.setCount(count + 1);

                    return;
                }

                queue.add(new Point(newX, newY, count + 1));
                visited[newX][newY] = true;
            }
        }
    }

    private static void output() {
        System.out.print(sb);
    }

}
