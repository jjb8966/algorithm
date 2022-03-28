package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15970 {
    private static int N;       //점의 개수
    private static int[] distances;
    private static Dot[] dots;

    static class Dot implements Comparable<Dot> {
        private int coordinate;
        private int color;

        public void setCoordinate(int coordinate) {
            this.coordinate = coordinate;
        }

        public void setColor(int color) {
            this.color = color;
        }

        // 오름차순 : this - 매개변수
        @Override
        public int compareTo(Dot other) {               // 1. color를 기준으로 오름차순 정렬
            if (this.color != other.color) {
                return this.color - other.color;
            }

            return this.coordinate - other.coordinate;   // 2. coordinate를 기준으로 오름차순 정렬
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dots = new Dot[N];
        distances = new int[N];

        for (int i = 0; i < N; i++) {
            dots[i] = new Dot();
            dots[i].setCoordinate(sc.nextInt());
            dots[i].setColor(sc.nextInt());
        }
    }

    public static void getResult() {
        int leftDistance;
        int rightDistance;
        int result = 0;
        Dot leftDot;
        Dot rightDot;

        Arrays.sort(dots);

        // dots[i]에 대해 왼쪽 점과 오른쪽 점을 정하고 둘 중 더 거리가 짧은 점의 거리를 선택
        for (int i = 0; i < dots.length; i++) {     // i = 0 : 가장 왼쪽 점, i = dots.length-1 : 가장 오른쪽 점
            if (i != 0 && dots[i - 1].color == dots[i].color) {     //i=0인 경우 dots[i-1]에서 NPE 발생하기 때문에 제외
                leftDot = dots[i - 1];
                leftDistance = Math.abs(dots[i].coordinate - leftDot.coordinate);
            } else {
                leftDistance = 0;
            }

            if (i != dots.length - 1 && dots[i].color == dots[i + 1].color) {   // i=dots.length-1인 경우 dots[i+1]에서 NPE 발생하기 때문에 제외
                rightDot = dots[i + 1];
                rightDistance = Math.abs(dots[i].coordinate - rightDot.coordinate);
            } else {
                rightDistance = 0;
            }

            if (leftDistance == 0) {
                distances[i] = rightDistance;
            } else if (rightDistance == 0) {
                distances[i] = leftDistance;
            } else if (leftDistance < rightDistance) {
                distances[i] = leftDistance;
            } else {
                distances[i] = rightDistance;
            }
        }

        for (int i : distances) {
            result += i;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        getResult();
    }
}
