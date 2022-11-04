package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2056 {

    private static int numberOfWork;
    private static int[] workTime;
    private static int[] totalWorkTime;
    private static int[] inDegree;
    private static int[] maxPreviousWorkTime;
    private static ArrayList<Integer>[] next;
    private static int maxWorkTime;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfWork = Integer.parseInt(br.readLine());

        workTime = new int[numberOfWork + 1];
        totalWorkTime = new int[numberOfWork + 1];
        inDegree = new int[numberOfWork + 1];
        maxPreviousWorkTime = new int[numberOfWork + 1];
        next = new ArrayList[numberOfWork + 1];

        for (int i = 1; i <= numberOfWork; i++) {
            next[i] = new ArrayList<>();
        }

        for (int work = 1; work <= numberOfWork; work++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int countPreviousWork = Integer.parseInt(st.nextToken());

            workTime[work] = time;

            for (int i = 0; i < countPreviousWork; i++) {
                int previousWork = Integer.parseInt(st.nextToken());

                next[previousWork].add(work);
                inDegree[work]++;
            }
        }
    }

    private static void process() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= numberOfWork; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                totalWorkTime[i] = workTime[i];
            }
        }

        while (!queue.isEmpty()) {
            Integer previousWork = queue.poll();

            for (Integer nextWork : next[previousWork]) {
                if (totalWorkTime[previousWork] > maxPreviousWorkTime[nextWork]) {
                    maxPreviousWorkTime[nextWork] = totalWorkTime[previousWork];
                    totalWorkTime[nextWork] = maxPreviousWorkTime[nextWork] + workTime[nextWork];
                }

                inDegree[nextWork]--;

                if (inDegree[nextWork] == 0) {
                    queue.add(nextWork);
                }
            }
        }

        for (int i = 1; i <= numberOfWork; i++) {
            if (totalWorkTime[i] > maxWorkTime) {
                maxWorkTime = totalWorkTime[i];
            }
        }
    }

    private static void output() {
        System.out.println(maxWorkTime);
    }

}
