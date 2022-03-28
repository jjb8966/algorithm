package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 인접 리스트 구현 방식
 * ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
 *
 *  for (int i = 0; i <= numberOfVertex; i++) {     // 인덱스 : 1 ~ numberOfVertex
 *      adjacencyList.add(new ArrayList<>());
 *  }
 */
public class Main_1260 {

    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
    private static int numberOfVertex;
    private static int numberOfEdge;
    private static int startVertex;
    private static boolean[] visited;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfVertex = Integer.parseInt(st.nextToken());
        numberOfEdge = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= numberOfVertex; i++) {     // 인덱스 : 1 ~ numberOfVertex
            adjacencyList.add(new ArrayList<>());
        }

        visited = new boolean[numberOfVertex + 1];      // 인덱스 : 1 ~ numberOfVertex

        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }

        for (ArrayList<Integer> integers : adjacencyList) {
            Collections.sort(integers);
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (Integer adjacencyVertex : adjacencyList.get(start)) {
            if (!visited[adjacencyVertex]) {
                dfs(adjacencyVertex);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int bottomVertex = queue.poll();

            sb.append(bottomVertex).append(" ");

            for (Integer adjacencyVertex : adjacencyList.get(bottomVertex)) {
                if (!visited[adjacencyVertex]) {
                    queue.add(adjacencyVertex);
                    visited[adjacencyVertex] = true;
                }
            }
        }
    }

    private static void process() {
        dfs(startVertex);
        reset();
        bfs(startVertex);
        System.out.println(sb);
    }

    private static void reset() {
        for (int i = 1; i <= numberOfVertex; i++) {
            visited[i] = false;
        }

        sb.append('\n');
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
