package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main_9046 {

    static int[] countAlphabets;
    static String exp;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();
//            process();
            process2();
        }

        output();
    }

    private static void process2() {
        Map<Character, Long> characterCountMap = exp.chars()
                .mapToObj(n -> (char) n)
                .filter(Character::isAlphabetic)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map.Entry<Character, Long> maxValueEntry = characterCountMap.entrySet().stream()
                .max((o1, o2) -> (int) (o1.getValue() - o2.getValue()))
                .get();

        if (Collections.frequency(characterCountMap.values(), maxValueEntry.getValue()) == 1) {
            sb.append(maxValueEntry.getKey()).append('\n');
        } else {
            sb.append('?').append('\n');
        }
    }

    private static void input() throws IOException {
        exp = br.readLine();
        countAlphabets = new int[26];
    }

    private static void process() {
        byte[] bytes = exp.getBytes();
        int max = 0;
        int alphabet = 0;

        for (byte characters : bytes) {
            char character = (char) characters;

            if (character == ' ') {
                continue;
            }

            countAlphabets[character - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countAlphabets[i] > max) {
                max = countAlphabets[i];
                alphabet = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (countAlphabets[i] == max && i != alphabet) {
                sb.append("?").append('\n');
                return;
            }
        }

        sb.append((char) (alphabet + 'a')).append('\n');
    }

    private static void output() {
        System.out.println(sb);
    }

}