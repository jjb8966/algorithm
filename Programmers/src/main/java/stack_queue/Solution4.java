package stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int index = 0; index < priorities.length; index++) {
            queue.add(index);
        }

        while (!queue.isEmpty()) {
            Queue<Integer> tempQueue = new LinkedList<>(queue);
            Integer index = queue.poll();
            int priority = priorities[index];
            int size = queue.size();

            for (Integer other : tempQueue) {
                if (priorities[other] > priority) {
                    queue.add(index);
                    break;
                }
            }

            if (queue.size() == size) {
                result.add(index);
            }
        }

        return result.indexOf(location) + 1;
    }

    public static void main(String[] args) {
        Solution4 prob = new Solution4();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        System.out.println(prob.solution(priorities, location));
        System.out.println(prob.solution(priorities2, location2));
    }

}