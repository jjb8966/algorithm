package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2606 {

    private static ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
    private static int numberOfVertex;
    private static int numberOfEdge;
    private static int numberOfInfectedComputer = 0;
    private static boolean[] visit;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfVertex = Integer.parseInt(br.readLine());
        numberOfEdge = Integer.parseInt(br.readLine());

        for (int i = 0; i <= numberOfVertex; i++) {  // 인덱스 1 ~ numberOfVertex 사용
            adjacencyList.add(new ArrayList<>());
        }

        visit = new boolean[numberOfVertex + 1];    // 인덱스 1 ~ numberOfVertex 사용

        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }

        for (ArrayList<Integer> integers : adjacencyList) {
            System.out.println("integers = " + integers);
        }
    }

    private static void dfs(int start) {
        visit[start] = true;
        numberOfInfectedComputer++;

        for (Integer index : adjacencyList.get(start)) {
            if (!visit[index]) {
                dfs(index);
            }
        }
    }

    private static void process() {
        // 1번 노드와 연결된 모든 노드 탐색
        dfs(1);

        // 1번 노드가 감염시킨 노드를 찾는것이므로 1번 노드 자신은 제외해야함
        System.out.println(--numberOfInfectedComputer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
