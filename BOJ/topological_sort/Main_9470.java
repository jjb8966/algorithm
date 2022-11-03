package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9470 {

    private static int testCaseNumber;
    private static int numberOfVertex;
    private static int numberOfEdge;
    private static int[] inDegree;
    private static int[] order;
    private static int[] maxOrder;
    private static ArrayList<Integer>[] adjacencyList;
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

        st = new StringTokenizer(br.readLine());
        testCaseNumber = Integer.parseInt(st.nextToken());
        numberOfVertex = Integer.parseInt(st.nextToken());
        numberOfEdge = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[numberOfVertex + 1];
        inDegree = new int[numberOfVertex + 1];
        order = new int[numberOfVertex + 1];
        maxOrder = new int[numberOfVertex + 1];

        for (int i = 1; i <= numberOfVertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            inDegree[b]++;
        }
    }

    private static void process() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= numberOfVertex; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                order[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            for (Integer nextVertex : adjacencyList[vertex]) {
                updateOrder(nextVertex, order[vertex]);
                inDegree[nextVertex]--;

                if (inDegree[nextVertex] == 0) {
                    queue.add(nextVertex);
                }
            }

            adjacencyList[vertex].clear();
        }

        sb.append(testCaseNumber).append(" ").append(order[numberOfVertex]).append('\n');
    }

    private static void updateOrder(int vertex, int previousOrder) {
        if (previousOrder > order[vertex]) {
            maxOrder[vertex] = previousOrder;
            order[vertex] = maxOrder[vertex];

            return;
        }

        if (previousOrder == order[vertex] && maxOrder[vertex] == previousOrder) {
            order[vertex]++;
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}
