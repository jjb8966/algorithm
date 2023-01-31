package graph_search;

import java.io.*;
import java.util.*;

public class Main_1260 {

    static int numberOfVertex;
    static int numberOfEdge;
    static int startVertex;
    static boolean[] visited;
    static ArrayList<Integer>[] adList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfVertex = Integer.parseInt(st.nextToken());
        numberOfEdge = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());

        visited = new boolean[numberOfVertex + 1];
        adList = new ArrayList[numberOfVertex + 1];

        for (int i = 1; i <= numberOfVertex; i++) {
            adList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adList[a].add(b);
            adList[b].add(a);
        }

        for (int i = 1; i <= numberOfVertex; i++) {
            Collections.sort(adList[i]);
        }
    }

    private static void process() {
        dfs(startVertex);

        sb.append('\n');
        Arrays.fill(visited, false);

        bfs(startVertex);
    }

    private static void dfs(int vertex) {
        visited[vertex] = true;
        sb.append(vertex).append(" ");

        for (Integer nextVertex : adList[vertex]) {
            if (visited[nextVertex]) {
                continue;
            }

            dfs(nextVertex);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        sb.append(start).append(" ");
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            for (Integer nextVertex : adList[vertex]) {
                if (visited[nextVertex]) {
                    continue;
                }

                visited[nextVertex] = true;
                sb.append(nextVertex).append(" ");
                queue.add(nextVertex);
            }
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}