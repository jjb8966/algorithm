package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725 {
    private static ArrayList<Integer>[] adjacencyList;
    private static int countOfNode;
    private static int[] parentNode;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        countOfNode = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[countOfNode + 1];     // 노드의 인덱스 : 1 ~ countOfNode
        parentNode = new int[countOfNode + 1];

        for (int i = 1; i <= countOfNode; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < countOfNode - 1; i++) {         // 트리에서 간선의 수 -> E = V - 1
            st = new StringTokenizer(br.readLine());

            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            adjacencyList[vertex1].add(vertex2);
            adjacencyList[vertex2].add(vertex1);
        }
    }

    public static void dfs(int vertex, int parent) {    // dfs로 모든 정점의 부모 노드 구함
        parentNode[vertex] = parent;

        for (int temp : adjacencyList[vertex]) {        // vertex의 모든 child에 대해 dfs
            if (temp == parent) {
                continue;
            }

            dfs(temp, vertex);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(1, -1);

        for (int i = 2; i < countOfNode + 1; i++) {
            System.out.println(parentNode[i]);
        }
    }
}
