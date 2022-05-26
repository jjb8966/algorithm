package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14502 {

    private static int height;
    private static int width;
    private static int maxSafeArea = Integer.MIN_VALUE;
    private static int[][] map;
    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static boolean[][] existVirus;
    private static ArrayList<Virus> viruses = new ArrayList<>();

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height][width];
        existVirus = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 초기 map 입력 시 2를 입력하면 x,y 좌표로 바이러스 객체를 만들고 해당 좌표 방문 표시
                if (map[i][j] == 2) {
                    viruses.add(new Virus(i, j));
                    existVirus[i][j] = true;
                }
            }
        }
    }

    private static void process() {
        buildWall(0, 0);
    }

    private static void buildWall(int wallIndex, int previousX) {
        // 벽 3개를 다 배치한 경우
        if (wallIndex > 2) {
            int currentSafeArea;
            int[][] newMap = spreadVirus();

            currentSafeArea = checkSafeArea(newMap);

            if (maxSafeArea < currentSafeArea) {
                maxSafeArea = currentSafeArea;
            }
        } else {    // 2. 벽 3개를 다 배치하지 않은 경우
            /**
             * 벽은 순서없이 배치하므로 같은 위치에만 있으면 같은 케이스임
             * 앞에 배치한 벽보다 이전 row 에 벽을 배치할 필요가 없으므로 previousX 를 활용해 구현
             * 주의!! 앞의 배치한 벽보다 column 은 작을 수 있음
             * ex)
             * 0 0 0 1
             * 1 0 0 0
             */
            for (int x = previousX; x < height; x++) {
                for (int y = 0; y < width; y++) {
                    if (map[x][y] == 2 || map[x][y] == 1) {
                        continue;
                    }

                    map[x][y] = 1;

                    buildWall(wallIndex + 1, x);

                    map[x][y] = 0;
                }
            }
        }
    }

    // 바이러스를 퍼트리는 메소드
    private static int[][] spreadVirus() {
        Queue<Virus> queue = new LinkedList();
        int[][] newMap = new int[height][width];
        boolean[][] newExistVirus = new boolean[height][width];

        // 시작 바이러스들을 큐에 넣어줌
        for (int i = 0; i < viruses.size(); i++) {
            queue.add(viruses.get(i));
        }

        // 2차원 배열의 깊은 복사
        // clone 사용해도 깊은 복사 안 됨!
        //
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // 이 때 맵은 3개의 벽이 세워진 상태의 맵
                newMap[i][j] = map[i][j];
                newExistVirus[i][j] = existVirus[i][j];
            }
        }

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();
            int x = virus.x;
            int y = virus.y;

            for (int i = 0; i < 4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];

                if (newX < 0 || newY < 0 || newX > height - 1 || newY > width - 1) {
                    continue;
                }

                if (newExistVirus[newX][newY]) {
                    continue;
                }

                if (newMap[newX][newY] == 1) {
                    continue;
                }

                // 조건을 모두 통과한 좌표
                // 바이러스 배치
                newMap[newX][newY] = 2;
                // exist check
                newExistVirus[newX][newY] = true;
                // 큐에 넣음
                queue.add(new Virus(newX, newY));
            }
        }

        return newMap;
    }

    // 안전 영역을 카운팅하는 메소드
    public static int checkSafeArea(int[][] newMap) {
        int countSafeArea = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (newMap[i][j] == 0) {
                    countSafeArea++;
                }
            }
        }

        return countSafeArea;
    }

    private static void output() {
        System.out.println(maxSafeArea);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
