package binary_search;

import java.util.Arrays;
import java.util.Scanner;

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
    private static Scanner sc = new Scanner(System.in);
    private static int countOfTree;
    private static int neededHeight;          // N : 나무의 수(1~100만), M : 가져갈 나무의 길이(1~20억)
    private static int[] treeHeights;     // 나무의 높이(1~10억)

    public static void input() {
        countOfTree = sc.nextInt();
        neededHeight = sc.nextInt();

        treeHeights = new int[countOfTree];

        for (int i = 0; i < countOfTree; i++) {
            treeHeights[i] = sc.nextInt();
        }

        Arrays.sort(treeHeights);
    }

    // 풀이의 핵심이 되는 메소드. 답이 되는 조건을 잘 파악하고 작성할 것.
    // 나무 높이 height를 설정했을 때 M의 나무를 가져갈 수 있는가? Y / N
    public static boolean isCorrect(int height) {
        long sum = 0;     //나무의 최대 높이는 10억이고 나무의 최대 갯수는 100만이기 때문에 sum의 최댓값은 10억 * 100만이므로 int로 선언하면 오버플로우 발생

        for (int i = 0; i < treeHeights.length; i++) {
            if (treeHeights[i] > height) {
                sum += treeHeights[i] - height;
            }
        }

        if (sum >= neededHeight) {       //height 높이로 자른 나무 길이 총합이 M보다 크거나 같은 경우 true
            return true;
        }

        return false;
    }

    // Parametric Search에서 반복적으로 사용되는 메소드 -> 암기!!!!!!!!!!!
    // left, right만 문제에 맞게 작성해주면 됨
    public static void parametricSearch() {
        int left = 0;
        int right = 1_000_000_000;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isCorrect(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        parametricSearch();
    }
}
