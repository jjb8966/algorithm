package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1068 {
    private static int countOfNode;
    private static int erasedNode;
    private static int rootNode;
    private static int sumOfLeafNode = 0;
    private static int[] parentOfNode;
    private static ArrayList<Integer>[] adjacencyList;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        countOfNode = Integer.parseInt(br.readLine());

        parentOfNode = new int[countOfNode];
        adjacencyList = new ArrayList[countOfNode];

        for (int i = 0; i < countOfNode; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < countOfNode; i++) {
            parentOfNode[i] = Integer.parseInt(temp[i]);

            if (parentOfNode[i] == -1) {        // 부모 노드가 -1이면 루트 노드
                rootNode = i;
            }
        }

        erasedNode = Integer.parseInt(br.readLine());       // 트리에서 지울 노드

        for (int i = 0; i < countOfNode; i++) {
            if (parentOfNode[i] != -1) {                    // 부모 노드의 정보를 활용하여 adjacencyList를 만듦
                adjacencyList[i].add(parentOfNode[i]);
                adjacencyList[parentOfNode[i]].add(i);
            }
        }
    }

    private static void erase(int node) {   // 매개변수로 넘겨받은 노드를 지움 -> 해당 노드와 부모 노드 사이의 관계를 끊음
        if (node == rootNode) {             // rootNode가 매개변수로 넘어오면 리프 노드는 0
            System.out.println("0");
            System.exit(0);
        }

        adjacencyList[parentOfNode[node]].remove((Integer) node);   // 해당 노드의 부모 노드에서 해당 노드의 정보 삭제
    }

    public static void dfs(int node) {
        if (adjacencyList[node].size() == 1 && parentOfNode[node] != -1) {  // adjacencyList의 크기가 1인 경우 -> 리프 노드 (루트 노드인 경우는 제외)
            sumOfLeafNode++;
        }

        if (adjacencyList[node].isEmpty()) {     // 루트 노드가 리프 노드가 되는 경우 -> 리프 노드 1
            sumOfLeafNode++;
        }

        for (int temp : adjacencyList[node]) {
            if (temp == parentOfNode[node]) {
                continue;
            }

            dfs(temp);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        erase(erasedNode);
        dfs(rootNode);
        System.out.println(sumOfLeafNode);
    }
}
