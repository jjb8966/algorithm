package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15724 {

    private static int height;
    private static int width;
    private static int numberOfQuestion;
    private static int[][] map;
    private static int[][] questions;
    private static int[][] sum;
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
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height + 1][width + 1];
        sum = new int[height + 1][width + 1];

        for (int x = 1; x <= height; x++) {
            st = new StringTokenizer(br.readLine());

            for (int y = 1; y <= width; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        numberOfQuestion = Integer.parseInt(br.readLine());

        questions = new int[numberOfQuestion][4];

        for (int question = 0; question < numberOfQuestion; question++) {
            st = new StringTokenizer(br.readLine());

            for (int vertex = 0; vertex < 4; vertex++) {
                questions[question][vertex] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        initSum();

        for (int i = 0; i < numberOfQuestion; i++) {
            int x1 = questions[i][0];
            int y1 = questions[i][1];
            int x2 = questions[i][2];
            int y2 = questions[i][3];

            int result = sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1];

            sb.append(result).append('\n');
        }
    }

    private static void initSum() {
        for (int x = 1; x <= height; x++) {
            for (int y = 1; y <= width; y++) {
                sum[x][y] = map[x][y] + sum[x][y - 1] + sum[x - 1][y] - sum[x - 1][y - 1];
            }
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}
