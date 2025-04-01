package hash.한_번만_사용한_최초문자;

import java.util.HashMap;

public class Answer {

    /**
     * 문자열에서 첫 번째로 한 번만 등장하는 문자의 위치(1-based index)를 찾는 메서드
     * @param s : 검사할 입력 문자열 (소문자 알파벳으로 가정)
     * @return int : 첫 번째 고유문자의 위치 (없을 경우 -1 반환)
     */
    public int solution(String s) {
        // 각 문자의 등장 횟수를 추적하기 위한 해시맵 생성
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        // 전체 문자열 순회하며 빈도수 카운트
        for (char currentChar : s.toCharArray()) {
            charFrequencyMap.put(currentChar, charFrequencyMap.getOrDefault(currentChar, 0) + 1);
        }

        // 문자열을 다시 순회하며 첫 번째 고유 문자 탐색
        for (int index = 0; index < s.length(); index++) {
            if (charFrequencyMap.get(s.charAt(index)) == 1) {
                // 1-based 인덱스 반환 (사용자 요청사항 반영)
                return index + 1;
            }
        }

        // 고유 문자가 없는 경우 기본값 반환
        return -1;
    }

    // 테스트 케이스 실행 메서드 (원본 코드 유지)
    public static void main(String[] args) {
        Answer solutionInstance = new Answer();
        System.out.println(solutionInstance.solution("statitsics"));  // 예상 결과: 3 ("a")
        System.out.println(solutionInstance.solution("aabb"));         // 예상 결과: -1
        System.out.println(solutionInstance.solution("stringshowtime"));  // 예상 결과: 3 ("r")
        System.out.println(solutionInstance.solution("abcdeabcdfg")); // 예상 결과: 5 ("e")
    }
}