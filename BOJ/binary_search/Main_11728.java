package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11728 {

    private static int lengthOfA;
    private static int lengthOfB;
    private static int[] a;
    private static int[] b;
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
        lengthOfA = Integer.parseInt(st.nextToken());
        lengthOfB = Integer.parseInt(st.nextToken());

        a = new int[lengthOfA];
        b = new int[lengthOfB];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lengthOfA; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lengthOfB; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void process() {
        int indexA = 0;
        int indexB = 0;

        while (indexA < lengthOfA && indexB < lengthOfB) {
            if (a[indexA] < b[indexB]) {
                sb.append(a[indexA]).append(" ");
                indexA++;
            } else {
                sb.append(b[indexB]).append(" ");
                indexB++;
            }
        }

        while (indexA < lengthOfA) {
            sb.append(a[indexA]).append(" ");
            indexA++;
        }

        while (indexB < lengthOfB) {
            sb.append(b[indexB]).append(" ");
            indexB++;
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}
