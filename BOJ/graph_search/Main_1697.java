package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {

    private static int seeker;
    private static int tagger;
    private static int[] minDistance = new int[100001];
    private static boolean[] visited = new boolean[100001];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        seeker = Integer.parseInt(st.nextToken());
        tagger = Integer.parseInt(st.nextToken());
    }

    private static void process() {
        dfs(seeker);
    }

    private static void dfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        minDistance[start] = 0;     // 자기 자신까지의 거리는 0

        while (!queue.isEmpty()) {
            int coordinate = queue.poll();
            int newCoordinate;

            for (int flag = 0; flag < 3; flag++) {
                newCoordinate = canGo(flag, coordinate);

                if (newCoordinate < 0 || newCoordinate > 100000) {
                    continue;
                }

                if (visited[newCoordinate]) {
                    continue;
                }

                queue.add(newCoordinate);
                visited[newCoordinate] = true;
                minDistance[newCoordinate] = minDistance[coordinate] + 1;
            }
        }
    }

    private static int canGo(int flag, int coordinate) {
        // 1. 빼기 1
        if (flag == 0) {
            return ++coordinate;
        }

        // 2. 더하기 1
        if (flag == 1) {
            return --coordinate;
        }

        // 3. 곱하기 2
        if (flag == 2) {
            return coordinate *= 2;
        }

        return 0;
    }

    private static void output() {
        System.out.println(minDistance[tagger]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
