package graph_search;

import java.io.*;
import java.util.*;

public class Main_1260 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int numberOfVertex = Integer.parseInt(st.nextToken());
        int numberOfEdge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());
        
        List<Integer>[] adjacencyList = new List[numberOfVertex + 1];
        boolean[] visited = new boolean[numberOfVertex + 1];

        for (int vertex = 1; vertex <= numberOfVertex; vertex++) {
            adjacencyList[vertex] = new ArrayList<>();
        }
        
        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        // - adjacencyList 정렬
        for (int vertex = 1; vertex <= numberOfVertex; vertex++) {
            adjacencyList[vertex].sort((o1, o2) -> o1 - o2);
        }

        // process
        dfs(result, startVertex, adjacencyList, visited);
        Arrays.fill(visited, false);
        bfs(result, startVertex, adjacencyList, visited);

        // output
        System.out.println(result);
    }

    private static void dfs(StringBuilder result,
                            int vertex,
                            List<Integer>[] adjacencyList, 
                            boolean[] visited) {
        visited[vertex] = true;
        result.append(vertex).append(" ");

        for (Integer connectVertex : adjacencyList[vertex]) {
            if (visited[connectVertex]) {
                continue;
            }

            visited[connectVertex] = true;
            dfs(result, connectVertex, adjacencyList, visited);
        }
    }

    private static void bfs(StringBuilder result,
                            int startVertex,
                            List<Integer>[] adjacencyList,
                            boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        result.append('\n');

        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            result.append(vertex).append(" ");

            for (Integer connectVertex : adjacencyList[vertex]) {
                if (visited[connectVertex]) {
                    continue;
                }

                visited[connectVertex] = true;
                queue.offer(connectVertex);
            }
        }
    }
}