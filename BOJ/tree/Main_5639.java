package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_5639 {

    private static Node rootNode;
    private static Queue<Integer> queue = new LinkedList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    static class Node {
        int key;
        Node leftNode;
        Node rightNode;

        public Node(int key) {
            this.key = key;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        while (true) {
            String temp = br.readLine();

            if (temp == null || temp.equals("")) {
                break;
            }

            queue.add(Integer.parseInt(temp));
        }
    }

    private static void process() {
        makeTree();
        postOrder(rootNode);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.leftNode);
        postOrder(node.rightNode);

        sb.append(node.key).append('\n');
    }

    private static void makeTree() {
        rootNode = new Node(queue.poll());

        while (!queue.isEmpty()) {
            insertNode(rootNode, queue.poll());
        }
    }

    private static void insertNode(Node node, Integer insertKey) {
        if (insertKey < node.key) {
            if (node.leftNode == null) {
                node.leftNode = new Node(insertKey);
            } else {
                insertNode(node.leftNode, insertKey);
            }
        }

        if (insertKey > node.key) {
            if (node.rightNode == null) {
                node.rightNode = new Node(insertKey);
            } else {
                insertNode(node.rightNode, insertKey);
            }
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}