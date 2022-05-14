# 완전 탐색
## 1. 완전 탐색

- 확인해야 하는 `모든 경우를 전부 탐색`
- 함수 정의가 중요함
- `백트래킹`을 사용해야 하는 경우도 있음
    - 백트래킹 : 답을 찾는 도중 그 경로가 닶이 될 수 없는 경우 뒤로 되돌아 가는 방식
- 경우의 수 4가지
    
    ![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e140ce22-797a-4752-b4b4-006013e209c2/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220504%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220504T041948Z&X-Amz-Expires=86400&X-Amz-Signature=b17b505818aea5e9ee770b8da65e73e9d5aa8097b261d552713fc5a16bf43291&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)
    
    ![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d7b25f16-2c4e-405e-99d4-288d2ffd6a33/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220504%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220504T042004Z&X-Amz-Expires=86400&X-Amz-Signature=ef437e8372a9ff64db6b240d620c4f9ea70393e84ef8f6a2cf517e4fbd4e855d&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)
    

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
