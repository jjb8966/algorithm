package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution1 {

    List<Integer> result = new ArrayList<>();

    public int[] solution(int[] array, int[][] commands) {
        for (int[] command : commands) {
            List<Integer> temp = new ArrayList<>();

            int start = command[0] - 1;
            int end = command[1];
            int targetIndex = command[2] - 1;

            IntStream.range(start, end)
                    .forEach(i -> temp.add(array[i]));

            Collections.sort(temp);
            result.add(temp.get(targetIndex));
        }

        return result.stream()
                .mapToInt(n -> n)
                .toArray();
    }

    public int[] solution2(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        for (int i = 0; i < result.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int targetIndex = commands[i][2] - 1;

            int[] temp = Arrays.copyOfRange(array, start, end);
            Arrays.sort(temp);

            result[i] = temp[targetIndex];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1 prob = new Solution1();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

//        Arrays.stream(prob.solution(array, commands)).forEach(n -> System.out.print(n + " "));
        Arrays.stream(prob.solution2(array, commands)).forEach(n -> System.out.print(n + " "));
    }

}