package sort;

import java.util.*;

public class Main_10825 {
    private static Scanner sc = new Scanner(System.in);
    private static StringBuilder sb = new StringBuilder();
    private static Element[] Students;
    private static int numberOfStudents;

    static class Element implements Comparable<Element> {
        String name;
        int korean, english, math;

        // 오름차순 : this - 매개변수
        // 내림차순 : 매개변수 - this
        @Override
        public int compareTo(Element other) {       //정렬의 기준이 되는 메소드
            // 국어 - 내림차순 -> 높은게 먼저
            if (this.korean != other.korean) {
                return other.korean - this.korean;
            }
            // 영어 - 오름차순 -> 낮은게 먼저
            if (this.english != other.english) {
                return this.english - other.english;
            }
            // 수학 - 내림차순 -> 높은게 먼저
            if (this.math != other.math) {
                return other.math - this.math;
            }
            // 이름 - 오름차순
            return this.name.compareTo(other.name);
        }
    }

    public static void input() {
        numberOfStudents = Integer.parseInt(sc.nextLine());
        Students = new Element[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            Students[i] = new Element();

            StringTokenizer st = new StringTokenizer(sc.nextLine());

            Students[i].name = st.nextToken();
            Students[i].korean = Integer.parseInt(st.nextToken());
            Students[i].english = Integer.parseInt(st.nextToken());
            Students[i].math = Integer.parseInt(st.nextToken());
        }
    }

    public static void process() {
        Arrays.sort(Students);      //오버라이딩 한 compareTo 메소드를 기준으로 정렬

        for (Element temp : Students) {
            sb.append(temp.name + "\n");
        }
    }

    public static void main(String[] args) {
        input();
        process();
        System.out.print(sb);
    }
}