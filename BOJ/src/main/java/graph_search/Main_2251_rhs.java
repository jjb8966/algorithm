package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2251_rhs {

    static class State {
        private int[] currentState = new int[3];

        State(int[] initializationValue) {
            for (int i = 0; i < 3; i++) {
                currentState[i] = initializationValue[i];
            }
        }

        State move(int from, int to, int[] limit) {
            int[] newState = {currentState[0], currentState[1], currentState[2]};

            // from 물통의 모든 물을 이동시킬 수 있는 경우
            if (currentState[from] + currentState[to] <= limit[to]) {
                newState[to] = currentState[from] + currentState[to];
                newState[from] = 0;
            } else {    // from 물통의 일부만 이동시킬 수 있는 경우
                newState[from] -= limit[to] - currentState[to];
                newState[to] = limit[to];
            }

            return new State(newState);
        }
    }

    private static StringBuilder sb = new StringBuilder();
    private static int[] limit = new int[3];
    private static boolean[] possibleState = new boolean[201];
    private static boolean[][][] visit = new boolean[201][201][201];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void bfs(int x1, int x2, int x3) {
        Queue<State> queue = new LinkedList<>();

        visit[x1][x2][x3] = true;
        queue.add(new State(new int[]{x1, x2, x3}));

        while (!queue.isEmpty()) {
            State tempState = queue.poll();

            if (tempState.currentState[0] == 0) {
                possibleState[tempState.currentState[2]] = true;
            }

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) {
                        continue;
                    }

                    State nextState = tempState.move(from, to, limit);

                    if (!visit[nextState.currentState[0]][nextState.currentState[1]][nextState.currentState[2]]) {
                        visit[nextState.currentState[0]][nextState.currentState[1]][nextState.currentState[2]] = true;
                        queue.add(nextState);
                    }
                }
            }
        }
    }

    private static void process() {
        bfs(0, 0, limit[2]);

        for (int i = 0; i <= 200; i++) {
            if (possibleState[i]) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
