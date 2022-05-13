## 1. 선택 정렬

- 동작 과정
    1. 가장 작은 데이터를 맨 앞에 있는 데이터와 바꿈
    2. 1번 반복
- 시간 복잡도 : O(N^2)
    - 비효율적인 정렬 방식

### 코드

```java
    private static void process() {
        for (int changeIndex = 0; changeIndex < values.length; changeIndex++) {
            int minimumNumberIndex = changeIndex;

            // changeIndex 다음부터 끝까지 수 중 가장 작은 수 찾기
            for (int findMinimum = changeIndex + 1; findMinimum < values.length; findMinimum++) {
                if (values[minimumNumberIndex] > values[findMinimum]) {
                    minimumNumberIndex = findMinimum;
                }
            }

            // values[changeIndex] <-> values[minimumNumberIndex]
            int temp = values[changeIndex];
            values[changeIndex] = values[minimumNumberIndex];
            values[minimumNumberIndex] = temp;
        }

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
    }
```

## 2. 삽입 정렬

- 동작 과정
    1. 리스트 내에서 (왼쪽에) 정렬된 데이터가 있음
    2. 리스트의 (오른쪽에) 정렬되지 않은 데이터 중 특정 데이터 하나를 지정
    3. 특정 데이터를 왼쪽에 정렬된 리스트에 적절한 위치에 삽입
    4. 1~3번 반복
- 시간 복잡도 : O(N^2)
    - 리스트가 거의 정렬된 상태라면 매우 빠르게 동작함

### 코드

```java
    private static void process() {
        // 가장 첫번째 인덱스는 정렬되어있다고 생각하고 두번째 인덱스부터 정렬 시작
        for (int i = 1; i < values.length; i++) {
            for (int j = i; j > 0; j--) {
                if (values[j] < values[j - 1]) {
                    int temp = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = temp;
                } else {
                    break;      // 정렬하려는 숫자보다 작은 숫자를 만나게되면 그 왼쪽은 더 이상 볼 필요가 없으므로 break
                }
            }
        }

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
    }
```

## 3. 퀵 정렬

- 가장 많이 사용되는 정렬 알고리즘
- 동작 과정
    1. 리스트의 첫 번째 데이터를 기준 숫자(pivot)로 정함 → 호어 분할 (Hoare Partition)
    2. 왼쪽에서부터 pivot보다 큰 수를 찾아서 선택 (a)
    3. 오른쪽에서부터 pivot보다 작은 수를 찾아서 선택 (b)
        
        4-1.  a가 b보다 왼쪽에 있는 경우
        
        ![IMG_FF426202C5FC-1.jpeg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/119a1981-f675-4c1b-b867-212f6cdd8c28/IMG_FF426202C5FC-1.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220509%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220509T012951Z&X-Amz-Expires=86400&X-Amz-Signature=c07b6e03b35287d01d6d572c4d99dbdbbae625e1b7e7a382b574447b82828aff&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22IMG_FF426202C5FC-1.jpeg%22&x-id=GetObject)
        
        - a와 b 교환
        
        4-2.  a가 b보다 오른쪽에 있는 경우
        
        ![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4fa5d0e8-bd3c-4b92-ba81-b53eab1d56c9/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220509%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220509T013010Z&X-Amz-Expires=86400&X-Amz-Signature=3df22b5aa480e1280b492bb9477f1706ed4ebfe236a306fbbb0c9cca9671e79a&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)
        
        - pivot과 b 교환
            
            ![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/fb58d711-7709-4949-82a5-0cd1361201bf/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220509%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220509T013025Z&X-Amz-Expires=86400&X-Amz-Signature=4937d7618af8dc25af4e7fcfbb04822732fb786cafa944c2aa7a3f20b4934b6b&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)
            
- 시간 복잡도 : O(NlogN) → 선택 정렬, 삽입 정렬보다 빠름
    - 삽입 정렬과 반대로 이미 어느 정도 정렬된 상태면 속도가 느림

### 코드

