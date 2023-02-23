package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 이렇게 푸는건 정렬만 이용해서 푸는것. 이분 탐색으로 다시 풀기
public class Main_7795_sort {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int testCase;
    private static int numberOfA;
    private static int numberOfB;
    private static int[] valuesOfA;
    private static int[] valuesOfB;

    private static void input() throws IOException {
        String[] temp = br.readLine().split(" ");

        numberOfA = Integer.parseInt(temp[0]);
        numberOfB = Integer.parseInt(temp[1]);

        valuesOfA = new int[numberOfA];
        valuesOfB = new int[numberOfB];

        temp = br.readLine().split(" ");

        for (int i = 0; i < numberOfA; i++) {
            valuesOfA[i] = Integer.parseInt(temp[i]);
        }

        temp = br.readLine().split(" ");

        for (int i = 0; i < numberOfB; i++) {
            valuesOfB[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(valuesOfA);
        Arrays.sort(valuesOfB);
    }

    private static void process() {
        int maxCountThatCanEat = 0;
        int indexThatCantEat = 0;
        int sumOfCanBeEaten = 0;

        for (int i = 0; i < numberOfA; i++) {
            if (indexThatCantEat == numberOfB) {   // valueOfA[i-1]이 B를 다 먹을 수 있을 떄
                sumOfCanBeEaten += numberOfB;      // valueOfA[i]도 B를 다 먹을 수 있음
            } else {
                for (int j = indexThatCantEat; j < numberOfB; j++) {    // valueOfA[i-1]이 먹은 애들은 valueOfA[i]도 무조건 먹을 수 있음
                    if (valuesOfA[i] > valuesOfB[j]) {
                        maxCountThatCanEat++;
                        indexThatCantEat++;
                    } else {
                        break;
                    }
                }

                sumOfCanBeEaten += maxCountThatCanEat;
            }
        }

        sb.append(sumOfCanBeEaten).append('\n');
    }

    public static void main(String[] args) throws IOException {
        inputTestCase();

        for (int i = 0; i < testCase; i++) {
            input();
            process();
        }

        System.out.println(sb);
    }

    private static void inputTestCase() throws IOException {
        testCase = Integer.parseInt(br.readLine());
    }
}
