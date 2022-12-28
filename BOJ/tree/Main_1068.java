package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1068 {

    private static int numberOfNode;
    private static int removedNode;
    private static int rootNode;
    private static int countLeafNode;
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

        parent = new int[numberOfNode];
        adjacencyList = new ArrayList[numberOfNode];

        for (int i = 0; i < numberOfNode; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int node = 0; node < numberOfNode; node++) {
            int parentNode = Integer.parseInt(st.nextToken());

            if (parentNode == -1) {
                rootNode = node;
            }

            parent[node] = parentNode;

            if (parentNode != -1) {
                adjacencyList[parentNode].add(node);
            }
        }

        removedNode = Integer.parseInt(br.readLine());

    }

    private static void process() {
        if (removedNode == rootNode) {
            return;
        }

        removeNode();
        findLeafNode(rootNode);
    }

    private static void removeNode() {
        int parentNode = parent[removedNode];

        adjacencyList[parentNode].remove((Integer) removedNode);
    }

    private static void findLeafNode(int node) {
        boolean hasChildren = false;

        for (Integer childNode : adjacencyList[node]) {
            hasChildren = true;
            findLeafNode(childNode);
        }

        if (!hasChildren) {
            countLeafNode++;
        }
    }

    private static void output() {
        System.out.println(countLeafNode);
    }

}