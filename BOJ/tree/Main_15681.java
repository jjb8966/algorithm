package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15681 {

    private static int numberOfNode;
    private static int root;
    private static int numberOfSubRoot;
    private static int[] subRoot;
    private static int[] subTreeNodes;
    private static int[] parent;
    private static List<Integer>[] adjacencyList;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        numberOfSubRoot = Integer.parseInt(st.nextToken());

        adjacencyList = new List[numberOfNode + 1];
        subTreeNodes = new int[numberOfNode + 1];
        parent = new int[numberOfNode + 1];
        subRoot = new int[numberOfSubRoot];

        for (int i = 1; i <= numberOfNode; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        for (int i = 0; i < numberOfSubRoot; i++) {
            subRoot[i] = Integer.parseInt(br.readLine());
        }

    }

    private static void process() {
        updateParent(root);
        countSubTreeNodes(root);

        for (int i = 0; i < numberOfSubRoot; i++) {
            sb.append(subTreeNodes[subRoot[i]]).append('\n');
        }
    }

    private static void updateParent(int node) {
        for (Integer adjacencyNode : adjacencyList[node]) {
            if (adjacencyNode == parent[node]) {
                continue;
            }

            parent[adjacencyNode] = node;
            updateParent(adjacencyNode);
        }
    }

    private static void countSubTreeNodes(int node) {
        subTreeNodes[node] += 1;

        for (Integer adjacencyNode : adjacencyList[node]) {
            if (adjacencyNode == parent[node]) {
                continue;
            }

            countSubTreeNodes(adjacencyNode);
            subTreeNodes[node] += subTreeNodes[adjacencyNode];
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}
