package sort;

import java.util.*;

public class Solution3 {
    int result;

    public int solution(int[] citations) {
        Arrays.sort(citations);
        binarySearch(citations);

        return result;
    }

    private void binarySearch(int[] citations) {
        int min = 0;
        int max = 10000;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (available(mid, citations)) {
                min = mid + 1;
                result = mid;
            } else {
                max = mid - 1;
            }
        }
    }

    private boolean available(int h, int[] citations) {
        int count = 0;

        for (int citation : citations) {
            if (citation >= h) {
                count++;
            }
        }

        return count >= h;
    }

    public static void main(String[] args) {
        Solution3 prob = new Solution3();
        int[] citations = {3, 0, 6, 1, 5};
        int[] citations2 = {3, 0, 6, 1, 5, 8, 10};
        int[] citations3 = {0,0,0,2};

        System.out.println(prob.solution(citations));
        System.out.println(prob.solution(citations2));
        System.out.println(prob.solution(citations3));
    }

}