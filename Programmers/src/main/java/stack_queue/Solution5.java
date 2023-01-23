package stack_queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution5 {

    static class Truck {

        int weight;
        int count;

        public Truck(int weight, int count) {
            this.weight = weight;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "weight=" + weight +
                    ", count=" + count +
                    '}';
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weighs) {
        int sum = 0;
        int temp = 0;
        int time = 0;

        Queue<Truck> waitQueue = new LinkedList<>();
        Queue<Truck> progressQueue = new LinkedList<>();

        for (int truckWeigh : truck_weighs) {
            waitQueue.offer(new Truck(truckWeigh, 0));
        }

        while (!waitQueue.isEmpty() || !progressQueue.isEmpty()) {
            time++;

            Iterator<Truck> iterator = progressQueue.iterator();
            while (iterator.hasNext()) {
                Truck truck = iterator.next();

                if (truck.count == bridge_length) {
                    iterator.remove();
                    sum -= truck.weight;
                }
            }

            if (!waitQueue.isEmpty()) {
                Truck candidateTruck = waitQueue.element();

                temp = sum + candidateTruck.weight;

                if (temp <= weight) {
                    progressQueue.add(waitQueue.poll());
                    sum = temp;
                }
            }

            for (Truck truck : progressQueue) {
                truck.count++;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Solution5 prob = new Solution5();

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weighs = {7, 4, 5, 6};

        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weighs2 = {10};

        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weighs3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        System.out.println(prob.solution(bridge_length, weight, truck_weighs));
        System.out.println(prob.solution(bridge_length2, weight2, truck_weighs2));
        System.out.println(prob.solution(bridge_length3, weight3, truck_weighs3));
    }

}