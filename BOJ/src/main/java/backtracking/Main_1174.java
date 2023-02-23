package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_1174 {

    static int target;
    static int[] numbers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static Long result;
    static ArrayList<Long> descNumber = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
    }

    private static void process() {
        // 1023번째 내림수 = 9876543210
        if (target > 1023) {
            result = -1L;
            return;
        }

        dfs(0, "");
        Collections.sort(descNumber);

        result = descNumber.get(target - 1);
    }

    private static void dfs(int digit, String number) {
        if (digit == 10) {
            // 아무것도 선택하지 않은 경우 제외
            if (number.equals("")) {
                return;
            }

            descNumber.add(Long.valueOf(number));

            return;
        }

        // 선택 X
        dfs(digit + 1, number);

        // 선택 O
        dfs(digit + 1, number + numbers[digit]);

    }

    private static void output() {
        System.out.println(result);
    }

}