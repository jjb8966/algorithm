package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1325 {

    private static ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
    private static ArrayList<Integer> result = new ArrayList<>();
    private static int numberOfComputer;
    private static int numberOfRelationship;
    private static int maxNumberOfInfectedComputer = Integer.MIN_VALUE;
    private static boolean[] visited;
    private static int[] numberOfInfectedComputer;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfComputer = Integer.parseInt(st.nextToken());
        numberOfRelationship = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= numberOfComputer; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        visited = new boolean[numberOfComputer + 1];
        numberOfInfectedComputer = new int[numberOfComputer + 1];

        for (int i = 0; i < numberOfRelationship; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList.get(a).add(b);
        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (Integer childVertex : adjacencyList.get(start)) {
            if (!visited[childVertex]) {
                numberOfInfectedComputer[childVertex]++;
                dfs(childVertex);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int front = queue.poll();

            for (Integer adjacencyVertex : adjacencyList.get(front)) {
                if (!visited[adjacencyVertex]) {
                    queue.add(adjacencyVertex);
                    visited[adjacencyVertex] = true;
                    numberOfInfectedComputer[adjacencyVertex]++;
                }
            }
        }
    }

    private static void process() {
        // 모든 컴퓨터에 대해 자식 노드 (감염시킬 수 있는 컴퓨터) 조사
        for (int root = 1; root <= numberOfComputer; root++) {
            reset();
            bfs(root);
        }

        for (int i = 1; i <= numberOfComputer; i++) {
            if (maxNumberOfInfectedComputer < numberOfInfectedComputer[i]) {
                maxNumberOfInfectedComputer = numberOfInfectedComputer[i];
                result.clear();
                result.add(i);
            } else if (maxNumberOfInfectedComputer == numberOfInfectedComputer[i]) {
                result.add(i);
            }
        }

        Collections.sort(result);

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    private static void reset() {
        for (int i = 1; i <= numberOfComputer; i++) {
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}