package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_5639 {

    private static Node rootNode;
    private static Queue<Integer> resultOfPreOrder = new LinkedList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while ((input = br.readLine()) != null && !input.equals("")) {
            resultOfPreOrder.add(Integer.parseInt(input));
        }
    }

    private static void process() {
        makeTree();
        postOrder(rootNode);
    }

    private static void makeTree() {
        Node currentNode = new Node(resultOfPreOrder.poll());
        rootNode = currentNode;

        while (!resultOfPreOrder.isEmpty()) {
            Node nextNode = new Node(resultOfPreOrder.poll());

            if (nextNode.key < currentNode.key) {
                currentNode.leftNode = nextNode;
                nextNode.parentNode = currentNode;
            }

            if (nextNode.key > currentNode.key) {
                findParentNode(nextNode, currentNode);
            }

            currentNode = nextNode;
        }
    }

    private static void findParentNode(Node node, Node currentNode) {
        if (currentNode == rootNode) {
            rootNode.rightNode = node;
            node.parentNode = rootNode;

            return;
        }

        Node currentParent = currentNode.parentNode;

        if (node.key < currentParent.key) {
            currentNode.rightNode = node;
            node.parentNode = currentNode;
        }

        if (node.key > currentParent.key) {
            findParentNode(node, currentParent);
        }
    }

    private static void postOrder(Node node) {
        Node leftNode = node.leftNode;
        Node rightNode = node.rightNode;

        if (leftNode != null) {
            postOrder(leftNode);
        }

        if (rightNode != null) {
            postOrder(rightNode);
        }

        sb.append(node.key).append('\n');
    }

    private static void output() {
        System.out.println(sb);
    }

    static class Node {
        int key;
        Node parentNode;
        Node leftNode;
        Node rightNode;

        public Node(int key) {
            this.key = key;
        }
    }

}
