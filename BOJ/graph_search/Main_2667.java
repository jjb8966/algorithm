package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2667 {

    static private int sizeOfMap;
    static private int countHouse;
    static private int[][] direction = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    static private int[][] map;
    static private boolean[][] visited;
    static private List<Integer> town = new ArrayList<>();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sizeOfMap = Integer.parseInt(br.readLine());

        map = new int[sizeOfMap][sizeOfMap];
        visited = new boolean[sizeOfMap][sizeOfMap];

        for (int i = 0; i < sizeOfMap; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < sizeOfMap; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

    private static void process() {
        for (int i = 0; i < sizeOfMap; i++) {
            for (int j = 0; j < sizeOfMap; j++) {
                // 해당 좌표에 집이 있으면서 방문한 적이 없는 집만 dfs
                if (map[i][j] == 1 && visited[i][j] == false) {
                    dfs(i, j);
                    town.add(countHouse);
                    countHouse = 0;
                }
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
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];

            // 조건 1 : map 을 벗어나는 좌표면 continue
            if (newX < 0 || newY < 0 || newX > sizeOfMap - 1 || newY > sizeOfMap - 1) {
                continue;
            }

            // 조건 2,3 : 새로운 좌표에 집이 없거나 이미 방문한 상태이면 continue
            if (map[newX][newY] == 0 || visited[newX][newY] == true) {
                continue;
            }

            // 모든 조건을 통과한 방문할 가치가 있는 좌표에 대해 dfs
            dfs(newX, newY);
        }
    }

    private static void output() {
        int numberOfTown = town.size();

        System.out.println(numberOfTown);

        Collections.sort(town);

        for (int i = 0; i < numberOfTown; i++) {
            System.out.println(town.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
