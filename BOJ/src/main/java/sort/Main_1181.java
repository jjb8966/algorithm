package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1181 {

    private static int numberOfWords;
    private static English[] englishWords;

    static class English implements Comparable<English> {
        String word;
        int wordLength;

        public English(String word) {
            this.word = word;
            this.wordLength = word.length();
        }

        @Override
        public int compareTo(English o) {
            if (this.wordLength != o.wordLength) {
                return this.wordLength - o.wordLength;
            }

            return this.word.compareTo(o.word);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfWords = Integer.parseInt(br.readLine());

        englishWords = new English[numberOfWords];

        for (int i = 0; i < englishWords.length; i++) {
            englishWords[i] = new English(br.readLine());
        }
    }

    private static void process() {
        Arrays.sort(englishWords);

        String previousWord = englishWords[0].word;

        System.out.println(previousWord);

        for (int i = 1; i < englishWords.length; i++) {         // 2번째 단어부터 시작
            if (previousWord.equals(englishWords[i].word)) {    // 문자열 비교는 equals...
                continue;
            }

            System.out.println(englishWords[i].word);
            previousWord = englishWords[i].word;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
