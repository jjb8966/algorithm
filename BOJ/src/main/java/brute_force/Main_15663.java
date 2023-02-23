package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15663 {
    private static StringBuilder sb = new StringBuilder();
    private static int countOfNumber;
    private static int countOfChoose;
    private static int[] candidateNumber;
    private static int[] usedNumber;
    private static int[] selectedNumber;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        countOfNumber = Integer.parseInt(st.nextToken());
        countOfChoose = Integer.parseInt(st.nextToken());

        selectedNumber = new int[countOfChoose + 1];
        candidateNumber = new int[countOfNumber + 1];
        usedNumber = new int[countOfNumber + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= countOfNumber; i++) {
            candidateNumber[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(candidateNumber, 1, countOfNumber + 1);
        // 입력받은 값들을 정렬하여 오름차순으로 결과를 출력하도록 만들 수 있음
    }

    static void recurrenceFunction(int startDigit) {
        if (startDigit == countOfChoose + 1) { // 1 ~ M 번째를 전부 다 골랐다!
            // selected[1...M] 배열이 새롭게 탐색된 결과

            for (int i = 1; i <= countOfChoose; i++) {
                sb.append(selectedNumber[i]).append(' ');
            }
            String s = "s";
            s.charAt(0);

            sb.append('\n');
        } else {
            int lastCandidate = 0;

            for (int candidate = 1; candidate <= countOfNumber; candidate++) {
                if (usedNumber[candidate] == 1) {
                    continue;
                }

                // 후보값들을 오름차순 정렬하였기 때문에 lastCandidate는 가장 큰 값이 됨.
                // 또 후보값 중 중복된 값이 있으면 lastCandidate와 candidateNumber[candidate]가 같아지므로 그 경우에는 pass
                if (candidateNumber[candidate] == lastCandidate) {
                    continue;
                }

                lastCandidate = candidateNumber[candidate];
                selectedNumber[startDigit] = candidateNumber[candidate];
                usedNumber[candidate] = 1;

                recurrenceFunction(startDigit + 1);

                selectedNumber[startDigit] = 0;
                usedNumber[candidate] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        recurrenceFunction(1);
        System.out.println(sb);
    }
}
