package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14467 {

    static int numberOfRecord;
    static int result;
    static Queue<Integer>[] records = new Queue[10 + 1];

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 10; i++) {
            records[i] = new LinkedList<>();
        }

        numberOfRecord = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfRecord; i++) {
            st = new StringTokenizer(br.readLine());

            int cowNumber = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());

            records[cowNumber].offer(location);
        }
    }

    private static void process() {
        for (int i = 1; i <= 10; i++) {
            Queue<Integer> cowLocations = records[i];

            if (cowLocations.isEmpty()) {
                continue;
            }

            Integer location = cowLocations.poll();

            while (!cowLocations.isEmpty()) {
                Integer nextLocation = cowLocations.poll();

                if (nextLocation != location) {
                    result++;
                    location = nextLocation;
                }
            }
        }
    }

    private static void output() {
        System.out.println(result);
    }

}