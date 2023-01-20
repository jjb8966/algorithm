package search;

import java.util.LinkedList;
import java.util.Queue;

public class Solution6 {

    int answer;
    int[][] map = new int[101][101];
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited = new boolean[101][101];

    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0] * 2;
            int y1 = rectangle[1] * 2;
            int x2 = rectangle[2] * 2;
            int y2 = rectangle[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if ((x == x1 || x == x2 || y == y1 || y == y2)) {
                        if (map[x][y] == 0) {
                            map[x][y] = 1;
                        }
                    } else {
                        map[x][y] = 2;
                    }
                }
            }
        }

//        for (int y = 0; y <= 100; y++) {
//            for (int x = 0; x <= 100; x++) {
//                System.out.print(map[x][y] + " ");
//            }
//            System.out.println();
//        }

        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        return answer;
    }

    private void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        queue.add(characterX);
        queue.add(characterY);
        queue.add(count);
        visited[characterX][characterY] = true;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();
            Integer currentCount = queue.poll();

            if (x == itemX && y == itemY) {
                answer = currentCount / 2;
            }

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + direction[dir][0];
                int newY = y + direction[dir][1];

                if (newX < 0 || newY < 0 || newX > 100 || newY > 100) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] != 1) {
                    continue;
                }

                queue.add(newX);
                queue.add(newY);
                queue.add(currentCount + 1);
                visited[newX][newY] = true;
            }
        }
    }

    public static void main(String[] args) {
        Solution6 prob = new Solution6();
        int[][] rectangle = {
                {1, 1, 7, 4},
                {3, 2, 5, 5},
                {4, 3, 6, 9},
                {2, 6, 8, 8}
        };

        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        int[][] rectangle2 = {
                {1, 1, 2, 3},
                {1, 2, 3, 3}
        };

        int characterX2 = 1;
        int characterY2 = 1;
        int itemX2 = 3;
        int itemY2 = 3;

        int[][] rectangle3 = {
                {2, 1, 7, 5},
                {6, 4, 10, 10}
        };

        int characterX3 = 3;
        int characterY3 = 1;
        int itemX3 = 7;
        int itemY3 = 10;

//        System.out.println(prob.solution(rectangle, characterX, characterY, itemX, itemY));
//        System.out.println(prob.solution(rectangle2, characterX2, characterY2, itemX2, itemY2));
        System.out.println(prob.solution(rectangle3, characterX3, characterY3, itemX3, itemY3));
    }

}