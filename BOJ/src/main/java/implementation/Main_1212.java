package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1212 {

    static String octal;
    static String binary;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        octal = br.readLine();
    }

    private static void process() {
        for (int i = 0; i < octal.length(); i++) {
            String oct = octal.substring(i, i + 1);
            String bin = Integer.toBinaryString(Integer.parseInt(oct));

            if (i == 0) {
                sb.append(bin);
                continue;
            }

            if (bin.length() == 1) {
                sb.append("00").append(bin);
            }

            if (bin.length() == 2) {
                sb.append("0").append(bin);
            }

            if (bin.length() == 3) {
                sb.append(bin);
            }
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}