package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2224 {

    private static int numberOfProposition;
    private static int countResult;
    private static boolean[] visit;
    private static ArrayList<Integer>[] adjacencyList;
    private static ArrayList<Integer>[] result;
    private static StringBuilder sb = new StringBuilder();

    //A -> 0, z -> 57
    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfProposition = Integer.parseInt(br.readLine());

        /**
         * 'A' + 26~31
         * -> 알파벳 아님. 성능 최적화하려면 이 부분 걸러야됨
         */
        adjacencyList = new ArrayList[58];  // 'z' - 'A' + 1
        result = new ArrayList[58];

        for (int i = 0; i <= 57; i++) {
            adjacencyList[i] = new ArrayList<>();
            result[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfProposition; i++) {
            String[] expressions = br.readLine().split(" => ");
            int a = expressions[0].charAt(0) - 'A';
            int b = expressions[1].charAt(0) - 'A';

            if (adjacencyList[a].contains(b)) {
                continue;
            }

            adjacencyList[a].add(b);
        }
    }

    private static void process() {
        for (int alphabet = 0; alphabet <= 57; alphabet++) {
            visit = new boolean[58];
            visit[alphabet] = true;

            findProposition(alphabet, alphabet);
            Collections.sort(result[alphabet]);
            updateResult(alphabet);
        }
    }

    private static void findProposition(int alphabet, int origin) {
        for (Integer nextAlphabet : adjacencyList[alphabet]) {
            if (visit[nextAlphabet]) {
                continue;
            }

            result[origin].add(nextAlphabet);
            visit[nextAlphabet] = true;
            findProposition(nextAlphabet, origin);
        }
    }

    private static void updateResult(int alphabet) {
        for (int nextAlphabet : result[alphabet]) {
            sb.append((char) (alphabet + 'A')).append(" => ").append((char) (nextAlphabet + 'A')).append('\n');
            countResult++;
        }
    }

    private static void output() {
        System.out.println(countResult);
        System.out.println(sb);
    }

}
