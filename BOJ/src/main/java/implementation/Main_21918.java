package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21918 {

    static int numberOfBulb;
    static int numberOfCommand;
    static int[] bulbs;
    static Command[] commands;

    static class Command {
        int number;
        int operand1;
        int operand2;

        public Command(int number, int operand1, int operand2) {
            this.number = number;
            this.operand1 = operand1;
            this.operand2 = operand2;
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

        st = new StringTokenizer(br.readLine());
        numberOfBulb = Integer.parseInt(st.nextToken());
        numberOfCommand = Integer.parseInt(st.nextToken());

        bulbs = new int[numberOfBulb + 1];
        commands = new Command[numberOfCommand + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfBulb; i++) {
            bulbs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= numberOfCommand; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int operand1 = Integer.parseInt(st.nextToken());
            int operand2 = Integer.parseInt(st.nextToken());

            commands[i] = new Command(number, operand1, operand2);
        }
    }

    private static void process() {
        for (int i = 1; i <= numberOfCommand; i++) {
            int number = commands[i].number;
            int operand1 = commands[i].operand1;
            int operand2 = commands[i].operand2;

            if (number == 1) {
                bulbs[operand1] = operand2;
            }

            if (number == 2) {
                for (int index = operand1; index <= operand2; index++) {
                    if (bulbs[index] == 0) {
                        bulbs[index] = 1;
                    } else {
                        bulbs[index] = 0;
                    }
                }
            }

            if (number == 3) {
                for (int index = operand1; index <= operand2; index++) {
                    bulbs[index] = 0;
                }
            }

            if (number == 4) {
                for (int index = operand1; index <= operand2; index++) {
                    bulbs[index] = 1;
                }
            }
        }
    }

    private static void output() {
        for (int i = 1; i <= numberOfBulb; i++) {
            System.out.print(bulbs[i] + " ");
        }
    }

}