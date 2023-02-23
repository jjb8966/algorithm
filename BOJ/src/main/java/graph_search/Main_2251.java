package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2251 {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;

    private static ArrayList<Integer> result = new ArrayList<>();
    private static boolean[][][] visit;
    private static int[] maxVolume = new int[3];
    private static int[] currentVolume = new int[3];

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        maxVolume[A] = Integer.parseInt(st.nextToken());
        maxVolume[B] = Integer.parseInt(st.nextToken());
        maxVolume[C] = Integer.parseInt(st.nextToken());

        currentVolume[C] = maxVolume[C];

        visit = new boolean[maxVolume[A] + 1][maxVolume[B] + 1][maxVolume[C] + 1];
    }

    private static void process() {
        bfs(currentVolume);
        Collections.sort(result);
    }

    public static void bfs(int[] status) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(status);
        visit[status[A]][status[B]][status[C]] = true;

        while (!queue.isEmpty()) {
            int[] currentStatus = queue.poll();

            if (currentStatus[A] == 0) {
                result.add(currentStatus[C]);
            }

            for (int start = A; start <= C; start++) {
                if (currentStatus[start] == 0) {
                    continue;
                }

                for (int destination = A; destination <= C; destination++) {
                    int[] nextStatus = currentStatus.clone();

                    if (start == destination) {
                        continue;
                    }

                    if (overMaxVolume(start, destination, nextStatus)) {
                        nextStatus[start] -= maxVolume[destination] - nextStatus[destination];
                        nextStatus[destination] = maxVolume[destination];
                    } else {
                        nextStatus[destination] += nextStatus[start];
                        nextStatus[start] = 0;
                    }

                    if (visit[nextStatus[A]][nextStatus[B]][nextStatus[C]]) {
                        continue;
                    }

                    queue.add(nextStatus);
                    visit[nextStatus[A]][nextStatus[B]][nextStatus[C]] = true;
                }
            }
        }
    }

    private static boolean overMaxVolume(int start, int destination, int[] nextStatus) {
        return nextStatus[start] + nextStatus[destination] > maxVolume[destination];
    }

    private static void output() {
        result.forEach(n -> System.out.print(n + " "));
    }
}