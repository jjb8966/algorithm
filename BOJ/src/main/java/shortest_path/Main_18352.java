package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18352 {

    private static int numberOfVertex;
    private static int numberOfEdge;
    private static int targetDistance;
    private static int startVertex;
    private static int[] distance;
    private static ArrayList<Integer> result = new ArrayList<>();
    private static ArrayList<Integer>[] adjacencyList;

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
        targetDistance = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());

        distance = new int[numberOfVertex + 1];
        adjacencyList = new ArrayList[numberOfVertex + 1];

        for (int i = 1; i <= numberOfVertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
        }
    }

    private static void process() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            for (Integer nextVertex : adjacencyList[vertex]) {
                if (distance[nextVertex] != 0) {
                    continue;
                }

                if (nextVertex == startVertex) {
                    continue;
                }

                distance[nextVertex] = distance[vertex] + 1;
                queue.add(nextVertex);
            }
        }

        for (int vertex = 1; vertex <= numberOfVertex; vertex++) {
            if (distance[vertex] == targetDistance) {
                result.add(vertex);
            }
        }

        if (result.isEmpty()) {
            result.add(-1);
        }

        Collections.sort(result);
    }

    private static void output() {
        for (Integer vertex : result) {
            System.out.println(vertex);
        }
    }

}
