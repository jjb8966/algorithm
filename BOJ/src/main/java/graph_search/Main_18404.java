package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18404 {

    private static final int COUNT_OF_DIRECTION = 8;
    private static int sizeOfChessboard;
    private static int countOfPiece;
    private static Piece[] pieces;
    private static boolean[][] visited;
    private static Piece queen;
    private static int[][] direction = {
            {2, 1}, {2, -1},    // 오른쪽 x+2
            {-2, 1}, {-2, -1},  // 왼쪽 x-2
            {-1, -2}, {1, -2},   // 위 y-2
            {-1, 2}, {1, 2}    // 아래 y+2
    };
    private static int[] result;

    static class Piece {
        int x;
        int y;
        int count;

        public Piece(int x, int y, int count) {
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
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sizeOfChessboard = Integer.parseInt(st.nextToken());
        countOfPiece = Integer.parseInt(st.nextToken());

        visited = new boolean[sizeOfChessboard + 1][sizeOfChessboard + 1];
        pieces = new Piece[countOfPiece + 1];
        result = new int[countOfPiece + 1];

        st = new StringTokenizer(br.readLine());
        queen = new Piece(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        for (int i = 1; i <= countOfPiece; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pieces[i] = new Piece(x, y, 0);
        }

    }

    private static void process() {
        bfs();
    }

    private static void bfs() {
        Queue<Piece> queue = new LinkedList<>();
        int newX;
        int newY;

        queue.add(queen);
        visited[queen.getX()][queen.getY()] = true;

        while (!queue.isEmpty()) {
            Piece piece = queue.poll();
            int x = piece.getX();
            int y = piece.getY();
            int count = piece.getCount();

            for (int i = 0; i < COUNT_OF_DIRECTION; i++) {
                newX = x + direction[i][0];
                newY = y + direction[i][1];

                if (newX < 0 || newY < 0 || newX > sizeOfChessboard || newY > sizeOfChessboard) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (getTargetNumber(newX, newY) != -1) {
                    result[getTargetNumber(newX, newY)] = count + 1;
                }

                queue.add(new Piece(newX, newY, count + 1));
                visited[newX][newY] = true;
            }
        }
    }

    private static int getTargetNumber(int newX, int newY) {
        for (int i = 1; i <= countOfPiece; i++) {
            if (newX == pieces[i].getX() && newY == pieces[i].getY()) {
                return i;
            }
        }

        return -1;
    }

    private static void output() {
        for (int i = 1; i <= countOfPiece; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
