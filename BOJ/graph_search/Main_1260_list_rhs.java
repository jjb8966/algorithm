package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 인접 리스트를 사용한 dfs, bfs 구현
 * ArrayList 배열의 초기화 및 정렬하는 방법 숙달 필요
 */
public class Main_1260_list_rhs {
    private static StringBuilder sb = new StringBuilder();
    private static int vertex;
    private static int edge;
    private static int startNumber;
    private static boolean[] visit;
    private static ArrayList<Integer>[] adjacencyList;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        startNumber = Integer.parseInt(st.nextToken());

        visit = new boolean[vertex + 1];                // 인덱스 1 ~ vertex 사용
        adjacencyList = new ArrayList[vertex + 1];

        // 각 vertex마다 ArrayList 객체 생성
        for (int i = 1; i <= vertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // 어떤 vertex끼리 연결되는지 입력받음
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int a;
            int b;

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        // ArrayList 배열의 경우 정렬하려면 각각의 ArrayList마다 sort 해줘야 함
        for (int i = 1; i <= vertex; i++) {
            Collections.sort(adjacencyList[i]);
        }
    }

    // number 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int number) {
        // number 를 방문했다.
        visit[number] = true;

        sb.append(number).append(' ');

        // number 에서 갈 수 있는 곳들을 작은 번호부터 모두 방문한다.
        for (int i : adjacencyList[number]) {

            // 현재 노드와 연결된 노드를 재귀적으로 방문
            if (!visit[i]) {
                dfs(i);
            }
        }
    }

    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        // start 는 방문 가능한 점이므로 queue 에 넣어준다.
        queue.add(start);
        visit[start] = true;  // start 를 갈 수 있다고 표시하기 (중요!!!)

        while (!queue.isEmpty()) {  // 더 확인할 점이 없다면 정지
            int number = queue.poll();

            sb.append(number).append(' ');

            for (int i : adjacencyList[number]) {
                // 해당 노드와 연결된 노드 중 방문하지 않은 노드들을 큐에 넣고 방문 처리
                if (!visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }

    static void pro() {
        dfs(startNumber);
        sb.append('\n');

        for (int i = 1; i <= vertex; i++) {
            visit[i] = false;
        }

        bfs(startNumber);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
