package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15681 {

    private static StringBuilder sb = new StringBuilder();
    private static int numberOfNode;
    private static int root;
    private static int numberOfSubRoot;
    private static int[] subRoot;
    private static int[] parent;
    private static int[] countOfSubTreeNode;
    private static ArrayList<Integer>[] adjacencyList;

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

        adjacencyList = new ArrayList[numberOfNode + 1];    // 1 ~ numberOfNode
        subRoot = new int[numberOfSubRoot + 1];
        parent = new int[numberOfNode + 1];
        countOfSubTreeNode = new int[numberOfNode + 1];

        for (int i = 1; i <= numberOfNode; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        for (int i = 1; i <= numberOfSubRoot; i++) {
            st = new StringTokenizer(br.readLine());
            subRoot[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        updateParent(root);
        updateCountOfSubTreeNode(root);

        for (int i = 1; i <= numberOfSubRoot; i++) {
            int count = countOfSubTreeNode[subRoot[i]];

            sb.append(count + 1).append("\n");
        }
    }

    private static void updateParent(int root) {
        for (Integer child : adjacencyList[root]) {
            if (child == parent[root]) {
                continue;
            }

            parent[child] = root;

            updateParent(child);
        }
    }

    private static void updateCountOfSubTreeNode(int root) {
        int sum = 0;

        for (Integer child : adjacencyList[root]) {
            if (child == parent[root]) {
                continue;
            }

            updateCountOfSubTreeNode(child);

            sum += countOfSubTreeNode[child];
        }

        long children = adjacencyList[root].stream()
                .filter(n -> n != parent[root])
                .count();

        sum += children;

        countOfSubTreeNode[root] = sum;
    }

    private static void output() {
        System.out.println(sb);
    }

}
