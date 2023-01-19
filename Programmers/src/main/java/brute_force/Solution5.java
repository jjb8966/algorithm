package brute_force;

public class Solution5 {

    int length;
    int answer = Integer.MIN_VALUE;
    int count;
    int[] result;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        length = dungeons.length;
        result = new int[length];
        visited = new boolean[length];

        bruteForce(0, k, dungeons);

        return answer;
    }

    private void bruteForce(int digit, int k, int[][] dungeons) {
        if (digit >= length) {
            int currentK = k;
            count = 0;

            for (int i = 0; i < length; i++) {
                int index = result[i];

                if (currentK >= dungeons[index][0]) {
                    currentK -= dungeons[index][1];
                    count++;
                } else {
                    break;
                }
            }

            if (count > answer) {
                answer = count;
            }

            return;
        }

        for (int index = 0; index < length; index++) {
            if (visited[index]) {
                continue;
            }

            result[digit] = index;

            visited[index] = true;
            bruteForce(digit + 1, k, dungeons);
            visited[index] = false;
        }
    }

    public static void main(String[] args) {
        Solution5 prob = new Solution5();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        System.out.println(prob.solution(k, dungeons));
    }

}