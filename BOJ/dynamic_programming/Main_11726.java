package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726 {
    private static int width;
    private static int[] dynamicSolution;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        width = Integer.parseInt(br.readLine());

        dynamicSolution = new int[1001];
    }

    private static void process() {
        // 초기값
        dynamicSolution[1] = 1;
        dynamicSolution[2] = 2;

        //점화식
        for (int i = 3; i <= width; i++) {
            dynamicSolution[i] = (dynamicSolution[i - 1] + dynamicSolution[i - 2]) % 10007;
        }
        System.out.println(dynamicSolution[width]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
