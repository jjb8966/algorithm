package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15900 {

    private static int numberOfNode;
    private static int sumOfNodeDepth;
    private static ArrayList<Integer>[] adjacencyList;
    private static boolean[] visited;

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
        visited = new boolean[numberOfNode + 1];

        for (int node = 1; node <= numberOfNode; node++) {
            adjacencyList[node] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

    }

    private static void process() {
        dfs(1, 0);
    }

    private static void dfs(int node, int depth) {
        visited[node] = true;

        for (Integer child : adjacencyList[node]) {
            if (visited[child]) {
                continue;
            }

            dfs(child, depth + 1);
        }

        if (node != 1 && adjacencyList[node].size() == 1) {
            sumOfNodeDepth += depth;
        }
    }

    private static void output() {
        if (sumOfNodeDepth % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

}
