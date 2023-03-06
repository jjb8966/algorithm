package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    }

    private static void process() {
        Arrays.stream(adList)
                .filter(Objects::nonNull)
                .forEach(Collections::sort);

        dfs(startVertex);

        sb.append('\n');

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
        visited = new boolean[numberOfVertex + 1];

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            sb.append(vertex).append(" ");

            for (Integer nextVertex : adList[vertex]) {
                if (visited[nextVertex]) {
                    continue;
                }

                visited[nextVertex] = true;
                queue.offer(nextVertex);
            }
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}