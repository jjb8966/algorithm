package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2251 {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;

    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer> result = new ArrayList<>();
    private static boolean[][][] visit;
    private static int[] maxVolume = new int[3];
    private static int[] currentVolume = new int[3];

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        for (int i = A; i <= C; i++) {       // 물통 A,B,C 생성 후 bottles에 추가
            maxVolume[i] = Integer.parseInt(temp[i]);
        }

        currentVolume[C] = maxVolume[C];

        visit = new boolean[maxVolume[A] + 1][maxVolume[B] + 1][maxVolume[C] + 1];
    }

    public static void bfs(int[] status) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(status);
        visit[status[A]][status[B]][status[C]] = true;

        while (!queue.isEmpty()) {
            int[] checkedStatus = queue.poll();

            if(checkedStatus[A] == 0) {
                result.add(checkedStatus[C]);
            }

            for (int from = A; from <= C; from++) {
                if (checkedStatus[from] == 0) {
                    continue;
                }

                for (int to = A; to <= C; to++) {
                    int[] temp = {checkedStatus[A], checkedStatus[B], checkedStatus[C]};

                    if (from == to) {
                        continue;
                    }

                    if (temp[from] + temp[to] > maxVolume[to]) {
                        temp[from] -= maxVolume[to] - temp[to];
                        temp[to] = maxVolume[to];
                    } else {
                        temp[to] += temp[from];
                        temp[from] = 0;
                    }

                    if (visit[temp[A]][temp[B]][temp[C]]) {
                        continue;
                    }

                    queue.add(temp);
                    visit[temp[A]][temp[B]][temp[C]] = true;
                }
            }
        }

        Collections.sort(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs(currentVolume);

        for (int i = 0; i <result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}