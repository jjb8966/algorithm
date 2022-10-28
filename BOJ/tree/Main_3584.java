package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3584 {

    private static int numberOfNode;
    private static int rootNode;
    private static int[] target = new int[2];
    private static int[] parent;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();
            process();
        }

        output();
    }

    private static void input() throws IOException {
        StringTokenizer st;

        numberOfNode = Integer.parseInt(br.readLine());

        parent = new int[numberOfNode + 1];

        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            parent[b] = a;
        }

        st = new StringTokenizer(br.readLine());

        target[0] = Integer.parseInt(st.nextToken());
        target[1] = Integer.parseInt(st.nextToken());

        for (int node = 1; node <= numberOfNode; node++) {
            if (parent[node] == 0) {
                rootNode = node;
            }
        }
    }

    private static void process() {
        int candidate = target[0];

        while (candidate != rootNode) {
            if (isCommonAncestor(candidate)) {
                return;
            }

            candidate = parent[candidate];
        }

        sb.append(rootNode).append('\n');
    }

    private static boolean isCommonAncestor(int candidate) {
        int node = target[1];

        while (node != rootNode) {
            if (node == candidate) {
                sb.append(candidate).append('\n');
                return true;
            }

            node = parent[node];
        }

        return false;
    }

    private static void output() {
        System.out.println(sb);
    }

}
