# 이분 탐색(Binary Search)

# 1. 이분 탐색

> 데이터의 `탐색 범위를 절반씩 좁혀가며` 데이터를 탐색하는 방법
>
- 배열 내부의 데이터가 `정렬`된 상태여야 함
- `변수` 3개 사용
    - start
    - mid
    - end
- `동작 과정`
    1. 배열의 시작 인덱스를 start, 마지막 인덱스를 end로 설정
    2. **mid = (start + end) / 2**로 설정
        - 실수인 경우 내림
        - ex) 4.5 → 4
    3. arr[mid]와 찾으려는 숫자(target)을 비교
        1. **arr[mid] > target**
            - mid 이후의 숫자는 안봐도 target보다 클 것이므로 mid의 왼쪽만 보면 됨
        2. **arr[mid] > target**
            - mid 이전의 숫자는 안봐도 target보다 작을 것이므로 mid의 오른쪽만 보면 됨
        3. **arr[mid] == target**
            - 찾고자하는 숫자를 찾음 → 결과로 mid 반환
- `시간 복잡도`
    - **O(logN)**

  → 한번 탐색할 때마다 탐색 범위가 절반으로 줄어듦

- 자주 하는 실수
    1. 정렬을 하지 않은 경우
    2. 부등호 실수
    3. start, end 범위 잘못 지정

# 2. 핵심 코드

1. `재귀 함수` 이용

    ```java
    public static void binarySearch(int start, int end) {
            int mid = (start + end) / 2;
    
            // 찾는 원소가 없는 경우
            if (start > end) {
                System.out.println("원소가 존재하지 않습니다.");
                return;
            }
    
            // 찾은 경우 결과 출력
            if (arr[mid] == target) {
                result = mid + 1;
                System.out.println(result);
            }
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            if (arr[mid] > target) {
                binarySearch(start, mid - 1);
            }
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            if (arr[mid] < target) {
                binarySearch(mid + 1, end);
            }
        }
    ```

2. `반복문` 이용

    ```java
    public static void binarySearch(int start, int end) {
            while (start <= end) {
                int mid = (start + end) / 2;
    
                // 찾은 경우 중간점 인덱스 반환
                if (arr[mid] == target) {
                    result = mid + 1;
                    System.out.println(result);
                    return;
                }
                // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
                else if (arr[mid] > target) {
                    end = mid - 1;
                }
                // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
                else {
                    start = mid + 1;
                }
            }
    
            System.out.println("원소가 존재하지 않습니다.");
        }
    ```


# 3. 매개 변수 탐색(Parametric Search)

> 문제를 뒤집어서 매개변수를 도입해 정답을 구하는 방식
>
- 매개변수를 대입했을 때 정답이 되면 Yes, 안되면 No
- 대입 가능한 모든 값에 대해 Yes/No 판단이 가능하고 그 결과가 정렬되어 있어야 함
    - yes yes yes …. `yes | no` no no … no
    - yes, no의 경계값이 정답
- ex
    - up/down : 1 ~ 1000 사이 임의의 숫자 맞추기(700)
        - 완전 탐색
            - 1보다 큰가? yes
            - 2보다 큰가? yes
            - ….
            - 699보다 큰가? yes
            - 700보다 큰가? `no`

              ⇒ 정답 : 700

        - 이분 탐색
            - 500보다 큰가? yes
            - 750보다 큰가? no
            - …

# 4. 문제

[7795번: 먹을 것인가 먹힐 것인가](%E1%84%8B%E1%85%B5%E1%84%87%E1%85%AE%E1%86%AB%20%E1%84%90%E1%85%A1%E1%86%B7%E1%84%89%E1%85%A2%E1%86%A8(Binary%20Search)%2007963911534644829c72299f00e1c355/7795%E1%84%87%E1%85%A5%E1%86%AB%20%E1%84%86%E1%85%A5%E1%86%A8%E1%84%8B%E1%85%B3%E1%86%AF%20%E1%84%80%E1%85%A5%E1%86%BA%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%80%E1%85%A1%20%E1%84%86%E1%85%A5%E1%86%A8%E1%84%92%E1%85%B5%E1%86%AF%20%E1%84%80%E1%85%A5%E1%86%BA%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%80%E1%85%A1%20a78ad3d620ef4c88a962ba6e12dd324a.md)

[2470번: 두 용액](%E1%84%8B%E1%85%B5%E1%84%87%E1%85%AE%E1%86%AB%20%E1%84%90%E1%85%A1%E1%86%B7%E1%84%89%E1%85%A2%E1%86%A8(Binary%20Search)%2007963911534644829c72299f00e1c355/2470%E1%84%87%E1%85%A5%E1%86%AB%20%E1%84%83%E1%85%AE%20%E1%84%8B%E1%85%AD%E1%86%BC%E1%84%8B%E1%85%A2%E1%86%A8%20b11a59979d36423990e79266a448e73f.md)

[2805번: 나무 자르기](%E1%84%8B%E1%85%B5%E1%84%87%E1%85%AE%E1%86%AB%20%E1%84%90%E1%85%A1%E1%86%B7%E1%84%89%E1%85%A2%E1%86%A8(Binary%20Search)%2007963911534644829c72299f00e1c355/2805%E1%84%87%E1%85%A5%E1%86%AB%20%E1%84%82%E1%85%A1%E1%84%86%E1%85%AE%20%E1%84%8C%E1%85%A1%E1%84%85%E1%85%B3%E1%84%80%E1%85%B5%2036343d5e41d940f093fd564a68ebd5ad.md)