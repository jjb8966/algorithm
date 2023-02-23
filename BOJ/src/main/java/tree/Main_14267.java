package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14267 {

    private static int numberOfMember;
    private static int numberOfCompliment;
    private static int[] sumOfCompliment;
    private static int[] compliment;
    private static ArrayList<Integer>[] children;
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
        numberOfMember = Integer.parseInt(st.nextToken());
        numberOfCompliment = Integer.parseInt(st.nextToken());

        children = new ArrayList[numberOfMember + 1];
        sumOfCompliment = new int[numberOfMember + 1];
        compliment = new int[numberOfMember + 1];

        for (int i = 1; i <= numberOfMember; i++) {
            children[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken(); // 1번은 사장이므로
        for (int child = 2; child <= numberOfMember; child++) {
            int parent = Integer.parseInt(st.nextToken());

            children[parent].add(child);
        }

        for (int i = 0; i < numberOfCompliment; i++) {
            st = new StringTokenizer(br.readLine());
            int member = Integer.parseInt(st.nextToken());
            int degree = Integer.parseInt(st.nextToken());

            compliment[member] += degree;
        }
    }

    private static void process() {
        updateSumOfCompliment(1);

        for (int i = 1; i <= numberOfMember; i++) {
            sb.append(sumOfCompliment[i] + " ");
        }
    }

    private static void updateSumOfCompliment(int member) {
        for (Integer subordinate : children[member]) {
            sumOfCompliment[subordinate] = sumOfCompliment[member] + compliment[subordinate];
            updateSumOfCompliment(subordinate);
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}
