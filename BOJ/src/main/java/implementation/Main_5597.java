package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Main_5597 {

    static Set<Integer> numbers = new HashSet<>();
    static List<Integer> submits = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 28; i++) {
            submits.add(Integer.valueOf(br.readLine()));
        }
    }

    private static void process() {
        IntStream.range(1, 31)
                .forEach(n -> numbers.add(n));

        submits.forEach(numbers::remove);
    }

    private static void output() {
        numbers.stream().forEach(n -> System.out.println(n));
    }

}