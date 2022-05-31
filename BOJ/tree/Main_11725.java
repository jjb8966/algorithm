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

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int vertex1;
        int vertex2;

        numberOfNode = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[numberOfNode + 1];
        parent = new int[numberOfNode + 1];

        for (int i = 1; i <= numberOfNode; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());

            vertex1 = Integer.parseInt(st.nextToken());
            vertex2 = Integer.parseInt(st.nextToken());

            adjacencyList[vertex1].add(vertex2);
            adjacencyList[vertex2].add(vertex1);
        }
    }

    private static void process() {
        dfs(1, -1);
    }

    private static void dfs(int node, int myParent) {
        parent[node] = myParent;

        for (Integer child : adjacencyList[node]) {
            if (child == myParent) {
                continue;
            }

            dfs(child, node);
        }
    }

    private static void output() {
        for (int i = 2; i <= numberOfNode; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
