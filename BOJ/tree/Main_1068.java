package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1068 {

    private static int numberOfNode;
    private static int eraseNode;
    private static int rootNode;
    private static int[] countLeafNode;
    private static int[] parent;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfNode = Integer.parseInt(br.readLine());

        parent = new int[numberOfNode];
        countLeafNode = new int[numberOfNode];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numberOfNode; i++) {
            parent[i] = Integer.parseInt(st.nextToken());

            if (parent[i] == -1) {
                rootNode = i;
            }
        }

        eraseNode = Integer.parseInt(br.readLine());
    }

    private static void process() {
        // 지우려는 노드가 루트 노드인 경우 -> 0을 출력하고 프로그램 종료
        if (rootNode == eraseNode) {
            System.out.println(0);
            System.exit(0);
        }

        removeNode();
        dfs(rootNode);
    }

    private static void removeNode() {
        parent[eraseNode] = -1;
    }

    private static void dfs(int node) {
        ArrayList<Integer> myChildren = new ArrayList<>();

        // 자식 노드들을 먼저 구함
        for (int candidate = 0; candidate < numberOfNode; candidate++) {
            if (candidate != node && parent[candidate] == node) {
                myChildren.add(candidate);
            }
        }

        // 자식이 없다면 리프노드
        if (myChildren.size() == 0) {
            countLeafNode[node] = 1;
            return;
        }

        // 모든 자식들에 대해 dfs
        for (Integer child : myChildren) {
            dfs(child);     // 자식에 대한 dfs 가 모두 끝나면 자식의 countLeafNode를 알 수 있음
        }

        while (!myChildren.isEmpty()) {
            // 리프 노드 갯수 = 자식들의 리프 노드 갯수 합
            countLeafNode[node] += countLeafNode[myChildren.remove(0)];
        }
    }

    private static void output() {
        System.out.println(countLeafNode[rootNode]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
