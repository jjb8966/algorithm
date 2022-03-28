package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1343 {

    private static final String POLYOMINO_A = "AAAA";
    private static final String POLYOMINO_B = "BB";
    private static String board;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = br.readLine();
    }

    private static void process() {
        String temp = board.replace("XXXX", POLYOMINO_A);
        String result = temp.replace("XX", POLYOMINO_B);

        if (result.contains("X")) {
            result = "-1";
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

}
