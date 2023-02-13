package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2753 {

    static int year;
    static int result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        year = Integer.parseInt(br.readLine());
    }

    private static void process() {
        if (year % 4 == 0 && year % 100 != 0 || (year % 400 == 0)) {
            result = 1;
        }
    }

    private static void output() {
        System.out.println(result);
    }

}