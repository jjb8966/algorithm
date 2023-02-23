# 완전 탐색
## 1. 완전 탐색

- 확인해야 하는 `모든 경우를 전부 탐색`
- 함수 정의가 중요함
- `백트래킹`을 사용해야 하는 경우도 있음
    - 백트래킹 : 답을 찾는 도중 그 경로가 닶이 될 수 없는 경우 뒤로 되돌아 가는 방식
- 경우의 수 4가지
    
![Untitled 0](https://user-images.githubusercontent.com/87421893/170045683-44458fd9-3c71-4831-a7b8-6e814e069c0b.png)

    
![Untitled 1](https://user-images.githubusercontent.com/87421893/170045733-1cabce08-88c3-4761-9dba-0ae2b23e45a0.png)

    

## 2. 핵심 코드 - 재귀 함수

```java
public static void main(String[] args) {
        input(); //입력받는 함수
        recurrenceFunction(1);      //1번째 자리부터 올바른 원소를 고르는 함수
        System.out.println(sb);
    }

    //k번째 자리부터 조건에 맞는 원소를 고르는 재귀 함수
    private static void recurrenceFunction(int k) {
        if (k == M + 1) {       //탐색 끝
        //결과 출력
        } else {                //k번째 자리에 값을 대입 후 recurrenceFunction(k + 1)
                recurrenceFunction(k + 1);
            }
        }
    }
```

## 문제

[case 1 : 중복 O, 나열 O (순서 O)](https://www.notion.so/case-1-O-O-O-f15877ac05b34b63984b2f43b36046ce)

[case 2 : 중복 X, 나열 O (순서 O) → N P M ](https://www.notion.so/case-2-X-O-O-N-P-M-5888a59cb4034b8ba241baf8554b9450)

[case 3 : 중복 O, 나열 X (순서 X)](https://www.notion.so/case-3-O-X-X-e88bcfdbaba745b28914bb4900e8140d)

[case 4 : 중복 X, 나열 X (순서 X) → N C M](https://www.notion.so/case-4-X-X-X-N-C-M-017552b12f3f456383acd376c72d6860)

[14888번: 연산자 끼워넣기](https://www.notion.so/14888-61f2c62ea01741f7b1e0654f5d47624f)

[9663번: N-Queen](https://www.notion.so/9663-N-Queen-e71bddce9bf74ad79b2ada29da4ffb50)

[1182번: 부분수열의 합](https://www.notion.so/1182-1149999929144cc89f433c54b1c6ed54)
