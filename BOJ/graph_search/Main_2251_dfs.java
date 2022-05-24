package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2251_dfs {

    private static int[] maxVolume = new int[3];
    private static boolean[][][] visited = new boolean[201][201][201];
    private static List<Integer> result = new ArrayList<>();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            maxVolume[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        dfs(0, 0, maxVolume[2]);
    }

    private static void dfs(int a, int b, int c) {
        visited[a][b][c] = true;

        if (a == 0) {
            result.add(c);
        }

        for (int departure = 0; departure < 3; departure++) {
            for (int destination = 0; destination < 3; destination++) {
                // 기존 a,b,c의 값을 유지해야 하므로 새로운 배열 생성하여 사용
                int[] newStatus = {a, b, c};

                if (departure == destination) {
                    continue;
                }

                if (newStatus[departure] == 0) {
                    continue;
                }

                pourWater(departure, destination, newStatus);

                if (visited[newStatus[0]][newStatus[1]][newStatus[2]] == false) {
                    dfs(newStatus[0], newStatus[1], newStatus[2]);
                }
            }
        }
    }

    private static void pourWater(int departure, int destination, int[] newStatus) {
        if (newStatus[departure] + newStatus[destination] < maxVolume[destination]) {
            newStatus[destination] = newStatus[departure] + newStatus[destination];
            newStatus[departure] = 0;
        } else {
            newStatus[departure] -= maxVolume[destination] - newStatus[destination];
            newStatus[destination] = maxVolume[destination];
        }
    }

    private static void output() {
        Collections.sort(result);

        int size = result.size();

        for (int i = 0; i < size; i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
