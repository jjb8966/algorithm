package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_4803 {

    private static int numberOfVertex;
    private static int numberOfEdge;
    private static int testCase;
    private static int countOfTree;
    private static boolean isCyclic;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjacencyList;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            inputVertexAndEdge();

            if (numberOfVertex == 0 && numberOfEdge == 0) {
                break;
            }

            testCase++;
            inputGraph();
            process();
        }

        output();
    }

    private static void inputVertexAndEdge() throws IOException {
        st = new StringTokenizer(br.readLine());
        numberOfVertex = Integer.parseInt(st.nextToken());
        numberOfEdge = Integer.parseInt(st.nextToken());
    }

    private static void inputGraph() throws IOException {
        visited = new boolean[numberOfVertex + 1];
        adjacencyList = new ArrayList[numberOfVertex + 1];

        for (int i = 1; i <= numberOfVertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
    }

    private static void process() {
        countOfTree = 0;

        for (int i = 1; i <= numberOfVertex; i++) {
            isCyclic = false;

            if (visited[i]) {
                continue;
            }

            dfs(i, 0);

            if (!isCyclic) {
                countOfTree++;
            }
        }

        if (countOfTree == 0) {
            sb.append("Case ").append(testCase).append(": ").append("No trees.\n");
        } else if (countOfTree == 1) {
            sb.append("Case ").append(testCase).append(": ").append("There is one tree.\n");
        } else {
            sb.append("Case ").append(testCase).append(": ").append("A forest of ").append(countOfTree).append(" trees.\n");
        }
    }

    private static void dfs(int currentVertex, int previousVertex) {
        visited[currentVertex] = true;

        for (Integer adjacencyVertex : adjacencyList[currentVertex]) {
            if (visited[adjacencyVertex]) {
                if (adjacencyVertex != previousVertex) {
                    isCyclic = true;
                    return;
                }

                continue;
            }

            dfs(adjacencyVertex, currentVertex);
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}