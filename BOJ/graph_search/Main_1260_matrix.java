package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_matrix {
    private static StringBuilder sb = new StringBuilder();
    private static int vertex;
    private static int edge;
    private static int startNumber;
    private static int[][] adjacencyMatrix;
    private static boolean[] visit;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        startNumber = Integer.parseInt(st.nextToken());

        adjacencyMatrix = new int[vertex + 1][vertex + 1];      //1~vertex 인덱스 사용
        visit = new boolean[vertex + 1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyMatrix[a][b] = 1;
            adjacencyMatrix[b][a] = 1;
        }
    }

    public static void dfs(int number) {
        visit[number] = true;
        sb.append(number).append(" ");

        for (int i = 1; i <= vertex; i++) {
            if (adjacencyMatrix[number][i] == 0) {
                continue;
            }

            if (visit[i]) {
                continue;
            }

            dfs(i);
        }
    }

    public static void bfs(int number) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(number);
        visit[number] = true;
        sb.append(number).append(" ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 1; i <= vertex; i++) {
                if (adjacencyMatrix[temp][i] == 0) {
                    continue;
                }

                if (visit[i]) {
                    continue;
                }

                queue.add(i);
                visit[i] = true;
                sb.append(i).append(" ");
            }
        }
    }

    public static void resetVariable() {
        for (int i = 1; i <= vertex; i++) {
            visit[i] = false;
        }

        sb.setLength(0);
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(startNumber);
        System.out.println(sb);
        resetVariable();
        bfs(startNumber);
        System.out.println(sb);
    }
}
