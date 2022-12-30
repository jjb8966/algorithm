package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5639 {

    private static int numberOfNode;
    private static int[] nodes = new int[100_000];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String node = br.readLine();
        int index = 0;

        while (node != null && !node.equals("")) {
            nodes[index++] = Integer.parseInt(node);
            node = br.readLine();
        }

        numberOfNode = index;
    }

    private static void process() {
        postOrder(0, numberOfNode - 1);
    }

    private static void postOrder(int start, int end) {
        int currentNode = nodes[start];
        int startRightNode = end + 1;

        if (start > end) {
            return;
        }

        for (int index = start + 1; index <= end; index++) {
            if (nodes[index] > currentNode) {
                startRightNode = index;
                break;
            }
        }

        postOrder(start + 1, startRightNode - 1);
        postOrder(startRightNode, end);

        sb.append(currentNode).append('\n');
    }

    private static void output() {
        System.out.println(sb);
    }

}