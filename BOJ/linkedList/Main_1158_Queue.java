package linkedList;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1158_Queue {

    public static void main(String[] args) {
        //LinkedList를 이용해 Queue를 구현함
        Queue<Integer> queue = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);
        int N, K;

        N = sc.nextInt();
        K = sc.nextInt();

        System.out.print("<");

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int index = 0;
        int count = 1;
        int[] result = new int[N];
        while (!queue.isEmpty()) {
            if (count % K == 0) {
                result[index] = queue.poll();
                index++;
                count++;
            } else {
                queue.offer(queue.poll());
                count++;
            }

        }
        for (int i = 0; i < N; i++) {
            if (i != N - 1) {
                System.out.print(result[i] + ", ");
            } else {
                System.out.print(result[i]);
            }
        }
        System.out.println(">");
    }
}