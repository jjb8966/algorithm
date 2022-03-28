package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2667 {
    private static ArrayList<Integer> group = new ArrayList<>();        // 인접해 있는 집을 그룹으로 묶음
    private static int countHouse = 0;                                  // 한 그룹에 있는 집의 수
    private static int side;
    private static int[][] map;     // map 크기 : N * N
    private static int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};      // 집이 연결될 수 있는 간선의 방향 : 위, 아래, 좌, 우
    private static boolean[][] visit;       // 방문한 집의 좌표는 true, 방문하지 않은 집은 flase

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        side = Integer.parseInt(br.readLine());
        map = new int[side][side];
        visit = new boolean[side][side];

        for (int i = 0; i < side; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < side; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;     // x,y 좌표 집 방문
        countHouse++;           // 집의 수 1 증가

        for (int i = 0; i < 4; i++) {     // x,y 집이 연결될 수 있는 방향은 4가지 뿐이므로 4번 검색
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];

            if (newX < 0 || newY < 0 || newX > side - 1 || newY > side - 1) {  // 좌표가 map의 범위를 벗어난 경우 continue
                continue;
            }

            if (visit[newX][newY]) {      // 방문한 적이 있는 집이면 continue
                continue;
            }

            if (map[newX][newY] == 0) {   // map에 해당하는 좌표에 집이 없으면 continue
                continue;
            }

            dfs(newX, newY);        // 위의 조건을 다 통과한 좌표 : 방문해야하는 집의 좌표
        }
    }

    public static void getResult() {
        for (int x = 0; x < side; x++) {
            for (int y = 0; y < side; y++) {
                if (!visit[x][y] && map[x][y] == 1) {   // 방문한 적이 없고 해당 좌표에 집이 있으면 dfs
                    dfs(x, y);                          // x,y 좌표의 집을 시작으로 연결된 모든 집 탐색 -> 하나의 그룹 탐색
                    group.add(countHouse);              // 모두 탐색했으면 그룹 리스트에 해당 그룹의 집 수 추가
                    countHouse = 0;                     // 다음 그룹 탐색을 위해 countHouse 초기화
                }
            }
        }

        Collections.sort(group);                        // 문제에서 집의 수가 작은 것 부터 출력하라 했으므로 정렬

        System.out.println(group.size());

        for (int i = 0; i < group.size(); i++) {
            System.out.println(group.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        getResult();
    }
}
