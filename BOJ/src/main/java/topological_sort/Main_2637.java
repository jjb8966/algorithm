package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2637 {

    private static int numberOfPart;
    private static int numberOfRelation;
    private static int[] inDegree;
    private static int[][] neededPartCount;         // neededPartCount[a][b] = c -> a는 b가 c개 필요
    private static int[][] neededBasicPartCount;
    private static ArrayList<Integer>[] next;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        input();
        process();
        output();
        long end = System.currentTimeMillis();

        System.out.println("(end-start) = " + (end-start));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfPart = Integer.parseInt(br.readLine());
        numberOfRelation = Integer.parseInt(br.readLine());

        inDegree = new int[numberOfPart + 1];
        next = new ArrayList[numberOfPart + 1];
        neededPartCount = new int[numberOfPart + 1][numberOfPart + 1];
        neededBasicPartCount = new int[numberOfPart + 1][numberOfPart + 1];

        for (int i = 1; i <= numberOfPart; i++) {
            next[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfRelation; i++) {
            st = new StringTokenizer(br.readLine());
            int part = Integer.parseInt(st.nextToken());
            int neededPart = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            next[neededPart].add(part);
            neededPartCount[part][neededPart] = count;
            inDegree[part]++;
        }

    }

    private static void process() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= numberOfPart; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                neededBasicPartCount[i][i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            Integer previousPart = queue.poll();

            for (Integer nextPart : next[previousPart]) {
                int count = neededPartCount[nextPart][previousPart];

                for (int i = 1; i <= numberOfPart; i++) {
                    neededBasicPartCount[nextPart][i] += neededBasicPartCount[previousPart][i] * count;
                }

                inDegree[nextPart]--;

                if (inDegree[nextPart] == 0) {
                    queue.add(nextPart);
                }
            }
        }

        for (int basicPart = 0; basicPart < numberOfPart; basicPart++) {
            if ((neededBasicPartCount[numberOfPart][basicPart] != 0)) {
                sb.append(basicPart).append(" ").append(neededBasicPartCount[numberOfPart][basicPart]).append('\n');
            }
        }

    }

    private static void output() {
        System.out.println(sb);
    }

}
