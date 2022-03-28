package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 1. 문제에서 입력이 연속된 문자열로 주어지는데 공백을 두고 입력하는 것으로 잘못 입력받는 실수를 함
 * 2. right의 마지막 인덱스를 잘못 설정하여 반복문이 제대로 작동하지 않는 실수를 함
 */
public class Main_16472 {
    private static int N;
    private static char[] Alphabets;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String temp = br.readLine();

        Alphabets = new char[temp.length() + 1];      //right가 맨 마지막 문자 다음 인덱스에 위치해야하기 때문에

        for (int i = 0; i < temp.length(); i++) {
            Alphabets[i] = temp.charAt(i);
        }
    }

    // 각 알파벳이 몇 개 있는지에 대한 정보를 담고 있는 배열 countAlphabet의 원소들의 총합을 리턴
    public static int sumOfAlphabet(int[] countAlphabet) {
        int sum = 0;

        for (int temp : countAlphabet) {
            sum += temp;
        }

        return sum;
    }

    // 리스트에 character가 존재하지 않으면 true 리턴, 존재하면 false 리턴
    public static boolean hasNotCharacter(LinkedList<Character> usedAlphabet, char character) {
        for (char temp : usedAlphabet) {
            if (temp == character) {
                return false;
            }
        }
        return true;
    }
    // 현재 고른 N종류의 알파벳 개수가 maxCount보다 크면 maxCount를 갱신해주는 메소드
    public static int updateMaxCount(int[] countAlphabet, int maxCount) {
        int count = sumOfAlphabet(countAlphabet);

        if (maxCount < count) {
            maxCount = count;
        }

        return maxCount;
    }

    public static void twoPointer() {
        LinkedList<Character> usedAlphabet = new LinkedList<>();
        int[] countAlphabet = new int[26];
        int left = 0;
        int right = 0;
        int kind = 0;
        int maxCount = Integer.MIN_VALUE;
        char leftAlphabet;
        char rightAlphabet;

        while (right != (Alphabets.length - 1)) {
            leftAlphabet = Alphabets[left];
            rightAlphabet = Alphabets[right];

            // 사용된 적이 없는 종류의 알파벳인 경우 usedAlphabet에 추가하고 kind를 1 증가
            if (hasNotCharacter(usedAlphabet, rightAlphabet)) {
                usedAlphabet.add(rightAlphabet);
                kind++;
            }

            // 사용한 알파벳의 종류가 N보다 커지면 leftAlphabet의 갯수를 하나 줄이고 left를 오른쪽으로 이동
            if (kind > N) {
                countAlphabet[leftAlphabet - 'a']--;
                left++;
                // cacacaca 이런식으로 문자열을 입력받을 수도 있기 때문에 leftAlphabet이 하나도 없을 경우에만 usedAlphabet에서 제거해줘야 함
                if (countAlphabet[leftAlphabet - 'a'] == 0) {
                    usedAlphabet.remove(leftAlphabet);
                    kind--;
                    maxCount = updateMaxCount(countAlphabet, maxCount);     // continue를 사용하므로 마지막에 한번 실행해줘야 함
                }
                continue;
            }

            countAlphabet[rightAlphabet - 'a']++;
            right++;

            maxCount = updateMaxCount(countAlphabet, maxCount);
        }

        System.out.println(maxCount);
    }

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
    }
}