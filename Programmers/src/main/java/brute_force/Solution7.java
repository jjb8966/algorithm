package brute_force;

public class Solution7 {

    int count = 0;
    boolean end;
    char[] alphabet;
    char[] result;

    public int solution(String word) {
        alphabet = new char[]{'A', 'E', 'I', 'O', 'U'};
        result = new char[5];

        bruteForce(0, word);

        return count;
    }

    private void bruteForce(int digit, String word) {
        if (digit == 5) {
            return;
        }

        for (int index = 0; index < alphabet.length; index++) {
            if (end) {
                return;
            }

            String temp = "";
            result[digit] = alphabet[index];
            count++;

            for (int i = 0; i < 5; i++) {
                temp += result[i];
            }

            if (temp.trim().equals(word)) {
                end = true;
            }

            bruteForce(digit + 1, word);

            result[digit] = ' ';
        }
    }

    public static void main(String[] args) {
        Solution7 prob = new Solution7();
        String word = "AAAAE";
        String word2 = "I";
        String word3 = "EIO";

        System.out.println(prob.solution(word2));
    }

}