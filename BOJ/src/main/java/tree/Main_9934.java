package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_9934 {

    private static int depthOfTree;
    private static int numberOfNode;
    private static int[] nodes;
    private static ArrayList<Integer>[] nodesWithDepth;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        depthOfTree = Integer.parseInt(br.readLine());
        numberOfNode = getNumberOfNode(depthOfTree);

        nodes = new int[numberOfNode];
        nodesWithDepth = new ArrayList[depthOfTree];

        for (int i = 0; i < depthOfTree; i++) {
            nodesWithDepth[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfNode; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int getNumberOfNode(int depth) {
        int result = 1;

        for (int i = 0; i < depth; i++) {
            result *= 2;
        }

        return result - 1;
    }

    private static void process() {
        findNode(0, numberOfNode - 1, 0);

        for (ArrayList<Integer> nodes : nodesWithDepth) {
            nodes.forEach(node -> sb.append(node + " "));
            sb.append('\n');
        }
    }

    private static void findNode(int start, int end, int level) {
        int currentNodeIndex = (start + end) / 2;

        nodesWithDepth[level].add(nodes[currentNodeIndex]);

        if (start == end) {
            return;
        }

        findNode(start, currentNodeIndex - 1, level + 1);
        findNode(currentNodeIndex + 1, end, level + 1);
    }

    private static void output() {
        System.out.println(sb);
    }

}