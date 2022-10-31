package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9489 {

    private static int numberOfNode;
    private static int targetNode;
    private static int[] nodes;
    private static int[] parent;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            input();

            if (numberOfNode == 0 && targetNode == 0) {
                break;
            }

            process();
        }

        output();
    }

    private static void input() throws IOException {
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        targetNode = Integer.parseInt(st.nextToken());

        if (numberOfNode == 0 && targetNode == 0) {
            return;
        }

        nodes = new int[numberOfNode];
        parent = new int[numberOfNode];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numberOfNode; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void process() {
        int result = 0;

        updateParent();

        int targetNodeIndex = getTargetNodeIndex();
        int parentIndex = parent[targetNodeIndex];

        if (parentIndex == -1 || parentIndex == 0) {
            sb.append(0).append('\n');
            return;
        }

        int grandParentIndex = parent[parentIndex];

        for (int i = 1; i < numberOfNode; i++) {
            if (parent[i] != parentIndex && parent[parent[i]] == grandParentIndex) {
                result++;
            }
        }

        sb.append(result).append('\n');
    }

    private static int getTargetNodeIndex() {
        int result = 0;

        for (int i = 1; i < numberOfNode; i++) {
            if (nodes[i] == targetNode) {
                result = i;
            }
        }

        return result;
    }

    private static void updateParent() {
        int nextNode = nodes[0] + 1;
        int parentIndex = -1;

        parent[0] = -1;

        for (int i = 1; i < numberOfNode; i++) {
            int node = nodes[i];

            if (node != nextNode) {
                parentIndex++;
                parent[i] = parentIndex;
                nextNode = node + 1;
            } else {
                parent[i] = parentIndex;
                nextNode++;
            }
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}