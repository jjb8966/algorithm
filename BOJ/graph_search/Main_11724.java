package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11724 {

    private static int vertex;
    private static int edge;
    private static List<Integer>[] adjacencyList;
    private static boolean[] visited;
    private static int result;


    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[vertex + 1];
        visited = new boolean[vertex + 1];

        for (int i = 1; i <= vertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
    }

    private static void process() {
        for (int candidate = 1; candidate <= vertex; candidate++) {
            if (visited[candidate]) {
                continue;
            }

            dfs(candidate);
            result++;
        }
    }

    private static void dfs(int startVertex) {
        visited[startVertex] = true;

        for (Integer adjacencyVertex : adjacencyList[startVertex]) {
            if (visited[adjacencyVertex]) {
                continue;
            }

            dfs(adjacencyVertex);
        }
    }

    private static void output() {
        System.out.println(result);
    }

}
