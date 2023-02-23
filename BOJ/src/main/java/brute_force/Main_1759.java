package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제
 * 바로 어제 최백준 조교가 방 열쇠를 주머니에 넣은 채 깜빡하고 서울로 가 버리는 황당한 상황에 직면한 조교들은, 702호에 새로운 보안 시스템을 설치하기로 하였다.
 * 이 보안 시스템은 열쇠가 아닌 암호로 동작하게 되어 있는 시스템이다.
 * 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.
 * 또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다. 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
 * 새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다. 이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다.
 * C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15) 다음 줄에는 C개의 문자들이 공백으로 구분되어 주어진다. 주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.
 * <p>
 * 출력
 * 각 줄에 하나씩, 사전식으로 가능성 있는 암호를 모두 출력한다.
 * <p>
 * 예제 입력
 * 4 6
 * a t c i s w
 * <p>
 * 예제 출력
 * acis
 * acit
 * aciw
 * acst
 * acsw
 * actw
 * aist
 * aisw
 * aitw
 * astw
 * cist
 * cisw
 * citw
 * istw
 */
public class Main_1759 {
    private static List<Character> characters = new ArrayList<>();
    private static List<String> result = new ArrayList<>();
    private static int passwordLength;
    private static int numberOfCandidates;
    private static char[] candidateAlphabet;
    private static char[] values;
    private static int[] usedAlphabet = new int[26];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        passwordLength = Integer.parseInt(st.nextToken());
        numberOfCandidates = Integer.parseInt(st.nextToken());

        values = new char[passwordLength + 1];
        candidateAlphabet = new char[numberOfCandidates + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= numberOfCandidates; i++) {
            candidateAlphabet[i] = st.nextToken().charAt(0);
        }
    }

    private static void recurrenceFunction(int startDigit, int countOfVowel, int countOfConsonant) {
        ArrayList<Character> vowel = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        boolean isDescending = false;

        // 1. 탐색이 끝난 경우
        if (startDigit == passwordLength + 1) {
            if (countOfVowel >= 1 && countOfConsonant >= 2) {        // 모음 1개 이상, 자음 2개 이상
                for (int i = 1; i < values.length; i++) {
                    characters.add(values[i]);
                }

                result.add(characters.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining()));

                characters.clear();
            }
        } else {    // 2. 탐색이 남은 경우
            for (int i = 1; i < candidateAlphabet.length; i++) {
                isDescending = false;

                if (usedAlphabet[candidateAlphabet[i] - 'a'] == 1) {  // candidateAlphabet[i] 사용 여부 확인
                    continue;
                }

                for (char value : values) {
                    if (candidateAlphabet[i] - value < 0) {      // 알파펫 오름차순 확인
                        isDescending = true;
                    }
                }

                if (isDescending) {
                    continue;
                }

                values[startDigit] = candidateAlphabet[i];
                usedAlphabet[candidateAlphabet[i] - 'a']++;

                if (vowel.contains(values[startDigit])) {
                    countOfVowel++;
                } else {
                    countOfConsonant++;
                }

                recurrenceFunction(startDigit + 1, countOfVowel, countOfConsonant);

                if (vowel.contains(values[startDigit])) {
                    countOfVowel--;
                } else {
                    countOfConsonant--;
                }

                usedAlphabet[candidateAlphabet[i] - 'a']--;
                values[startDigit] = '\u0000';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        recurrenceFunction(1, 0, 0);
        Collections.sort(result);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
