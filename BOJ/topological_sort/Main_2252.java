package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252 {
    private static ArrayList<Integer>[] adjacencyList;
    private static int countOfStudent;
    private static int countOfCompare;
    private static int[] indegree;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        countOfStudent = Integer.parseInt(temp[0]);
        countOfCompare = Integer.parseInt(temp[1]);

        adjacencyList = new ArrayList[countOfStudent + 1];        // 인덱스 : 1 ~ countOfStudent
        indegree = new int[countOfStudent + 1];

        for (int i = 1; i <= countOfStudent; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < countOfCompare; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int operand1 = Integer.parseInt(st.nextToken());
            int operand2 = Integer.parseInt(st.nextToken());

            adjacencyList[operand1].add(operand2);
            indegree[operand2]++;
        }
    }

    public static void getResult() {
        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= countOfStudent; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int outOfQueue = queue.poll();

            sb.append(outOfQueue).append(" ");

            for (Integer temp : adjacencyList[outOfQueue]) {
                indegree[temp]--;

                if (indegree[temp] == 0) {
                    queue.add(temp);
                }
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        getResult();
    }
}