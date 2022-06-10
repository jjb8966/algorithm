package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [매개변수 탐색] - 문제에서 최대값/최솟값 구해야 하는 경우 시도해볼만 함
 * 1. 정답을 매개변수로 만들고 Y/N 문제로 바꿔보기
 * 2. 매개변수는 Y/N로 정렬된 상태
 * 3. 이분탐색으로 경계값(정답) 찾기
 * <p>
 * 문제 : M미터의 나무를 집에 가져가기 위해 잘라야 하는 나무 높이 height의 최댓값은?
 * 뒤집은 문제 : 나무 높이 height를 설정했을 때 M의 나무를 가져갈 수 있는가? Y / N
 * 마지막 Y가 나온 나무 높이가 최댓값
 */

public class Main_2805 {

    private static int numberOfTree;
    private static int needTreeHeight;
    private static int[] treeHeights;

    private static int findHeight = 0;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfTree = Integer.parseInt(st.nextToken());
        needTreeHeight = Integer.parseInt(st.nextToken());

        treeHeights = new int[numberOfTree];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfTree; i++) {
            treeHeights[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        binarySearch();
    }

    private static void binarySearch() {
        long start = 1L;
        long end = 2_000_000_000L;
        long height;

        while (start <= end) {
            // 여기서 height를 int로 두고 형변환했다가 틀렸음!!
            height = (start + end) / 2;
            // int height = (int) (start + end) / 2; -> X

            if (isRightHeight(height)) {
                start = height + 1;
                findHeight = (int) height;
            } else {
                end = height - 1;
            }
        }
    }

    private static boolean isRightHeight(long candidateHeight) {
        long sumOfTree = cutTrees(candidateHeight);

        if (sumOfTree >= needTreeHeight) {
            return true;
        } else {
            return false;
        }
    }

    private static long cutTrees(long candidateHeight) {
        long sum = 0;

        for (int treeHeight : treeHeights) {
            if (treeHeight > candidateHeight) {
                sum += treeHeight - candidateHeight;
            }
        }

        return sum;
    }

    private static void output() {
        System.out.println(findHeight);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
