package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main_11066 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int numberOfFile;
    private static ArrayList<Integer> fileSizes;
    private static int[][] dynamicSolution;     // dynamicSolution[i][j] : i ~ j번째 파일을 합치는데 필요한 최소비용
    private static int[][] sumOfSequence;       // sumOfSequence[i][j] : i ~ j번째 파일을 모두 합친 값

    private static void input() throws IOException {
        numberOfFile = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        fileSizes = new ArrayList<>();

        for (int i = 0; i < numberOfFile; i++) {
            fileSizes.add(Integer.parseInt(temp[i]));
        }

        dynamicSolution = new int[numberOfFile][numberOfFile];
    }

    private static void preProcess() throws IOException {
        sumOfSequence = new int[numberOfFile][numberOfFile];

        for (int i = 0; i < numberOfFile; i++) {
            for (int j = 0; j < numberOfFile; j++) {
                // 1. sumOfSequence 초기화
                if (i != j) {
                    // fileSizes의 i번째 부터 j번째 까지 모두 더한 값
                    sumOfSequence[i][j] = IntStream.range(i, j + 1)
                            .mapToObj(x -> fileSizes.get(x))
                            .reduce(0, Integer::sum);   // 0 + (i번째 값) + (i+1번째 값) ... + (j번째 값)
                }
                // 2. dynamicSolution 초기화 (최대값으로)
                dynamicSolution[i][j] = Integer.MAX_VALUE;  // 최소값을 찾는 과정이므로 최대값으로 초기화
            }
        }
    }

    private static void process() {
        // 초기값
        for (int i = 0; i < numberOfFile; i++) {
            dynamicSolution[i][i] = 0;
        }

        // 점화식 - 반드시 이해하고 작성하기
        for (int length = 2; length <= numberOfFile; length++) {
            for (int i = 0; i <= numberOfFile - length; i++) {
                int j = length + i - 1;     // 파일의 길이와 i값을 알면 j값을 알 수 있음

                for (int k = i; k < j; k++) {
                    dynamicSolution[i][j] = Math.min(dynamicSolution[i][j], dynamicSolution[i][k] + dynamicSolution[k + 1][j] + sumOfSequence[i][j]);
                }

            }
        }

        sb.append(dynamicSolution[0][numberOfFile - 1]).append("\n");       // 테스트 케이스 별 결과를 저장
    }

    public static void main(String[] args) throws IOException {
        int numberOfTestCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfTestCase; i++) {
            input();
            preProcess();
            process();
        }

        System.out.println(sb);
    }
}
