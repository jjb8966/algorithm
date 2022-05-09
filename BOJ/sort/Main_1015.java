package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1015 {

    private static int numberOfSequence;
    private static Element[] sequence;
    private static int[] result;

    static class Element implements Comparable<Element> {
        int number;
        int index;

        @Override
        public int compareTo(Element element) {
            return this.number - element.number;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfSequence = Integer.parseInt(br.readLine());

        sequence = new Element[numberOfSequence];
        result = new int[numberOfSequence];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numberOfSequence; i++) {
            sequence[i] = new Element();
            sequence[i].number = Integer.parseInt(st.nextToken());
            sequence[i].index = i;
        }
    }

    private static void process() {
        Arrays.sort(sequence);

        for (int i = 0; i < numberOfSequence; i++) {
            result[sequence[i].index] = i;
        }
    }

    private static void output() {
        for (int number : result) {
            System.out.print(number + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
