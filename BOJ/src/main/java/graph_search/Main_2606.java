package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606 {

    static int numberOfComputer;
    static int numberOfPair;
    static int result;
    static boolean[] visited;
    static ArrayList<Integer>[] adjacencyList;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfComputer = Integer.parseInt(br.readLine());
        numberOfPair = Integer.parseInt(br.readLine());

        visited = new boolean[numberOfComputer + 1];
        adjacencyList = new ArrayList[numberOfComputer + 1];

        for (int i = 1; i <= numberOfComputer; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfPair; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

    }

    private static void process() {
//        dfs(1);
        bfs(1);
    }

    private static void dfs(int vertex) {
        visited[vertex] = true;

        for (Integer nextVertex : adjacencyList[vertex]) {
            if (visited[nextVertex]) {
                continue;
            }

            result++;
            dfs(nextVertex);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            for (Integer nextVertex : adjacencyList[vertex]) {
                if (visited[nextVertex]) {
                    continue;
                }

                visited[nextVertex] = true;
                result++;
                queue.offer(nextVertex);
            }
        }
    }

    private static void output() {
        System.out.println(result);
    }

}