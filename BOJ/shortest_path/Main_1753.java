package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {

    private static int numberOfVertex;
    private static int numberOfEdge;
    private static int startVertex;
    private static int[] minimumDistanceFromStart;
    private static ArrayList<Node>[] adjacencyList;

    static class Node {
        int number;
        int distance;

        public Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }

        public int getNumber() {
            return number;
        }

        public int getDistance() {
            return distance;
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

        adjacencyList = new ArrayList[numberOfVertex + 1];
        minimumDistanceFromStart = new int[numberOfVertex + 1];

        for (int i = 1; i <= numberOfVertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        startVertex = Integer.parseInt(st.nextToken());

        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            adjacencyList[from].add(new Node(to, distance));
        }
    }

    private static void process() {
        dijkstra(startVertex);
    }

    private static void dijkstra(int startVertex) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));

        for (int i = 1; i <= numberOfVertex; i++) {
            if (i == startVertex) {
                minimumDistanceFromStart[i] = 0;
            } else {
                minimumDistanceFromStart[i] = Integer.MAX_VALUE;
            }
        }

        queue.add(new Node(startVertex, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentNodeNumber = currentNode.getNumber();
            int currentNodeDistance = currentNode.getDistance();

            if (currentNodeDistance > minimumDistanceFromStart[currentNodeNumber]) {
                continue;
            }

            for (Node nextNode : adjacencyList[currentNodeNumber]) {
                int nextNodeNumber = nextNode.getNumber();
                int nextNodeDistance = nextNode.getDistance();

                if (currentNodeDistance + nextNodeDistance > minimumDistanceFromStart[nextNodeNumber]) {
                    continue;
                }

                minimumDistanceFromStart[nextNodeNumber] = currentNodeDistance + nextNodeDistance;
                queue.add(new Node(nextNodeNumber, minimumDistanceFromStart[nextNodeNumber]));
            }
        }
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= numberOfVertex; i++) {
            int minimumDistance = minimumDistanceFromStart[i];

            if (minimumDistance == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }

            sb.append(minimumDistance).append("\n");
        }

        System.out.println(sb);
    }

}
