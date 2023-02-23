package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663 {

    private static int matrixSize;
    private static int result;
    private static int[][] matrix;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        matrixSize = Integer.parseInt(br.readLine());
        matrix = new int[matrixSize + 1][matrixSize + 1];   // matrix : 1 ~ matrixSize
    }

    private static void process() {
        int firstRow = 1;

        recurrenceFunction(firstRow);
    }

    private static void recurrenceFunction(int startRow) {
        if (startRow > matrixSize) {
            result++;
        } else {
            for (int column = 1; column <= matrixSize; column++) {
                if (attackable(startRow, column)) {
                    continue;
                }

                matrix[startRow][column] = 1;
                recurrenceFunction(startRow + 1);
                matrix[startRow][column] = 0;
            }
        }
    }

    private static boolean attackable(int row, int column) {
        for (int checkRow = 1; checkRow <= row - 1; checkRow++) {
            if (matrix[checkRow][column] == 1) {    // 같은 column 에 있으면 공격 가능
                return true;
            }
        }

        for (int checkRow = 1; checkRow <= row - 1; checkRow++) {                   // 매개변수 row 보다 높은 행에는 체스말이 없음
            for (int checkColumn = 1; checkColumn <= matrixSize; checkColumn++) {   // checkColumn 은 매개변수 column 보다 클 수 있음
                if (matrix[checkRow][checkColumn] == 1) {
                    if (checkRow + checkColumn == row + column) {   // 오른쪽 대각선에 있으면 공격 가능
                        return true;
                    }

                    if (checkRow - checkColumn == row - column) {   // 왼쪽 대각선에 있으면 공격 가능
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static void output() {
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
}
