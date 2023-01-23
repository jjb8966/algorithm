package greedy;

public class Solution1 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n + 1];

        for (int i : lost) {
            students[i]--;
        }

        for (int i : reserve) {
            students[i]++;
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] >= 0) {
                answer++;
                continue;
            }

            if (students[i] == -1) {
                if (i != 1 && students[i - 1] == 1) {
                    answer++;
                    students[i - 1]--;

                    continue;
                }

                if (i != n && students[i + 1] == 1) {
                    answer++;
                    students[i + 1]--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution1 prob = new Solution1();

        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};

        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};

        int n4 = 5;
        int[] lost4 = {1, 2, 3, 4, 5};
        int[] reserve4 = {1};

        System.out.println(prob.solution(n, lost, reserve));
        System.out.println(prob.solution(n2, lost2, reserve2));
        System.out.println(prob.solution(n3, lost3, reserve3));
        System.out.println(prob.solution(n4, lost4, reserve4));
    }

}