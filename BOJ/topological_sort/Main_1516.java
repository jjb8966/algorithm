package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1516 {

    private static int numberOfBuilding;
    private static int[] buildTime;
    private static int[] totalBuildTime;
    private static int[] inDegree;
    private static ArrayList<Integer>[] next;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfBuilding = Integer.parseInt(br.readLine());

        buildTime = new int[numberOfBuilding + 1];
        totalBuildTime = new int[numberOfBuilding + 1];
        next = new ArrayList[numberOfBuilding + 1];
        inDegree = new int[numberOfBuilding + 1];

        for (int i = 1; i <= numberOfBuilding; i++) {
            next[i] = new ArrayList<>();
        }

        for (int building = 1; building <= numberOfBuilding; building++) {
            st = new StringTokenizer(br.readLine());

            buildTime[building] = Integer.parseInt(st.nextToken());

            while (true) {
                int previousBuilding = Integer.parseInt(st.nextToken());

                if (previousBuilding == -1) {
                    break;
                }

                next[previousBuilding].add(building);
                inDegree[building]++;
            }
        }

    }

    private static void process() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= numberOfBuilding; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                totalBuildTime[i] = buildTime[i];
            }
        }

        while (!queue.isEmpty()) {
            Integer building = queue.poll();

            for (Integer nextBuilding : next[building]) {
                // totalBuildTime[building]에 의해 totalBuildTime[nextBuilding]이 결정됨
                if (totalBuildTime[nextBuilding] < buildTime[nextBuilding] + totalBuildTime[building]) {
                    totalBuildTime[nextBuilding] = buildTime[nextBuilding] + totalBuildTime[building];
                }

                inDegree[nextBuilding]--;

                if (inDegree[nextBuilding] == 0) {
                    queue.add(nextBuilding);
                }
            }
        }

        for (int i = 1; i <= numberOfBuilding; i++) {
            sb.append(totalBuildTime[i]).append('\n');
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}
