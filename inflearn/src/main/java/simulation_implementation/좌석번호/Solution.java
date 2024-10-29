package simulation_implementation.좌석번호;

import java.util.*;

class Solution {
	public int[] solution(int c, int r, int k){
		int[] answer = new int[2];

        int[][] direction = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };
        boolean[][] visited = new boolean[c + 1][r + 1];

        int x = 1;
        int y = 1;
        int count = 1;
        int dir = 0;
        visited[x][y] = true;

        if (k > (c * r)) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }

        while(count < k) {
            int newX = x + direction[dir][0];
            int newY = y + direction[dir][1];

            if(newX < 1 || newY < 1 || newX > c || newY > r) {
                dir = (dir + 1) % 4;
                continue;
            }
            
            if(visited[newX][newY]) {
                dir = (dir + 1) % 4;
                continue;
            }

            x = newX;
            y = newY;

            visited[x][y] = true;
            count++;
        }

        answer[0] = x;
        answer[1] = y;
		
		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}