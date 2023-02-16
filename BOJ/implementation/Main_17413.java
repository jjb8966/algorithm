package implementation;

import java.io.*;
import java.util.*;

public class Main_17413 {

    static String exp;
    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

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
        int index = 0;

        while (index < exp.length()) {
            char character = exp.charAt(index++);

            if (character == '<') {
                popStack();

                while (character != '>') {
                    sb.append(character);
                    character = exp.charAt(index++);
                }

                sb.append('>');

                continue;
            }

            if (character == ' ') {
                popStack();
                sb.append(' ');

                continue;
            }

            stack.push(character);
        }

        popStack();
    }

    private static void popStack() {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}