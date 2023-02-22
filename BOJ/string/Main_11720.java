package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11720 {

    static int lengthOfExp;
    static int result;
    static String exp;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        lengthOfExp = Integer.parseInt(br.readLine());
        exp = br.readLine();
    }

    private static void process() {
        String[] split = exp.split("");

        for (int i = 0; i < split.length; i++) {
            result += Integer.parseInt(split[i]);
        }
    }

    private static void output() {
        System.out.println(result);
    }

}