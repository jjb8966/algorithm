package simulation_implementation.과일_가져가기;

class Answer {

    // 최소값을 구하는 메서드
    public int findMin(int[] fruitCounts) {
        int minCount = Integer.MAX_VALUE;
        for (int count : fruitCounts) {
            minCount = Math.min(minCount, count);
        }
        return minCount;
    }

    // 최소값이 유일한지 확인하는 메서드
    public boolean isUniqueMin(int[] fruitCounts) {
        int min = findMin(fruitCounts);
        int minCount = 0;
        for (int count : fruitCounts) {
            if (count == min) {
                minCount++;
            }
        }
        return minCount == 1;
    }

    // 최소값의 인덱스를 구하는 메서드
    public int findMinIndex(int[] fruitCounts) {
        int min = findMin(fruitCounts);
        for (int i = 0; i < fruitCounts.length; i++) {
            if (fruitCounts[i] == min) {
                return i;
            }
        }
        return -1; // 이 부분은 사실 들어갈 일이 없으나, 안정성 고려
    }

    // 두 과일을 비교하여 가능한 교환을 시도하는 메서드
    private boolean canSwapFruits(int[] fruitA, int[] fruitB) {
        int minIndexA = findMinIndex(fruitA);
        int minIndexB = findMinIndex(fruitB);

        return minIndexA != minIndexB && fruitA[minIndexB] > 0 && fruitB[minIndexA] > 0
                && fruitA[minIndexA] + 1 <= fruitA[minIndexB] - 1
                && fruitB[minIndexB] + 1 <= fruitB[minIndexA] - 1;
    }

    // 과일 배열을 바탕으로 교환을 진행하고 최종 결과를 계산하는 메서드
    public int solution(int[][] fruitArray) {
        int totalMinValue = 0;
        int n = fruitArray.length;
        boolean[] isProcessed = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (isProcessed[i] || !isUniqueMin(fruitArray[i])) continue;
            for (int j = i + 1; j < n; j++) {
                if (isProcessed[j] || !isUniqueMin(fruitArray[j])) continue;
                if (canSwapFruits(fruitArray[i], fruitArray[j])) {
                    int minIndexA = findMinIndex(fruitArray[i]);
                    int minIndexB = findMinIndex(fruitArray[j]);

                    fruitArray[i][minIndexA]++;
                    fruitArray[i][minIndexB]--;
                    fruitArray[j][minIndexB]++;
                    fruitArray[j][minIndexA]--;

                    isProcessed[i] = true;
                    isProcessed[j] = true;
                    break;
                }
            }
        }

        // 각 과일 배열의 최소값을 합산하여 반환
        for (int[] fruitCounts : fruitArray) {
            totalMinValue += findMin(fruitCounts);
        }
        return totalMinValue;
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        System.out.println(answer.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(answer.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(answer.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(answer.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
