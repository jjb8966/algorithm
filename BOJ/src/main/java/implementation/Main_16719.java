package implementation;

import java.io.*;
import java.util.*;

public class Main_16719 {

    static String exp;
    static List<OneChar> chars = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static class OneChar {
        int index;
        char character;

        public OneChar(int index, char character) {
            this.index = index;
            this.character = character;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        exp = br.readLine();

        for (int i = 0; i < exp.length(); i++) {
            chars.add(new OneChar(i, exp.charAt(i)));
        }
    }

    private static void process() {
        Stack<OneChar> resultStack = new Stack<>();

        while (!chars.isEmpty()) {
            String min = initMin(resultStack.size() + 1);
            OneChar targetChar = null;
            Stack<OneChar> minStack = new Stack<>();

            for (OneChar oneChar : chars) {
                Stack<OneChar> currentStack;
                String currentWord;

                currentStack = makeWordStack(resultStack, oneChar);
                currentWord = getWord(currentStack);

                if (currentWord.compareTo(min) < 0) {
                    min = currentWord;
                    targetChar = oneChar;
                    minStack.clear();
                    minStack.addAll(currentStack);
                }
            }

            resultStack.clear();
            resultStack.addAll(minStack);
            chars.remove(targetChar);
            sb.append(getWord(resultStack)).append('\n');
        }
    }

    private static Stack<OneChar> makeWordStack(Stack<OneChar> resultStack, OneChar targetChar) {
        Stack<OneChar> copy = new Stack<>();
        Stack<OneChar> temp = new Stack<>();
        copy.addAll(resultStack);

        while (!copy.isEmpty()) {
            OneChar currentChar = copy.pop();

            if (currentChar.index > targetChar.index) {
                temp.push(currentChar);
                continue;
            }

            if (currentChar.index < targetChar.index) {
                copy.push(currentChar);
                copy.push(targetChar);
                moveChar(copy, temp);

                return copy;
            }
        }

        copy.push(targetChar);
        moveChar(copy, temp);

        return copy;
    }

    private static void moveChar(Stack<OneChar> copy, Stack<OneChar> temp) {
        while (!temp.isEmpty()) {
            copy.push(temp.pop());
        }
    }

    private static String getWord(Stack<OneChar> stack) {
        StringBuilder result = new StringBuilder();

        for (OneChar oneChar : stack) {
            result.append(oneChar.character);
        }

        return result.toString();
    }

    private static String initMin(int size) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            result.append("Z");
        }

        return result.toString();
    }

    private static void output() {
        System.out.println(sb);
    }

}