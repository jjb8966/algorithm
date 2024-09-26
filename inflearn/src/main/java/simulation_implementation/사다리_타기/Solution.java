package simulation_implementation.사다리_타기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public char[] solution(int n, int[][] ladder){
		// init
		char[] answer = new char[n + 1];

		int maxLine = ladder.length;
		List[] right = new List[maxLine];
		List[] left = new List[maxLine];

		for (int i = 0; i < maxLine; i++) {
			int[] lineData = ladder[i];
			List rightLine = new ArrayList(); 
			List leftLine = new ArrayList(); 

			for(int number : lineData) {
				rightLine.add(number);
				leftLine.add(number + 1);
			}

			right[i] = rightLine;
			left[i] = leftLine;
		}

		// process
		for(int studentIdx = 1; studentIdx <= n; studentIdx++) {
			int currentLine = studentIdx;

			for(int line = 0; line < maxLine; line++) {
				List rightLine = right[line];
				List leftLine = left[line];

				if(rightLine.contains(currentLine)) {
					currentLine++;
					continue;
				}

				if(leftLine.contains(currentLine)) {
					currentLine--;
				}
			}

			answer[currentLine] = (char) (studentIdx + 64);
		}

		char[] result = new char[n];
		for(int i=1; i<=n; i++) {
			result[i-1] = answer[i];
		}
		
		return result;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(5, new int[][] { { 1, 3 }, { 2, 4 }, { 1, 4 } })));
		System.out.println(Arrays.toString(T.solution(7, new int[][] { { 1, 3, 5 }, { 1, 3, 6 }, { 2, 4 } })));
		System.out.println(
				Arrays.toString(T.solution(8, new int[][] { { 1, 5 }, { 2, 4, 7 }, { 1, 5, 7 }, { 2, 5, 7 } })));
		System.out.println(Arrays.toString(T.solution(12,
				new int[][] { { 1, 5, 8, 10 }, { 2, 4, 7 }, { 1, 5, 7, 9, 11 }, { 2, 5, 7, 10 }, { 3, 6, 8, 11 } })));
	}
}