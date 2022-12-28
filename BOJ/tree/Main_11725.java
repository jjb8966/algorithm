package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725 {

    private static int numberOfNode;
    private static int[] parent;
    private static ArrayList<Integer>[] adjacencyList;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfNode = Integer.parseInt(br.readLine());

        parent = new int[numberOfNode + 1];
        adjacencyList = new ArrayList[numberOfNode + 1];

        for (int i = 1; i <= numberOfNode; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            adjacencyList[node1].add(node2);
            adjacencyList[node2].add(node1);
        }
    }

    private static void process() {
        dfs(1, -1);
    }

    private static void dfs(int node, int parentNode) {
        parent[node] = parentNode;

        for (Integer childNode : adjacencyList[node]) {
            if (childNode == parentNode) {
                continue;
            }

            dfs(childNode, node);
        }
    }

    private static void output() {
        for (int index = 2; index <= numberOfNode; index++) {
            System.out.println(parent[index]);
        }
    }

}