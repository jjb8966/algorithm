package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725 {

    private static ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
    private static int numberOfVertex;
    private static boolean[] visited;
    private static int[] parentVertex;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfVertex = Integer.parseInt(br.readLine());

        for (int i = 0; i <= numberOfVertex; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        visited = new boolean[numberOfVertex + 1];
        parentVertex = new int[numberOfVertex + 1];

        for (int i = 0; i < numberOfVertex - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }
    }

    private static void dfs(int start, int parent) {
        visited[start] = true;

        parentVertex[start] = parent;

        for (Integer childVertex : adjacencyList.get(start)) {
            if (!visited[childVertex]) {
                dfs(childVertex, start);
            }
        }
    }

    private static void process() {
        dfs(1, 0);

        for (int i = 2; i <= numberOfVertex; i++) {
            System.out.println(parentVertex[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
