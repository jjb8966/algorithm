package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1005 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Integer>[] adjacencyList;
    private static int countOfBuilding;
    private static int orderOfBuilding;
    private static int haveToBuild;
    private static int[] indegree;
    private static int[] timeToBuild;
    private static int[] done;

    public static void input() throws IOException {
        String[] temp = br.readLine().split(" ");

        countOfBuilding = Integer.parseInt(temp[0]);
        orderOfBuilding = Integer.parseInt(temp[1]);

        adjacencyList = new ArrayList[countOfBuilding + 1];
        indegree = new int[countOfBuilding + 1];
        timeToBuild = new int[countOfBuilding + 1];
        done = new int[countOfBuilding + 1];

        temp = br.readLine().split(" ");

        for (int i = 0; i < countOfBuilding; i++) {
            adjacencyList[i + 1] = new ArrayList<>();
            timeToBuild[i + 1] = Integer.parseInt(temp[i]);
        }

        for (int i = 0; i < orderOfBuilding; i++) {
            temp = br.readLine().split(" ");
            int operand1 = Integer.parseInt(temp[0]);
            int operand2 = Integer.parseInt(temp[1]);

            adjacencyList[operand1].add(operand2);
            indegree[operand2]++;
        }

        haveToBuild = Integer.parseInt(br.readLine());
    }

    private static void getResult() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= countOfBuilding; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                done[i] = timeToBuild[i];
            }
        }

        while (!queue.isEmpty()) {
            int outOfQueue = queue.poll();

            for (Integer temp : adjacencyList[outOfQueue]) {
                indegree[temp]--;

                if (indegree[temp] == 0) {
                    queue.add(temp);
                }

                if (done[temp] < done[outOfQueue] + timeToBuild[temp]) {
                    done[temp] = done[outOfQueue] + timeToBuild[temp];
                }
            }
        }

        System.out.println(done[haveToBuild]);
    }

    public static void main(String[] args) throws IOException {
        int countOfGame = Integer.parseInt(br.readLine());

        for (int i = 0; i < countOfGame; i++) {
            input();
            getResult();
        }
    }
}
