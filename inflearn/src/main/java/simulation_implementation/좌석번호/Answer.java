package simulation_implementation.좌석번호;

import java.util.Arrays;

class Answer {

    public int[] solution(int columns, int rows, int targetSeat) {
        // 유효한 좌석 번호인지 확인
        if (targetSeat > columns * rows) return new int[] {0, 0};

        int[][] seats = new int[columns][rows];
        int[] directionX = {-1, 0, 1, 0}; // 상, 우, 하, 좌
        int[] directionY = {0, 1, 0, -1};
        
        int currentX = 0, currentY = 0;
        int seatCount = 1; // 현재 좌석 번호
        int directionIndex = 1; // 현재 방향 (우쪽)

        while (seatCount < targetSeat) {
            // 다음 위치 계산
            int nextX = currentX + directionX[directionIndex];
            int nextY = currentY + directionY[directionIndex];

            // 경계 및 이미 점유된 좌석 체크
            if (isOutOfBounds(nextX, nextY, columns, rows) || seats[nextX][nextY] > 0) {
                directionIndex = (directionIndex + 1) % 4; // 방향 변경
                continue;
            }

            // 현재 좌석 번호 기록
            seats[currentX][currentY] = seatCount;
            seatCount++;

            // 현재 위치 업데이트
            currentX = nextX;
            currentY = nextY;
        }

        return new int[] {currentX + 1, currentY + 1}; // 1-based index로 반환
    }

    private boolean isOutOfBounds(int x, int y, int columns, int rows) {
        return x < 0 || x >= columns || y < 0 || y >= rows;
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        System.out.println(Arrays.toString(answer.solution(6, 5, 12)));    
        System.out.println(Arrays.toString(answer.solution(6, 5, 20)));
        System.out.println(Arrays.toString(answer.solution(6, 5, 30)));
        System.out.println(Arrays.toString(answer.solution(6, 5, 31)));
    }
}
