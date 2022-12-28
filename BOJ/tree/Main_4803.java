package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_4803 {

    private static int testCase = 1;
    private static int numberOfNode;
    private static int numberOfEdge;
    private static int countOfTree;
    private static boolean hasNextTestCase = true;
    private static boolean isCyclic;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjacencyList;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (hasNextTestCase) {
            input();
            process();
            testCase++;
        }

        output();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        numberOfEdge = Integer.parseInt(st.nextToken());

        if (numberOfNode == 0 && numberOfEdge == 0) {
            hasNextTestCase = false;
            return;
        }

        visited = new boolean[numberOfNode + 1];
        adjacencyList = new ArrayList[numberOfNode + 1];

        for (int i = 1; i <= numberOfNode; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            adjacencyList[node1].add(node2);
            adjacencyList[node2].add(node1);
        }
    }

    private static void process() {
        if (!hasNextTestCase) {
            return;
        }

        countOfTree = 0;

        for (int node = 1; node <= numberOfNode; node++) {
            if (visited[node]) {
                continue;
            }

            isCyclic = false;

            dfs(node, -1);

            if (!isCyclic) {
                countOfTree++;
            }
        }

        updateResult();
    }

    private static void dfs(int node, int previousNode) {
        visited[node] = true;

        for (Integer nextNode : adjacencyList[node]) {
            if (nextNode == previousNode) {
                continue;
            }

            if (nextNode != previousNode && visited[nextNode]) {
                isCyclic = true;
                return;
            }

            dfs(nextNode, node);
        }
    }

    private static void updateResult() {
        if (countOfTree == 0) {
            sb.append("Case " + testCase + ": No trees.").append('\n');
        }

        if (countOfTree == 1) {
            sb.append("Case " + testCase + ": There is one tree.").append('\n');
        }

        if (countOfTree >= 2) {
            sb.append("Case " + testCase + ": A forest of " + countOfTree + " trees.").append('\n');
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}