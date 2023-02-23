package greedy;

import java.io.*;
import java.util.*;

public class Main_1343 {

    static String exp;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        exp = br.readLine();
    }

    private static void process() {
        exp = exp.replace("XXXX", "AAAA");
        exp = exp.replace("XX", "BB");

        if (exp.contains("X")) {
            exp = "-1";
        }
    }

    private static void output() {
        System.out.println(exp);
    }

}