package greedy;

class Solution2 {

    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int leftOrRight = name.length() - 1;

        for (int i = 0; i < n; i++) {
            int next = i + 1;
            char target = name.charAt(i);

            if (target <= 'N') {
                answer += target - 'A';
            } else {
                answer += 'Z' - target + 1;
            }

            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            leftOrRight = Math.min(leftOrRight, i + n - next + Math.min(i, n - next));
        }

        answer += leftOrRight;

        return answer;
    }

    public static void main(String[] args) {
        Solution2 prob = new Solution2();

        String name = "JAN";
        String name2 = "JEROEN";
        String name3 = "CCCAAAAAAY";

        System.out.println(prob.solution(name));
        System.out.println(prob.solution(name2));
        System.out.println(prob.solution(name3));
    }
}
