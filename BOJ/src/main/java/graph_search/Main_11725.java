package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11725 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int numberOfNode = Integer.parseInt(br.readLine());
        List<Integer>[] adjacencyList = new List[numberOfNode + 1];
        boolean[] visited = new boolean[numberOfNode + 1];
        int[] parent = new int[numberOfNode + 1];

        for (int i = 1; i <= numberOfNode; i++) {
            adjacencyList[i] = new ArrayList();
        }

        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        // process
//        dfs(1, adjacencyList, visited, parent);
        bfs(1, adjacencyList, visited, parent);

        // output
        for (int vertex = 2; vertex <= numberOfNode; vertex++) {
            System.out.println(parent[vertex]);
        }
    }


    private static void dfs(int vertex, 
                            List<Integer>[] adjacencyList,
                            boolean[] visited,
                            int[] parent) {
        visited[vertex] = true;

        for (Integer connectVertex : adjacencyList[vertex]) {
            if (visited[connectVertex]) {
                continue;
            }

            visited[connectVertex] = true;
            parent[connectVertex] = vertex;
            dfs(connectVertex, adjacencyList, visited, parent);
        }
    }

    private static void bfs(int start,
                            List<Integer>[] adjacencyList,
                            boolean[] visited,
                            int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

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