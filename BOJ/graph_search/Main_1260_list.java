package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 인접 리스트를 사용한 dfs, bfs 구현
 * ArrayList 배열의 초기화 및 정렬하는 방법 숙달 필요
 */
public class Main_1260_list {
    private static StringBuilder sb = new StringBuilder();
    private static int vertex;
    private static int edge;
    private static int startNumber;
    private static boolean[] visit;
    private static ArrayList<Integer>[] adjacencyList;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st1.nextToken());
        edge = Integer.parseInt(st1.nextToken());
        startNumber = Integer.parseInt(st1.nextToken());

        visit = new boolean[vertex + 1];                // 인덱스 1 ~ vertex 사용
        adjacencyList = new ArrayList[vertex + 1];

        // 각 vertex마다 ArrayList 객체 생성
        for (int i = 1; i <= vertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // 어떤 vertex끼리 연결되는지 입력받음
        for (int i = 0; i < edge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a, b;

            a = Integer.parseInt(st2.nextToken());
            b = Integer.parseInt(st2.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        // ArrayList 배열의 경우 정렬하려면 각각의 ArrayList마다 sort 해줘야 함
        for (int i = 1; i <= vertex; i++) {
            Collections.sort(adjacencyList[i]);
        }
    }

    public static void dfs(int number) {        // 재귀함수로 구현
        //number 방문
        visit[number] = true;
        sb.append(number).append(" ");

        for (int temp : adjacencyList[number]) {
            if (visit[temp] == true) {
                continue;
            }

            dfs(temp);      // temp를 dfs하면 temp를 방문한 것
        }
    }

    public static void bfs(int number) {        // Queue를 이용하여 구현
        Queue<Integer> queue = new LinkedList<>();

        queue.add(number);                      // queue에 넣는 정점은 방문 가능한 것
        sb.append(number).append(" ");
        visit[number] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();            // queue에 들어있던 것을 poll해서 그 정점이 연결된 모든 정점에 대해 탐색

            for (int i : adjacencyList[temp]) {
                if (visit[i]) {
                    continue;
                }

                queue.add(i);                   // 탐색 가능한 정점을 queue에 넣음
                sb.append(i).append(" ");
                visit[i] = true;
            }
        }
    }

    public static void resetVariable() {
        for (int i = 1; i <= vertex; i++) {
            visit[i] = false;
        }

        sb.setLength(0);
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(startNumber);
        System.out.println(sb);
        resetVariable();
        bfs(startNumber);
        System.out.println(sb);
    }
}
