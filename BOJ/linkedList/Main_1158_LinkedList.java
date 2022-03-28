package linkedList;

import java.util.Scanner;
import java.util.LinkedList;

public class Main_1158_LinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);
        int N, K;

        N = sc.nextInt();
        K = sc.nextInt();

        System.out.print("<");

        //1~7 linkedlist 만듦
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = 0;
        int count = 1;
        int[] result = new int[N];

        while (!list.isEmpty()) {
            if (count % K == 0) {
                result[index] = list.remove();
                index++;
                count++;
            } else {
                list.add(list.remove());
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