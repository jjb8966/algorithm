import java.util.*;
import java.util.ArrayList;

class Solution {
	public int[] solution(int[][] board, int k){
		// init
		int[] answer = new int[2];
		int n = board.length;
		int[][] direction = {
			{1, 0},
			{0, 1},
			{-1, 0},
			{0, -1}
		};

		// process
		int currentDir = 0;
		int time = 0;
		int x = 0;
		int y = 0;

		while (time < k) {
			int previousX = x;
			int previousY = y;
			x = x + direction[currentDir][0];
			y = y + direction[currentDir][1];

			// 1.
			if(x < 0 || y < 0 || x >= n || y >= n) {
				time++;
				currentDir = (currentDir + 1) % 4;
				x = previousX;
				y = previousY;

				continue;
			}

			// 2.
			if(board[y][x] == 1) {
				time++;
				currentDir = (currentDir + 1) % 4;
				x = previousX;
				y = previousY;

				continue;
			}

			time++;
		}

		answer[0] = y;
		answer[1] = x;

		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();

		int[][] arr1 = {{0, 0, 0, 0, 0}, 
			{0, 1, 1, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr1, 10)));

		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 1}, 
			{1, 1, 0, 0, 1, 0}, 
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));

		int[][] arr3 = {{0, 0, 1, 0, 0}, 
			{0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));
	}
}