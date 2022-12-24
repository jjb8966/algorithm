package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1753_dijkstra {

    private static int numberOfVertex;
    private static int numberOfEdge;
    private static int startVertex;
    private static int[] minDistance;
    private static List<Node>[] adjacencyList;

    static class Node {

        int number;
        int distance;

        public Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
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

        st = new StringTokenizer(br.readLine());
        numberOfVertex = Integer.parseInt(st.nextToken());
        numberOfEdge = Integer.parseInt(st.nextToken());

        startVertex = Integer.parseInt(br.readLine());

        minDistance = new int[numberOfVertex + 1];
        adjacencyList = new ArrayList[numberOfVertex + 1];

        for (int i = 1; i <= numberOfVertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            adjacencyList[start].add(new Node(destination, distance));
        }
    }

    private static void process() {
        dijkstra(startVertex);
    }

    private static void dijkstra(int startVertex) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        initMinDistance();
        queue.add(new Node(startVertex, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nodeNumber = node.number;
            int nodeDistance = node.distance;

            if (nodeDistance > minDistance[nodeNumber]) {
                continue;
            }

            for (Node nextNode : adjacencyList[nodeNumber]) {
                int nextNodeNumber = nextNode.number;
                int newDistance = minDistance[nodeNumber] + nextNode.distance;

                if (newDistance >= minDistance[nextNodeNumber]) {
                    continue;
                }

                minDistance[nextNodeNumber] = newDistance;
                queue.add(new Node(nextNodeNumber, newDistance));
            }
        }
    }

    private static void initMinDistance() {
        for (int i = 1; i <= numberOfVertex; i++) {
            minDistance[i] = Integer.MAX_VALUE;

            if (i == startVertex) {
                minDistance[i] = 0;
            }
        }
    }

    private static void output() {
        for (int i = 1; i <= numberOfVertex; i++) {
            if (i != startVertex && minDistance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(minDistance[i]);
            }
        }
    }

}