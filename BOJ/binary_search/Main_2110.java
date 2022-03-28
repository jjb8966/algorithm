package binary_search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제 : C개의 공유기를 N개의 집에 적당히 설치할 때 가장 인접한 두 공유기 사이가 최대인 거리 distance를 찾아라.
 * 뒤집은 문제 : 가장 인접한 두 공유기 사이의 거리를 distance로 했을 때 C개의 공유기를 N개의 집에 설치할 수 있는가? Y / N
 * 정답 : 가장 마지막으로 Y가 나오는 거리 distance
 */
public class Main_2110 {
    private static Scanner sc = new Scanner(System.in);
    private static int numberOfHouse;
    private static int numberOfRouter;            // N : 집의 개수 (2~2만), C : 공유기의 개수 (2~N)
    private static int[] coordinates;    // coordinate : 좌표 (0~10억)

    public static void input() {
        numberOfHouse = sc.nextInt();
        numberOfRouter = sc.nextInt();

        coordinates = new int[numberOfHouse];

        for (int i = 0; i < numberOfHouse; i++) {
            coordinates[i] = sc.nextInt();
        }

        Arrays.sort(coordinates);
    }

    // 풀이의 핵심이 되는 메소드. 답이 되는 조건을 잘 파악하고 작성할 것.
    // 가장 인접한 두 공유기 사이의 거리를 distance로 했을 때 C개의 공유기를 N개의 집에 설치할 수 있는가? Y / N
    public static boolean determinate(int distance) {
        int numberOfRoutersCanBeInstalled = 1;     //가장 왼쪽 집은 무조건 공유기를 설치함
        int currentCoordinate;
        int compareCoordinate;
        int gap;

        currentCoordinate = coordinates[0];

        for (int i = 1; i < numberOfHouse; i++) {
            compareCoordinate = coordinates[i];
            gap = compareCoordinate - currentCoordinate;        // 오름차순으로 정렬했기 때문에 가능한 수식

            if (gap >= distance) {
                numberOfRoutersCanBeInstalled++;
                currentCoordinate = compareCoordinate;
            }

            if (numberOfRoutersCanBeInstalled == numberOfRouter) {
                return true;
            }
        }

        return false;
    }

    // Parametric Search에서 반복적으로 사용되는 메소드 -> 암기!!!!!!!!!!!
    // left, right만 문제에 맞게 작성해주면 됨
    public static void parametricSearch() {
        int left = 0;
        int right = 1000000000;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (determinate(mid)) {
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

