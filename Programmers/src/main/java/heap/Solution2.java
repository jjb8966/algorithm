package heap;

import java.util.*;

class Solution2 {

    public int solution(int[][] jobs) {
        int length = jobs.length;
        int time = 0;
        int sum = 0;

        Queue<int[]> waitingQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        Queue<int[]> progressQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int[] job : jobs) {
            waitingQueue.add(job);
        }

        while (!progressQueue.isEmpty() || !waitingQueue.isEmpty()) {
            while (!waitingQueue.isEmpty() && waitingQueue.peek()[0] <= time) {
                progressQueue.offer(waitingQueue.poll());
            }

            if (progressQueue.isEmpty()) {
                time = waitingQueue.peek()[0];
            } else {
                int[] job = progressQueue.poll();
                time += job[1];
                sum += time - job[0];
            }
        }

        return sum / length;
    }

    public static void main(String[] args) {
        Solution2 prob = new Solution2();
        int[][] job = {
                {0, 3},
                {1, 9},
                {2, 6}
        };

        int[][] job2 = {
                {0, 3},
                {5, 3}
        };

        int[][] job3 = {
                {7, 8},
                {3, 5},
                {9, 6}
        };

        int[][] job4 = {
                {0, 3},
                {2, 4},
                {3, 2}
        };

        System.out.println(prob.solution(job));
        System.out.println(prob.solution(job2));
        System.out.println(prob.solution(job3));
        System.out.println(prob.solution(job4));
    }
}
