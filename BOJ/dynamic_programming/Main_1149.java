package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149 {

    private final static int RED = 0;
    private final static int GREEN = 1;
    private final static int BLUE = 2;

    private static int numberOfHouse;
    private static int[][] costOfPainting;
    private static int[][] minimumCost;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        numberOfHouse = Integer.parseInt(st.nextToken());

        costOfPainting = new int[numberOfHouse][3];
        minimumCost = new int[numberOfHouse][3];
        result = new int[numberOfHouse];

        for (int house = 0; house < numberOfHouse; house++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            costOfPainting[house][RED] = r;
            costOfPainting[house][GREEN] = g;
            costOfPainting[house][BLUE] = b;
        }
    }

    private static void process() {
        // 초기값
        for (int color = RED; color <= BLUE; color++) {
            minimumCost[0][color] = costOfPainting[0][color];
        }

        result[0] = Arrays.stream(minimumCost[0]).min().getAsInt();

        // 점화식
        for (int house = 1; house < numberOfHouse; house++) {
            for (int finalColor = RED; finalColor <= BLUE; finalColor++) {
                int[] otherColor = findOtherColor(finalColor);
                int leftOperand = minimumCost[house - 1][otherColor[0]];
                int rightOperand = minimumCost[house - 1][otherColor[1]];

                minimumCost[house][finalColor] = costOfPainting[house][finalColor] + Math.min(leftOperand, rightOperand);
            }

            result[house] = Arrays.stream(minimumCost[house]).min().getAsInt();
        }
    }

    private static int[] findOtherColor(int targetColor) {
        int[] result = new int[2];
        int index = 0;

        for (int color = RED; color <= BLUE; color++) {
            if (targetColor != color) {
                result[index] = color;
                index++;
            }
        }

        return result;
    }

    private static void output() {
        System.out.println(result[numberOfHouse - 1]);
    }

}
