package simulation_implementation.잃어버린_강아지;

import java.util.*;

class Solution {
	public int solution(int[][] board){
        int finderDir = 0;
        int dogDir = 0;
        int[] finder = new int[2];
        int[] dog = new int[2];
        int[][] direction = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
        };

        // finder, dog init
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if(board[y][x] == 2) {
                    finder[0] = x;
                    finder[1] = y;
                }

                if(board[y][x] == 3) {
                    dog[0] = x;
                    dog[1] = y;
                }
            }
        }

        int time = 0;
        while(time < 10000) {
            // move finder
            int finderX = finder[0] + direction[finderDir][0];
            int finderY = finder[1] + direction[finderDir][1];

            if(finderX < 0 || finderY < 0 || finderX >= 10 || finderY >= 10) {
                finderDir = (finderDir + 1) % 4;
                continue;
            }

            if(board[finderY][finderX] == 1) {
                finderDir = (finderDir + 1) % 4;
                continue;
            }

            finder[0] = finderX;
            finder[1] = finderY;

            // move dog
            int dogX = dog[0] + direction[dogDir][0];
            int dogY = dog[1] + direction[dogDir][1];

            if(dogX < 0 || dogY < 0 || dogX >= 10 || dogY >= 10) {
                dogDir = (dogDir + 1) % 4;
                continue;
            }

            if(board[finderY][finderX] == 1) {
                dogDir = (dogDir + 1) % 4;
                continue;
            }

            dog[0] = dogX;
            dog[1] = dogY;

            // check meet
            if((finder[0] == dog[0]) && (finder[1] == dog[1])) {
                break;
            }

            time++;
        }

		return time;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		int[][] arr1 = {
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 2, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 3, 0, 0, 0, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
        }; 
		System.out.println(T.solution(arr1));

		int[][] arr2 = {
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}
        }; 
		System.out.println(T.solution(arr2));
	}
}
