package array;

import java.util.Scanner;

public class Main_10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        int[] array = new int[26]; //알파벳 개수 = 26

        for(int i=0; i<length;i++) {
            for(char alphaA=97; alphaA<=122; alphaA++) { //a~z 아스키코드 : 97~122
                if (str.charAt(i) == alphaA) {
                    ++array[alphaA - 97];
                }
            }
        }
        for(int i=0; i<26; i++){
            if(i!=25) {
                System.out.print(array[i] + " ");
            } else {
                System.out.println(array[i]);
            }
        }
    }
}
