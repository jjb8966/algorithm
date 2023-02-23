package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14675 {

    private static int numberOfNode;
    private static int numberOfQuestion;
    private static Question[] questions;
    private static ArrayList<Integer>[] adjacencyList;
    private static StringBuilder sb = new StringBuilder();

    static class Question {
        int deleteNodeOrEdge;
        int nodeOrEdge;

        public Question(int deleteNodeOrEdge, int nodeOrEdge) {
            this.deleteNodeOrEdge = deleteNodeOrEdge;
            this.nodeOrEdge = nodeOrEdge;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfNode = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[numberOfNode + 1];

        for (int i = 1; i <= numberOfNode; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        numberOfQuestion = Integer.parseInt(br.readLine());

        questions = new Question[numberOfQuestion];

        for (int i = 0; i < numberOfQuestion; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            questions[i] = new Question(a, b);
        }
    }

    private static void process() {
        for (int i = 0; i < numberOfQuestion; i++) {
            int deleteNodeOrEdge = questions[i].deleteNodeOrEdge;
            int nodeOrEdge = questions[i].nodeOrEdge;

            if (deleteNodeOrEdge == 1) {
                if (isRootOrLeafNode(nodeOrEdge)) {
                    sb.append("no").append('\n');
                } else {
                    sb.append("yes").append('\n');
                }
            }

            if (deleteNodeOrEdge == 2) {
                sb.append("yes").append('\n');
            }
        }
    }

    private static boolean isRootOrLeafNode(int nodeOrEdge) {
        return adjacencyList[nodeOrEdge].size() == 1;
    }

    private static void output() {
        System.out.println(sb);
    }

}
