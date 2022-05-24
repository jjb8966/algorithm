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

    private static int numberOfVertex;
    private static int numberOfEdge;
    private static int startNumber;
    private static int[] visited;
    private static ArrayList<Integer>[] adjacencyList;
    private static StringBuilder sb = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a;
        int b;

        numberOfVertex = Integer.parseInt(st.nextToken());
        numberOfEdge = Integer.parseInt(st.nextToken());
        startNumber = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[numberOfVertex + 1]; // index : 1 ~ numberOfVertex
        visited = new int[numberOfVertex + 1];  // index : 1 ~ numberOfVertex

        for (int i = 1; i <= numberOfVertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
    }

    private static void process() {
        sort();
        dfs(startNumber);
        reset();
        bfs(startNumber);
    }

    private static void sort() {
        for (int i = 1; i <= numberOfVertex; i++) {
            Collections.sort(adjacencyList[i]);
        }
    }

    private static void dfs(int number) {
        visited[number]++;

        sb.append(number).append(' ');

        for (Integer reachableVertex : adjacencyList[number]) {
            if (visited[reachableVertex] == 1) {
                continue;
            }

            dfs(reachableVertex);
        }
    }

    private static void bfs(int startNumber) {
        Queue<Integer> queue = new LinkedList<>();
        int pollVertex;

        queue.add(startNumber);
        visited[startNumber]++;

        while (!queue.isEmpty()) {
            pollVertex = queue.poll();

            sb.append(pollVertex).append(' ');

            for (Integer reachableVertex : adjacencyList[pollVertex]) {
                if (visited[reachableVertex] == 1) {
                    continue;
                }

                queue.add(reachableVertex);
                visited[reachableVertex]++;
            }
        }
    }

    private static void output() {
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void reset() {
        for (int i = 1; i <= numberOfVertex; i++) {
            visited[i] = 0;
        }

        sb.append('\n');
    }
}
