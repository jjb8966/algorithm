package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15970 {

    private static Dot[] dots;
    private static int numberOfDot;
    private static int sumOfArrow = 0;

    static class Dot implements Comparable<Dot>{
        int coordinate;
        int color;

        @Override
        public int compareTo(Dot other) {
            return this.coordinate - other.coordinate;
        }

        public boolean isSameColor(Dot other) {
            if (this.color == other.color) {
                return true;
            }

            return false;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfDot = Integer.parseInt(br.readLine());

        dots = new Dot[numberOfDot];

        for (int i = 0; i < numberOfDot; i++) {
            st = new StringTokenizer(br.readLine());

            dots[i] = new Dot();
            dots[i].coordinate = Integer.parseInt(st.nextToken());
            dots[i].color = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        Arrays.sort(dots);  // 좌표 기준으로 오름차순 정렬

        Dot leftDot;
        Dot rightDot;

        for (int targetIndex = 0; targetIndex < numberOfDot; targetIndex++) {
            Dot targetDot = dots[targetIndex];
            int lengthOfArrow;
            int leftLength = 0;
            int rightLength = 0;

            // 왼쪽 화살표 길이 구하기
            for (int leftIndex = targetIndex - 1; leftIndex >= 0; leftIndex--) {
                if (targetDot.isSameColor(dots[leftIndex])) {
                    leftDot = dots[leftIndex];
                    leftLength = targetDot.coordinate - leftDot.coordinate;
                    break;
                }
            }

            // 오른쪽 화살표 길이 구하기
            for (int rightIndex = targetIndex + 1; rightIndex < numberOfDot; rightIndex++) {
                if (targetDot.isSameColor(dots[rightIndex])) {
                    rightDot = dots[rightIndex];
                    rightLength = rightDot.coordinate - targetDot.coordinate;
                    break;
                }
            }

            if (leftLength == 0) {          // 왼쪽에 점이 없는 경우
                lengthOfArrow = rightLength;
            } else if (rightLength == 0) {  // 오른쪽에 점이 없는 경우
                lengthOfArrow = leftLength;
            } else {
                lengthOfArrow = Math.min(leftLength, rightLength);
            }

            sumOfArrow += lengthOfArrow;
        }
    }

    private static void output() {
        System.out.println(sumOfArrow);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}