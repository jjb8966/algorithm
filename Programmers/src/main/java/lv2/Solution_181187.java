package lv2;

public class Solution_181187 {

    public long solution(int r1, int r2) {
        long answer = 0;
        long innerBorder = (long) Math.pow(r1, 2);
        long outerBorder = (long) Math.pow(r2, 2);

        for (int y = 1; y <= r2; y++) {
            int start = (int) Math.ceil(Math.sqrt(innerBorder - Math.pow(y, 2)));
            int end = (int) Math.floor(Math.sqrt(outerBorder - Math.pow(y, 2)));

            answer += (end - start + 1);
        }

        answer *= 4;

        return answer;
    }

    public static void main(String[] args) {
        Solution_181187 prob = new Solution_181187();

        int r1 = 2;
        int r2 = 3;

        System.out.println(prob.solution(r1, r2));
    }

}