package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9934 {

    private static int depth;
    private static int numberOfNode;
    private static int[] order;
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer>[] depthNode;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        depth = Integer.parseInt(br.readLine());
        numberOfNode = calculateNumberOfNode();

        order = new int[numberOfNode];
        depthNode = new ArrayList[depth];

        for (int i = 0; i < depth; i++) {
            depthNode[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfNode; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int calculateNumberOfNode() {
        int numberOfNode = 1;

        for (int i = 0; i < depth; i++) {
            numberOfNode *= 2;
        }

        return --numberOfNode;
    }

    private static void process() {
        findCurrentNode(order, 0);

        for (ArrayList<Integer> list : depthNode) {
            for (Integer integer : list) {
                sb.append(integer).append(" ");
            }
            sb.append('\n');
        }
    }

    private static void findCurrentNode(int[] order, int currentDepth) {
        int currentIndex = order.length / 2;

        depthNode[currentDepth].add(order[currentIndex]);

        if (order.length == 1) {
            return;
        }

        int[] left = Arrays.copyOfRange(order, 0, currentIndex);
        int[] right = Arrays.copyOfRange(order, currentIndex + 1, order.length);

        findCurrentNode(left, currentDepth + 1);
        findCurrentNode(right, currentDepth + 1);
    }

    private static void output() {
        System.out.println(sb);
    }

}
