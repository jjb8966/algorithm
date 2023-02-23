package array;

import java.util.Scanner;

public class Main_10807 {
    public static void main(String[] args) {
        int N, number;
        int count = 0;
        int[] array;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        array = new int[N];

        for(int i=0; i<N; i++){
            array[i] = sc.nextInt();
        }

        number = sc.nextInt();
        for(int i : array){
            if(i==number){
                count++;
            }
        }
        System.out.print(count);
    }
}
