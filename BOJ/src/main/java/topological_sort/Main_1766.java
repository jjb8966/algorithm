package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1766 {

    private static int numberOfProblem;
    private static int numberOfPrerequisite;
    private static int[] inDegree;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjacencyList;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfProblem = Integer.parseInt(st.nextToken());
        numberOfPrerequisite = Integer.parseInt(st.nextToken());

        inDegree = new int[numberOfProblem + 1];
        adjacencyList = new ArrayList[numberOfProblem + 1];
        visited = new boolean[numberOfProblem + 1];

        for (int i = 1; i <= numberOfProblem; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfPrerequisite; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            inDegree[b]++;
        }
    }

    private static void process() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(findMinimumProblem());

        while (!queue.isEmpty()) {
            Integer problem = queue.poll();

            for (Integer nextProblem : adjacencyList[problem]) {
                inDegree[nextProblem]--;
            }

            int minimumProblem = findMinimumProblem();

            if (minimumProblem != -1) {
                queue.add(minimumProblem);
            }
        }
    }

    private static int findMinimumProblem() {
        int minimumProblem = Integer.MAX_VALUE;

        for (int problem = 1; problem <= numberOfProblem; problem++) {
            if (visited[problem]) {
                continue;
            }

            if (inDegree[problem] == 0 && problem < minimumProblem) {
                minimumProblem = problem;
            }
        }

        if (minimumProblem == Integer.MAX_VALUE) {
            return -1;
        }

        visited[minimumProblem] = true;
        sb.append(minimumProblem).append(" ");

        return minimumProblem;
    }

    private static void output() {
        System.out.println(sb);
    }
}
