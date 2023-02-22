package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_11365 {

    static StringBuilder sb = new StringBuilder();
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;

        while (!(temp = br.readLine()).equals("END")) {
            sb.append(temp).append('\n');
        }
    }

    private static void process() {
        Stack<Character> stack = new Stack<>();

        String[] split = sb.toString().split("\n");

        for (int line = 0; line < split.length; line++) {
            String oneLine = split[line];

            for (int digit = 0; digit < oneLine.length(); digit++) {
                stack.push(oneLine.charAt(digit));
            }

            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            result.append('\n');
        }
    }

    private static void output() {
        System.out.println(result);
    }

}