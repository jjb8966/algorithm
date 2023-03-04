package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1244 {

    static int numberOfSwitches;
    static int numberOfStudents;
    static boolean[] switchOn;
    static List<Student> students = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static class Student {
        int gender;
        int switchNumber;

        public Student(int gender, int switchNumber) {
            this.gender = gender;
            this.switchNumber = switchNumber;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfSwitches = Integer.parseInt(br.readLine());

        switchOn = new boolean[numberOfSwitches + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfSwitches; i++) {
            int onOrOff = Integer.parseInt(st.nextToken());

            if (onOrOff == 1) {
                switchOn[i] = true;
            } else {
                switchOn[i] = false;
            }
        }

        numberOfStudents = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfStudents; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int switchNumber = Integer.parseInt(st.nextToken());

            students.add(new Student(gender, switchNumber));
        }
    }

    private static void process() {
        for (Student student : students) {
            // 남자
            if (student.gender == 1) {
                maleChangeBulb(student.switchNumber);
            }

            // 여자
            if (student.gender == 2) {
                femaleChangeBulb(student.switchNumber);
            }
        }

        for (int number = 1; number <= numberOfSwitches; number++) {
            if (switchOn[number]) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }

            if (number % 20 == 0) {
                sb.append('\n');
            }
        }
    }

    private static void maleChangeBulb(int switchNumber) {
        for (int number = 1; number <= numberOfSwitches; number++) {
            if (number % switchNumber == 0) {
                turn(number);
            }
        }
    }

    private static void femaleChangeBulb(int switchNumber) {
        int count = 1;

        turn(switchNumber);

        while (switchNumber - count > 0 && switchNumber + count <= numberOfSwitches) {
            if (!isSame(switchNumber, count)) {
                break;
            }

            turn(switchNumber - count);
            turn(switchNumber + count);
            count++;
        }
    }

    private static boolean isSame(int switchNumber, int count) {
        return switchOn[switchNumber - count] == switchOn[switchNumber + count];
    }

    private static void turn(int number) {
        if (switchOn[number]) {
            switchOn[number] = false;
        } else {
            switchOn[number] = true;
        }
    }

    private static void output() {
        System.out.println(sb);
    }

}