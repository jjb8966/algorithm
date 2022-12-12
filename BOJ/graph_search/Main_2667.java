package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2667 {

    private static int sizeOfMap;
    private static int countHouse;
    private static int[][] direction = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> town = new ArrayList<>();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sizeOfMap = Integer.parseInt(br.readLine());

        map = new int[sizeOfMap + 1][sizeOfMap + 1];
        visited = new boolean[sizeOfMap + 1][sizeOfMap + 1];

        for (int y = 1; y <= sizeOfMap; y++) {
            String[] temp = br.readLine().split("");

            for (int x = 1; x <= sizeOfMap; x++) {
                map[x][y] = Integer.parseInt(temp[x - 1]);
            }
        }
    }

    private static void process() {
        for (int y = 1; y <= sizeOfMap; y++) {
            for (int x = 1; x <= sizeOfMap; x++) {
                countHouse = 0;

                // 해당 좌표에 집이 있으면서 방문한 적이 없는 집만 dfs
                if (map[x][y] == 0) {
                    continue;
                }

                if (visited[x][y]) {
                    continue;
                }

                dfs(x, y);
                town.add(countHouse);
            }
        }
    }

    // x,y 집을 방문할 수 있다는 것을 알고 온 상태
    private static void dfs(int x, int y) {
        // visit check
        visited[x][y] = true;
        // 정답 갱신
        countHouse++;

        // 방문할 수 있는 모든 집들에 대해 dfs
        for (int dir = 0; dir < 4; dir++) {
            int newX = x + direction[dir][0];
            int newY = y + direction[dir][1];

            // 조건 1 : map 을 벗어나는 좌표면 continue
            if (newX <= 0 || newY <= 0 || newX > sizeOfMap || newY > sizeOfMap) {
                continue;
            }

            // 조건 2 : 새로운 좌표에 집이 없으면 continue
            if (map[newX][newY] == 0) {
                continue;
            }

            // 조건 3 : 이미 방문한 상태이면 continue
            if (visited[newX][newY]) {
                continue;
            }

            // 모든 조건을 통과한 방문할 가치가 있는 좌표에 대해 dfs
            dfs(newX, newY);
        }
    }

    private static void output() {
        System.out.println(town.size());

        Collections.sort(town);
        town.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
