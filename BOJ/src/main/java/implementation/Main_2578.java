package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2578 {

    public static void main(String[] args) throws IOException {
        // init
        Map<Integer, int[]> numberMap = new HashMap<>();
        int[] callNumber = new int[25];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int x = 0; x < 5; x++) {
            st = new StringTokenizer(br.readLine());

            for (int y = 0; y < 5; y++) {
                int number = Integer.parseInt(st.nextToken());
                numberMap.put(number, new int[]{x, y});
            }
        }

        int index = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                callNumber[index++] = Integer.parseInt(st.nextToken());
            }
        }

        // process
        boolean[][] isCheck = new boolean[5][5];
        int result = 0;
        int countBingo = 0;

        for (int i = 0; i < 25; i++) {
            int number = callNumber[i];
            int[] coordinate = numberMap.get(number);
            int x = coordinate[0];
            int y = coordinate[1];

            isCheck[x][y] = true;

            countBingo += checkBingGo(isCheck, x, y);

            if (countBingo >= 3) {
                result = i;
                break;
            }
        }

        // output
        System.out.println(result + 1);
    }

    static int checkBingGo(boolean[][] isCheck, int checkedX, int checkedY) {
        int countBingo = 4;

        // check row
        for (int y = 0; y < 5; y++) {
            if (!isCheck[checkedX][y]) {
                countBingo--;
                break;
            }
        }

        // check column
        for (int x = 0; x < 5; x++) {
            if (!isCheck[x][checkedY]) {
                countBingo--;
                break;
            }
        }

        int x = 0;
        int y = 0;
        // check left diagonal
        if (checkedX == checkedY) {
            for (int i = 0; i < 5; i++) {
                if (!isCheck[x][y]) {
                    countBingo--;
                    break;
                }

                x++;
                y++;
            }
        } else {
            countBingo--;
        }

        x = 0;
        y = 4;
        // check right diagonal
        if (checkedX + checkedY == 4) {
            for (int i = 0; i < 5; i++) {
                if (!isCheck[x][y]) {
                    countBingo--;
                    break;
                }

                x++;
                y--;
            }
        } else {
            countBingo--;
        }

        return countBingo;
    }
}