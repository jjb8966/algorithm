package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14676 {

    private static int numberOfBuilding;
    private static int numberOfRelation;
    private static int numberOfPlay;
    private static int[] inDegree;
    private static int[] countBuilding;
    private static boolean useCheatKey;
    private static ArrayList<Integer>[] buildingRelation;
    private static PlayInformation[] playInformations;
    private static StringBuilder sb = new StringBuilder();

    static class PlayInformation {
        int buildOrDestroy;
        int buildingNumber;

        public PlayInformation(int buildOrDestroy, int buildingNumber) {
            this.buildOrDestroy = buildOrDestroy;
            this.buildingNumber = buildingNumber;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfBuilding = Integer.parseInt(st.nextToken());
        numberOfRelation = Integer.parseInt(st.nextToken());
        numberOfPlay = Integer.parseInt(st.nextToken());

        buildingRelation = new ArrayList[numberOfBuilding + 1];
        inDegree = new int[numberOfBuilding + 1];
        countBuilding = new int[numberOfBuilding + 1];
        playInformations = new PlayInformation[numberOfPlay];

        for (int i = 1; i <= numberOfBuilding; i++) {
            buildingRelation[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfRelation; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            buildingRelation[a].add(b);
            inDegree[b]++;
        }

        for (int i = 0; i < numberOfPlay; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            playInformations[i] = new PlayInformation(a, b);
        }

    }

    private static void process() {
        for (int i = 0; i < numberOfPlay; i++) {
            PlayInformation info = playInformations[i];

            if (info.buildOrDestroy == 1) {
                build(info.buildingNumber);
            }

            if (info.buildOrDestroy == 2) {
                destroy(info.buildingNumber);
            }

            if (useCheatKey) {
                sb.append("Lier!");
                return;
            }
        }

        sb.append("King-God-Emperor");
    }

    private static void build(int building) {
        if (canBuild(building)) {
            if (countBuilding[building] == 0) {
                for (Integer nextBuilding : buildingRelation[building]) {
                    inDegree[nextBuilding]--;
                }
            }

            countBuilding[building]++;
        } else {
            useCheatKey = true;
        }
    }

    private static boolean canBuild(int building) {
        if (inDegree[building] == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void destroy(int building) {
        if (canDestroy(building)) {
            if (countBuilding[building] == 1) {
                for (Integer nextBuilding : buildingRelation[building]) {
                    inDegree[nextBuilding]++;
                }
            }

            countBuilding[building]--;
        } else {
            useCheatKey = true;
        }
    }

    private static boolean canDestroy(int building) {
        return countBuilding[building] > 0;
    }

    private static void output() {
        System.out.println(sb);
    }

}
