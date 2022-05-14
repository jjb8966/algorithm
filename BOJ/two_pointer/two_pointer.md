## 1. 투 포인터

- 정답을 찾기 위해 `꼭 봐야하는 부분만 본다.`
- 키워드
    - `“연속 부분 수열”`
    - “`순서`를 차례대로 지키면서”
    - “`곱의 최소`”
        - A x B
        - A가 커지면 B가 작아짐

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/eb2ca532-737b-450c-b87d-416bb3284cac/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220513%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220513T131346Z&X-Amz-Expires=86400&X-Amz-Signature=26327d2eed8dd479e6cc8adb069e6719c1708d3c2de54c590bdba8e78d34c5e1&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

- `포인터 2개에 의미를 부여`해서 탐색 범위를 좁혀야 함
    - `변수를 포인터로` 사용함
    - 1차원 배열에서 2개의 포인터를 만들 경우
        1. `2개의 포인터 모두 왼쪽에서 시작`해 같은 방향으로 이동
        2. `각 포인터`가 탐색 범위의 `양 끝에서 시작`해 서로를 향해 이동

## 2. 핵심 코드

- 2개의 포인터 모두 왼쪽 시작
    1. `right`를 이동할 수 있을 때까지 `최대로 이동`
    2. left를 하나씩 옮기면서 right를 옮길지 말지 결정
    
    ```java
        public static void twoPointer() {
            int right = 0;
    
            for (int left = 0; left < lastIndex; left++) {
                // right를 옮길 수 있을 때 까지 옮기기
                while (right < lastIndex && "right가 멈출 조건식") {
    								"조건값 변화"
                    right++;
                }            
    
                "정답 갱신" -> for문으로 left 이동
    
                "left에 해당하는 값을 뺌"
            }
        }
    ```
    
- 2개의 포인터가 양쪽 끝에서 시작
  - 정렬 & 이분탐색 활용
    1. `left, right 변수 선언 및 초기화`
    2. `while(left < right)` 조건문
    3. 정답 갱신 후 어떤 포인터를 옮길지 판단
    
    ```java
        public static void twoPointer() {
            int left = 0;
            int right = lastIndex;
    
            while (left < right) {
                "정답 갱신"
    
                if ("어떤 포인터를 옮길지 결정하는 조건식") {
                    right--;
                } else {
                    left++;
                }
            }
        }
    ```
    

## 문제

[1806번: 부분합](https://www.notion.so/1806-020ca674fac54ad68662e010de6895c8)
