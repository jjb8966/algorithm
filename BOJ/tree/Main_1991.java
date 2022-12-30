package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991 {

    private static int numberOfNode;
    private static int[][] nodes;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfNode = Integer.parseInt(br.readLine());
        nodes = new int[numberOfNode][2];

        for (int i = 0; i < numberOfNode; i++) {
            st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            nodes[node][0] = left;
            nodes[node][1] = right;
        }
    }

    private static void process() {
        preOrder(0);
        sb.append('\n');

        inOrder(0);
        sb.append('\n');

        postOrder(0);
    }

    private static void preOrder(int node) {
        sb.append((char) (node + 'A'));

        if (nodes[node][0] >= 0) {
            preOrder(nodes[node][0]);
        }

        if (nodes[node][1] >= 0) {
            preOrder(nodes[node][1]);
        }
    }

    private static void inOrder(int node) {
        if (nodes[node][0] >= 0) {
            inOrder(nodes[node][0]);
        }

        sb.append((char) (node + 'A'));

        if (nodes[node][1] >= 0) {
            inOrder(nodes[node][1]);
        }
    }

    private static void postOrder(int node) {
        if (nodes[node][0] >= 0) {
            postOrder(nodes[node][0]);
        }

        if (nodes[node][1] >= 0) {
            postOrder(nodes[node][1]);
        }

        sb.append((char) (node + 'A'));
    }

    private static void output() {
        System.out.println(sb);
    }

}