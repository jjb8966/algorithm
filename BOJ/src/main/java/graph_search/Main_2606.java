package graph_search;

import java.io.*;
import java.util.*;

public class Main_2606 {

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfComputer = Integer.parseInt(br.readLine());
        int numberOfConnect = Integer.parseInt(br.readLine());

        List<Integer>[] adjacencyList = new List[numberOfComputer + 1];
        boolean[] isVisited = new boolean[numberOfComputer + 1];

        for (int i = 1; i <= numberOfComputer; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < numberOfConnect; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        // process
//        int result = dfs(1, isVisited, adjacencyList) - 1;
        int result = bfs(1, isVisited, adjacencyList);

        // output
        System.out.println(result);
    }

    private static int dfs(int vertex,
                           boolean[] isVisited,
                           List<Integer>[] adjacencyList) {
        isVisited[vertex] = true;
        int result = 1;

        for (Integer connectVertex : adjacencyList[vertex]) {
            if (isVisited[connectVertex]) {
                continue;
            }

            result += dfs(connectVertex, isVisited, adjacencyList);
        }

        return result;
    }

    private static int bfs(int start,
                           boolean[] isVisited,
                           List<Integer>[] adjacencyList) {
        Queue<Integer> queue = new LinkedList();
        int result = 0;

        isVisited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            for (Integer connectVertex : adjacencyList[vertex]) {
                if (isVisited[connectVertex]) {
                    continue;
                }

                isVisited[connectVertex] = true;
                queue.offer(connectVertex);
                result++;
            }
        }

        return result;
    }
}