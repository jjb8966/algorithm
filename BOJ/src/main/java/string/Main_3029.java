package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3029 {

    static String currentTime;
    static String targetTime;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        currentTime = br.readLine();
        targetTime = br.readLine();
    }

    private static void process() {
        int hour;
        int minute;
        int second;
        String[] current = currentTime.split(":");
        String[] target = targetTime.split(":");

        if (currentTime.equals(targetTime)) {
            sb.append("24:00:00");
            return;
        }

        hour = Integer.parseInt(target[0]) - Integer.parseInt(current[0]);
        minute = Integer.parseInt(target[1]) - Integer.parseInt(current[1]);
        second = Integer.parseInt(target[2]) - Integer.parseInt(current[2]);

        if (second < 0) {
            second += 60;
            minute--;
        }

        if (minute < 0) {
            minute += 60;
            hour--;
        }

        if (hour < 0) {
            hour += 24;
        }

        sb = hour < 10 ? sb.append(0).append(hour).append(":") : sb.append(hour).append(":");
        sb = minute < 10 ? sb.append(0).append(minute).append(":") : sb.append(minute).append(":");
        sb = second < 10 ? sb.append(0).append(second) : sb.append(second);
    }

    private static void output() {
        System.out.println(sb);
    }

}