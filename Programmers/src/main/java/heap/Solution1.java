package heap;

import java.util.PriorityQueue;

class Solution1 {

    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int s : scoville) {
            heap.offer(s);
        }

        while (heap.peek() < K) {
            if (heap.size() == 1) {
                return -1;
            }

            Integer firstMin = heap.poll();
            Integer secondMin = heap.poll();

            int mix = firstMin + (secondMin * 2);
            heap.offer(mix);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution1 prob = new Solution1();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(prob.solution(scoville, K));
    }
}
