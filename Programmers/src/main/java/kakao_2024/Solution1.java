package kakao_2024;

import java.util.*;

public class Solution1 {

    public int solution(String[] friends, String[] gifts) {
        int numberOfFriends = friends.length;
        int[][] friendMatrix = new int[numberOfFriends][numberOfFriends];
        int[] giftDegree = new int[numberOfFriends];
        int[] giftResult = new int[numberOfFriends];
        Map<String, Integer> friendIndexMap = new HashMap<>();

        for (int index = 0; index < numberOfFriends; index++) {
            friendIndexMap.put(friends[index], index);
        }

        for (String gift : gifts) {
            String[] exp = gift.split(" ");
            int from = friendIndexMap.get(exp[0]);
            int to = friendIndexMap.get(exp[1]);

            friendMatrix[from][to]++;
            giftDegree[from]++;
            giftDegree[to]--;
        }

        for (int me = 0; me < numberOfFriends; me++) {
            for (int other = 0; other < numberOfFriends; other++) {
                if (me == other) {
                    continue;
                }

                if (friendMatrix[me][other] > friendMatrix[other][me]) {
                    giftResult[me]++;
                }

                if (friendMatrix[me][other] == friendMatrix[other][me]
                        || (friendMatrix[me][other] == 0 && friendMatrix[other][me] == 0)) {
                    if (giftDegree[me] > giftDegree[other]) {
                        giftResult[me]++;
                    }
                }
            }
        }

        int maxGift = Integer.MIN_VALUE;

        for (int index = 0; index < numberOfFriends; index++) {
            if (giftResult[index] > maxGift) {
                maxGift = giftResult[index];
            }
        }

        return maxGift;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        System.out.println(solution.solution(friends, gifts));
    }
}