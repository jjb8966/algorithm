package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11725 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfNode = Integer.parseInt(br.readLine());
        int numberOfPair = numberOfNode - 1;
        int[] parent = new int[numberOfNode + 1];
        boolean[] visited = new boolean[numberOfNode + 1];
        List<Integer>[] adjacencyList = new List[numberOfNode + 1];

        for (int i = 0; i < numberOfNode + 1; i++) {
            adjacencyList[i] = new ArrayList();
        }

        StringTokenizer st;
        for (int i = 0; i < numberOfPair; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        // process
//        dfs(1, parent, visited, adjacencyList);
        bfs(1, parent, visited, adjacencyList);

        // output
        for (int vertex = 2; vertex <= numberOfNode; vertex++) {
            System.out.println(parent[vertex]);
        }
    }

    private static void dfs(int vertex,
                            int[] parent,
                            boolean[] visited,
                            List<Integer>[] adjacencyList) {
        visited[vertex] = true;

        for (Integer connectVertex : adjacencyList[vertex]) {
            if (visited[connectVertex]) {
                continue;
            }

            visited[connectVertex] = true;
            parent[connectVertex] = vertex;
            dfs(connectVertex, parent, visited, adjacencyList);
        }
    }

    private static void bfs(int startVertex,
                            int[] parent,
                            boolean[] visited,
                            List<Integer>[] adjacencyList) {
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            for (Integer connectVertex : adjacencyList[vertex]) {
                if (visited[connectVertex]) {
                    continue;
                }

                visited[connectVertex] = true;
                parent[connectVertex] = vertex;
                queue.offer(connectVertex);
            }
        }
    }
}