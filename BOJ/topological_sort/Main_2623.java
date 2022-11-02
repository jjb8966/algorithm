package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2623 {

    private static int numberOfNode;
    private static int numberOfSubSequence;
    private static int[] inDegree;
    private static ArrayList<Integer>[] adjacencyList;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        numberOfSubSequence = Integer.parseInt(st.nextToken());

        inDegree = new int[numberOfNode + 1];
        adjacencyList = new ArrayList[numberOfNode + 1];

        for (int i = 1; i <= numberOfNode; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfSubSequence; i++) {
            String[] subSequence = br.readLine().split(" ");

            int size = Integer.parseInt(subSequence[0]);

            for (int j = 1; j < size; j++) {
                int a = Integer.parseInt(subSequence[j]);
                int b = Integer.parseInt(subSequence[j + 1]);

                adjacencyList[a].add(b);
                inDegree[b]++;
            }
        }
    }

    private static void process() {
        topologicalSort();
    }

    private static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= numberOfNode; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            result.add(node);
            sb.append(node).append('\n');

            for (Integer nextNode : adjacencyList[node]) {
                inDegree[nextNode]--;

                if (inDegree[nextNode] == 0) {
                    queue.add(nextNode);
                }
            }
        }

        if (result.size() != numberOfNode) {
            sb.setLength(0);
            sb.append(0);
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}
