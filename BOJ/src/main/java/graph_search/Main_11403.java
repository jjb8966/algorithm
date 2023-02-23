package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11403 {

    private static int numberOfVertex;
    private static int[][] oneDirection;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfVertex = Integer.parseInt(st.nextToken());

        oneDirection = new int[numberOfVertex + 1][numberOfVertex + 1];
        result = new int[numberOfVertex + 1][numberOfVertex + 1];

        for (int y = 1; y <= numberOfVertex; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 1; x <= numberOfVertex; x++) {
                oneDirection[x][y] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        for (int start = 1; start <= numberOfVertex; start++) {
            int[] canGo = new int[numberOfVertex + 1];
            boolean[] visited = new boolean[numberOfVertex + 1];

            dfs(start, canGo, visited);      // canGo 초기화

            for (int destination = 1; destination <= numberOfVertex; destination++) {
                if (canGo[destination] == 1) {
                    result[start][destination] = 1;
                }
            }
        }
    }

    private static void dfs(int start, int[] canGo, boolean[] visited) {
        for (int destination = 1; destination <= numberOfVertex; destination++) {
            if (oneDirection[start][destination] == 1 && !visited[destination]) {
                canGo[destination] = 1;
                visited[destination] = true;

                dfs(destination, canGo, visited);
            }
        }
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();

        for (int y = 1; y <= numberOfVertex; y++) {
            for (int x = 1; x <= numberOfVertex; x++) {
                sb.append(result[x][y]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

}
