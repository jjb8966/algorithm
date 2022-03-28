package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2개의 포인터 모두 왼쪽에서 시작해 같은 방향으로 이동
 * --------------------------------------------------------
 * 1. 문제에서 입력이 연속된 문자열로 주어지는데 공백을 두고 입력하는 것으로 잘못 입력받는 실수를 함
 * 2. right의 마지막 인덱스를 잘못 설정하여 반복문이 제대로 작동하지 않는 실수를 함
 */
public class Main_16472_rhs {

    private static int[] usedAlphabet = new int[26];
    private static int availableAlphabets;
    private static int kind;
    private static String alphabets;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        availableAlphabets = Integer.parseInt(br.readLine());
        alphabets = br.readLine();
    }

    static void add(char alphabet) {  // 알파벳 추가
        usedAlphabet[alphabet - 'a']++;

        if (usedAlphabet[alphabet - 'a'] == 1)  // 새롭게 나타난 알파벳이라는 뜻
            kind++;
    }

    static void erase(char alphabet) {  // 알파벳 제거
        usedAlphabet[alphabet - 'a']--;

        if (usedAlphabet[alphabet - 'a'] == 0)  // 인식해야 하는 알파벳에서 빠지는 순간
            kind--;
    }

    static void twoPointer() {
        int left = 0;
        int result = 0;
        int length = alphabets.length();

        for (int right = 0; right < length; right++) {
            // right 번째 문자를 오른쪽에 추가
            add(alphabets.charAt(right));

            // 불가능하면, 가능할 때까지 left를 이동
            while (kind > availableAlphabets) {
                erase(alphabets.charAt(left++));
            }

            // 정답 갱신
            result = Math.max(result, right - left + 1);
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
    }
}