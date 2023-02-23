package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2667_rhs {

    private static ArrayList<Integer> group = new ArrayList<>();        // 인접해 있는 집을 그룹으로 묶음
    private static int size;
    private static int houseInSameGroup;          // 한 그룹에 있는 집의 수
    private static int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};      // 집이 연결될 수 있는 간선의 방향 : 위, 아래, 좌, 우
    private static String[] map;            // 2차원 좌표로 된 그래프를 String 배열로 처리
    private static boolean[][] visit;       // 방문한 집의 좌표는 true, 방문하지 않은 집은 false

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        map = new String[size];
        visit = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            map[i] = br.readLine();
        }
    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y) {
        houseInSameGroup++;
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx;
            int ny;

            nx = x + direction[k][0];
            ny = y + direction[k][1];

            if ((nx < 0) || (ny < 0) || (nx >= size) || (ny >= size)) {
                continue;  // 지도를 벗어나는 곳으로 가는가?
            }

            if (map[nx].charAt(ny) == '0') {
                continue;  // 갈 수 있는 칸인지 확인해야 한다.
            }

            if (visit[nx][ny]) {
                continue;  // 이미 방문한 적이 있는 곳인가?
            }

            dfs(nx, ny);
        }
    }

    static void process() {
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (!visit[x][y] && map[x].charAt(y) == '1') {
                    // 갈 수 있는 칸인데, 새롭게 만난 단지인 경우!
                    houseInSameGroup = 0;
                    dfs(x, y);
                    group.add(houseInSameGroup);
                    // 위의 절차를 거치고 나면 같은 단지의 집은 모두 방문하였기 때문에 visit 처리가 됨
                }
            }
        }

        Collections.sort(group);
        sb.append(group.size()).append('\n');

        for (int numberOfHouse : group) {
            sb.append(numberOfHouse).append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
