package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17266 {

    private static int lengthOfTunnel;
    private static int numberOfStreetLamp;
    private static int[] coordinateOfStreetLamp;
    private static int minStreetLampLength;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        lengthOfTunnel = Integer.parseInt(br.readLine());
        numberOfStreetLamp = Integer.parseInt(br.readLine());

        coordinateOfStreetLamp = new int[numberOfStreetLamp];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfStreetLamp; i++) {
            coordinateOfStreetLamp[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void process() {
        binarySearch(1, lengthOfTunnel);
    }

    private static void binarySearch(int minLength, int maxLength) {
        int currentLength = (minLength + maxLength) / 2;

        if (minLength > maxLength) {
            return;
        }

        if (isAllBright(currentLength)) {
            minStreetLampLength = currentLength;
            maxLength = currentLength - 1;
        } else {
            minLength = currentLength + 1;
        }

        binarySearch(minLength, maxLength);
    }

    private static boolean isAllBright(int currentLength) {
        int lastBrightArea = 0;

        for (int i = 0; i < numberOfStreetLamp; i++) {
            if (coordinateOfStreetLamp[i] - lastBrightArea <= currentLength) {  // 가로등의 왼쪽 부분이 전부 밝은지 확인
                lastBrightArea = coordinateOfStreetLamp[i] + currentLength;     // 마지막 밝은 위치 업데이트
            }
        }

        return lastBrightArea >= lengthOfTunnel;
    }

    private static void output() {
        System.out.println(minStreetLampLength);
    }

}