```java
    private static void quickSort(int start, int end) {
        int pivot = start;
        int left = start + 1;
        int right = end;

        // 원소가 1개인 경우 종료
        if (start >= end) {
            return;
        }

        while (left <= right) {
            // 왼쪽에서부터 피벗보다 큰 숫자 찾기
            while (left <= end && values[left] <= values[pivot]) {
                left++;
            }

            // 오른쪽에서부터 피벗보다 작은 숫자 찾기
            while (right > start && values[right] >= values[pivot]) {
                right--;
            }

            // left, right 가 엇갈리지 않았다면 둘을 교체
            if (left <= right) {
                int temp = values[left];
                values[left] = values[right];
                values[right] = temp;
            } else {        // left, right 가 엇갈렸다면 pivot 과 values[right] (작은 수)를 교체
                int temp = values[pivot];
                values[pivot] = values[right];
                values[right] = temp;
            }
        }

        // pivot 기준으로 왼쪽, 오른쪽 리스트에 대해 다시 퀵 정렬
        quickSort(start, right - 1);
        quickSort(right + 1, end);
    }
    
    private static void process() {
        quickSort(0, values.length - 1);

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
    }
```

## 4. 계수 정렬

- 특정 조건을 만족해야만 사용할 수 있지만 사용할 수 있다면 매우 빠르게 동작함
    - 조건
        1. 정수만 가능
        2. min과 max의 차이가 1,000,000 이하일 경우
- 동작 과정
    1. (최대값 + 1)에 해당하는 배열을 만듦 
        
        ex) 1, 1, 3, 5, 7 → new int[8]
        
    2. 리스트 내 해당 숫자를 인덱스로 하는 배열의 값을 증가시켜 숫자의 갯수를 셈
    3. 작은 수부터 갯수만큼 배열의 인덱스 출력
- 시간 복잡도 : O(N+K)
    - N : 데이터의 개수
    - K : 데이터 중 최대값

### 코드

```java
    private static void process() {
        int maxValue = Arrays.stream(values).max().getAsInt();
        int[] countCoefficient = new int[maxValue + 1];

        for (int number : values) {
            countCoefficient[number]++;
        }

        for (int i = 0; i <= maxValue; i++) {
            for (int j = 0; j < countCoefficient[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
```

## 5. Comparable 사용

- 조건
    1. 정렬 조건이 필요함
    2. 시간 복잡도는 약 O(N log N)
        1. primitive 원소
            - Dual-Pivot Quick Sort
            - 최악의 경우 O(N^2) → 운이 나쁘면 시간초과 날 수도 있음
            - In-place
                - 정렬하는 과정에서 무시할만큼의 적은 메모리를 사용함
        2. object 원소
            - Tim Sort
            - 최악의 경우도 O(N log N)
            - Stable
                - 동등한 위상을 갖는 원소가 정렬 후에도 순서가 보존됨
                    
                    ex) A(1) A(2) D C B... → A(1) A(2) B C D ...
                    
- 특성
    - 비슷한 값의 정보들을 서로 인접해 있음
        
        → 정렬만 해도 문제가 쉽게 풀리는 경우가 많음
        

### 코드

1. `Comparable 인터페이스를 구현`한 클래스(Element) 정의
2. `compareTo 메소드 오버라이딩`
    1. 오름차순 : this - 매개변수
    2. 내림차순 : 매개변수 - this
3. Element 타입의 `배열에 값을 입력`받음
4. `Arrays.sort(배열)`

```java
    static class Element implements Comparable<Element> {
        int score;

        @Override
        public int compareTo(Element other) {       //정렬의 기준이 되는 메소드
              return this.score - other.score;
        }
    }

    public static void process() {
        Arrays.sort(Students);      //오버라이딩 한 compareTo 메소드를 기준으로 정의
    }
```

[[Java] Arrays.sort()와 Collections.sort()에 대해서 자세히 알아보자!](https://www.notion.so/Java-Arrays-sort-Collections-sort-af093f5a843f4cb7bf64ab6dc997e143)

## 문제

[10825번: 국영수](https://www.notion.so/10825-adfb5e945c1e4a8ba8ba15d6a5a79710)

[1015번: 수열 정렬](https://www.notion.so/1015-e25052421c34494dab3ad226f7e13204)

[11652번: 카드](https://www.notion.so/11652-724d33b989f04f9a9db5a392b1210ad3)

[15970번: 화살표 그리기](https://www.notion.so/15970-006405a7025e4fdcae0fb09bb38f979b)
