package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252 {

    private static int numberOfStudent;
    private static int numberOfComparison;

    private static ArrayList<Integer>[] adjacencyList;
    private static StringBuilder sb = new StringBuilder();
    private static int[] inDegree;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfStudent = Integer.parseInt(st.nextToken());
        numberOfComparison = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[numberOfStudent + 1]; // index : 1 ~ numberOfStudent
        inDegree = new int[numberOfStudent + 1];

        for (int i = 1; i <= numberOfStudent; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= numberOfComparison; i++) {
            st = new StringTokenizer(br.readLine());
            int smallOne = Integer.parseInt(st.nextToken());
            int bigOne = Integer.parseInt(st.nextToken());

            adjacencyList[smallOne].add(bigOne);    // smallOne -> bigOne
            inDegree[bigOne]++;
        }
    }

    private static void process() {
        topologicalSort();
    }

    private static void topologicalSort() {
        Queue<Integer> inDegreeZeroVertex = new LinkedList<>();

        for (int i = 1; i <= numberOfStudent; i++) {
            if (inDegree[i] == 0) {
                inDegreeZeroVertex.add(i);
            }
        }

        while (!inDegreeZeroVertex.isEmpty()) {
            int vertex = inDegreeZeroVertex.poll();

            sb.append(vertex).append(' ');

            for (Integer taller : adjacencyList[vertex]) {
                inDegree[taller]--;

                // 여기서 queue에 들어갈 정점을 체크하는게 시간을 줄이는 핵심 방법
                // + 어차피 모든 정점이 큐에 한번씩만 들어가므로 visit 체크를 할 필요도 없음
                if (inDegree[taller] == 0) {
                    inDegreeZeroVertex.add(taller);
                }
            }
        }
    }

    private static void output() {
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}