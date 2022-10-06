package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2343 {

    private static int numberOfVideo;
    private static int numberOfBluRay;
    private static int maxVideo;
    private static int[] videos;
    private static long minBluRayLength;


    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfVideo = Integer.parseInt(st.nextToken());
        numberOfBluRay = Integer.parseInt(st.nextToken());

        videos = new int[numberOfVideo];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfVideo; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
        }

        maxVideo = Arrays.stream(videos).max().getAsInt();
    }

    private static void process() {
        long sum = Arrays.stream(videos).sum();

        binarySearch(1, sum);

        // 비디오 크기보다 작은 블루레이로 쪼갤 수 없음
        if (minBluRayLength < maxVideo) {
            minBluRayLength = maxVideo;
        }
    }

    private static void binarySearch(long minLength, long maxLength) {
        long currentLength = (minLength + maxLength) / 2;
        int count;

        if (minLength > maxLength) {
            return;
        }

        count = getCount(currentLength);

        if (count <= numberOfBluRay) {
            maxLength = currentLength - 1;
            minBluRayLength = currentLength;
        } else {
            minLength = currentLength + 1;
        }

        binarySearch(minLength, maxLength);
    }

    private static int getCount(long currentLength) {
        int startIndex = 0;
        int endIndex = 0;
        int count = 0;
        long sum;

        while (endIndex < numberOfVideo) {
            sum = getSum(startIndex, endIndex);

            if (sum < currentLength) {
                if (endIndex == numberOfVideo - 1) {
                    count++;
                }

                endIndex++;
            }

            if (sum == currentLength) {
                startIndex = endIndex + 1;
                endIndex = endIndex + 1;
                count++;
            }

            if (sum > currentLength) {
                if (startIndex == endIndex) {
                    startIndex = endIndex + 1;
                    endIndex = endIndex + 1;
                } else {
                    startIndex = endIndex;
                }

                count++;
            }
        }

        return count;
    }

    private static long getSum(int start, int end) {
        long result = 0;

        for (int i = start; i <= end; i++) {
            result += videos[i];
        }

        return result;
    }

    private static void output() {
        System.out.println(minBluRayLength);
    }

}