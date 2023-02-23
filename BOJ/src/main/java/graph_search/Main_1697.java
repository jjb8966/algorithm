package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {

    private static int start;
    private static int destination;
    private static int[] minDistance = new int[100_000 + 1];
    private static boolean[] visited = new boolean[100_000 + 1];

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
    }

    private static void process() {
        dfs(start);
    }

    private static void dfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        minDistance[start] = 0;
        visited[start] = true;

        while (!queue.isEmpty()) {
            int coordinate = queue.poll();

            for (int numberOfCase = 0; numberOfCase < 3; numberOfCase++) {
                int nextCoordinate = canGo(numberOfCase, coordinate);

                if (nextCoordinate < 0 || nextCoordinate > 100_000) {
                    continue;
                }

                if (visited[nextCoordinate]) {
                    continue;
                }

                queue.add(nextCoordinate);
                minDistance[nextCoordinate] = minDistance[coordinate] + 1;
                visited[nextCoordinate] = true;
            }
        }
    }

    private static int canGo(int numberOfCase, int coordinate) {
        if (numberOfCase == 0) {
            return coordinate + 1;
        }

        if (numberOfCase == 1) {
            return coordinate - 1;
        }

        if (numberOfCase == 2) {
            return coordinate * 2;
        }

        return 0;
    }

    private static void output() {
        System.out.println(minDistance[destination]);
    }

}