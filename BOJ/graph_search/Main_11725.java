package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725 {

    static int numberOfVertex;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<Integer>[] adList;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfVertex = Integer.parseInt(br.readLine());

        visited = new boolean[numberOfVertex + 1];
        adList = new ArrayList[numberOfVertex + 1];
        parent = new int[numberOfVertex + 1];

        for (int i = 1; i <= numberOfVertex; i++) {
            adList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfVertex - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adList[a].add(b);
            adList[b].add(a);
        }

    }

    private static void process() {
//        dfs(1);
        bfs(1);
    }

    private static void dfs(int vertex) {
        visited[vertex] = true;

        for (Integer nextVertex : adList[vertex]) {
            if (visited[nextVertex]) {
                continue;
            }

            parent[nextVertex] = vertex;
            dfs(nextVertex);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            for (Integer nextVertex : adList[vertex]) {
                if (visited[nextVertex]) {
                    continue;
                }

                visited[nextVertex] = true;
                parent[nextVertex] = vertex;
                queue.add(nextVertex);
            }
        }
    }

    private static void output() {
        for (int i = 2; i <= numberOfVertex; i++) {
            System.out.println(parent[i]);
        }
    }

}