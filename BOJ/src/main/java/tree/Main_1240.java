package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1240 {

    private static int numberOfNode;
    private static int numberOfTarget;
    private static int[][] distance;
    private static int[][] target;
    private static boolean[][] connect;

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
        numberOfTarget = Integer.parseInt(st.nextToken());

        distance = new int[numberOfNode + 1][numberOfNode + 1];
        connect = new boolean[numberOfNode + 1][numberOfNode + 1];
        target = new int[numberOfTarget][2];


        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            distance[a][b] = d;
            distance[b][a] = d;
            connect[a][b] = true;
            connect[b][a] = true;
        }

        for (int i = 0; i < numberOfTarget; i++) {
            st = new StringTokenizer(br.readLine());

            target[i][0] = Integer.parseInt(st.nextToken());
            target[i][1] = Integer.parseInt(st.nextToken());
        }

    }

    private static void process() {
        for (int i = 0; i < numberOfTarget; i++) {
            int start = target[i][0];
            int destination = target[i][1];

            if (distance[start][destination] != 0) {
                continue;
            }

            if (distance[destination][start] != 0) {
                distance[start][destination] = distance[destination][start];
                return;
            }

            searchAllDistance(start);
        }
    }

    private static void searchAllDistance(int start) {
        List<Integer> connectNodes = getAdjacencyNodes(start);

        for (int connectNode : connectNodes) {
            List<Integer> nextNodes = getAdjacencyNodes(connectNode);

            for (int nextNode : nextNodes) {
                searchNextDistance(start, connectNode, nextNode);
            }
        }
    }

    private static void searchNextDistance(int start, int connectNode, int nextNode) {
        if (nextNode == start) {
            return;
        }

        distance[start][nextNode] = distance[start][connectNode] + distance[connectNode][nextNode];
        distance[nextNode][start] = distance[start][nextNode];

        List<Integer> nextAdjacencyNodes = getAdjacencyNodes(nextNode);

        for (int nextAdjacencyNode : nextAdjacencyNodes) {
            if (nextAdjacencyNode == connectNode) {
                continue;
            }

            searchNextDistance(start, nextNode, nextAdjacencyNode);
        }
    }

    private static List<Integer> getAdjacencyNodes(int node) {
        List<Integer> result = new ArrayList<>();

        for (int adjacencyNode = 1; adjacencyNode <= numberOfNode; adjacencyNode++) {
            if (connect[node][adjacencyNode]) {
                result.add(adjacencyNode);
            }
        }

        return result;
    }

    private static void output() {
        for (int i = 0; i < numberOfTarget; i++) {
            int start = target[i][0];
            int destination = target[i][1];

            System.out.println(distance[start][destination]);
        }
    }

}
