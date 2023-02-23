package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14567 {

    private static int numberOfSubject;
    private static int numberOfPrerequisite;
    private static int[] inDegree;
    private static int[] completeSemester;
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
        numberOfSubject = Integer.parseInt(st.nextToken());
        numberOfPrerequisite = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[numberOfSubject + 1];
        inDegree = new int[numberOfSubject + 1];
        completeSemester = new int[numberOfSubject + 1];

        for (int i = 1; i <= numberOfSubject; i++) {
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

        for (int subject = 1; subject <= numberOfSubject; subject++) {
            if (inDegree[subject] == 0) {
                queue.add(subject);
                completeSemester[subject] = 1;
            }
        }

        while (!queue.isEmpty()) {
            Integer subject = queue.poll();

            for (Integer nextSubject : adjacencyList[subject]) {
                inDegree[nextSubject]--;

                if (inDegree[nextSubject] == 0) {
                    completeSemester[nextSubject] = completeSemester[subject] + 1;
                    queue.add(nextSubject);
                }
            }
        }

        for (int subject = 1; subject <= numberOfSubject; subject++) {
            sb.append(completeSemester[subject]).append(" ");
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}
