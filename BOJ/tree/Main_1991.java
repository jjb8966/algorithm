package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991 {

    private static int numberOfNode;
    private static int[][] node;
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

        node = new int[numberOfNode][2];    // node[x][0] : x의 왼쪽 노드, node[x][1] : x의 오른쪽 노드

        for (int i = 0; i < numberOfNode; i++) {
            st = new StringTokenizer(br.readLine());

            int currentNode = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            node[currentNode][0] = left;
            node[currentNode][1] = right;
        }

    }

    private static void process() {
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
        sb.append('\n');
    }

    private static void preOrder(int startNode) {
        sb.append((char) (startNode + 'A'));

        for (int i = 0; i < 2; i++) {
            int childNode = node[startNode][i];

            if (childNode < 0) {
                continue;
            }

            preOrder(childNode);
        }
    }

    private static void inOrder(int startNode) {
        for (int i = 0; i < 2; i++) {
            int childNode = node[startNode][i];

            if (i == 1) {
                sb.append((char) (startNode + 'A'));
            }

            if (childNode < 0) {
                continue;
            }

            inOrder(childNode);
        }
    }

    private static void postOrder(int startNode) {
        for (int i = 0; i < 2; i++) {
            int childNode = node[startNode][i];

            if (childNode < 0) {
                continue;
            }

            postOrder(childNode);
        }

        sb.append((char) (startNode + 'A'));
    }

    private static void output() {
        System.out.println(sb);
    }

}
