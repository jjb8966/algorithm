package graph_search;

import java.io.*;
import java.util.*;

public class Main_2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfComputer = Integer.parseInt(br.readLine());
        int numberOfPair = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[numberOfComputer + 1];
        List[] adjacenyList = new List[numberOfComputer + 1];

        // init
        for (int number = 1; number <= numberOfComputer; number++) {
            adjacenyList[number] = new ArrayList<>();
        }

        for (int number = 1; number <= numberOfPair; number++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstVertex = Integer.parseInt(st.nextToken());
            int secondVertex = Integer.parseInt(st.nextToken());

            adjacenyList[firstVertex].add(secondVertex);
            adjacenyList[secondVertex].add(firstVertex);
        }

        // process
        int result = dfs(1, visited, adjacenyList) - 1;
//        int result = bfs(1, visited, adjacenyList);

        // output
        System.out.println(result);
    }

    private static int dfs(int vertex,
                           boolean[] visited,
                           List<Integer>[] adjacenyList) {
        int count = 1;

        visited[vertex] = true;

        for (Integer connectVertex : adjacenyList[vertex]) {
            if (visited[connectVertex]) {
                continue;
            }

            count += dfs(connectVertex, visited, adjacenyList);
        }

        return count;
    }

    private static int bfs(int start,
                           boolean[] visited,
                           List<Integer>[] adjacenyList) {
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            for (Integer connectVertex : adjacenyList[vertex]) {
                if (visited[connectVertex]) {
                    continue;
                }

                visited[connectVertex] = true;
                result++;
                queue.add(connectVertex);
            }
        }

        return result;
    }

}