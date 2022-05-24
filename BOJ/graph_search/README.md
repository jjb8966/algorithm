# 그래프 탐색 (Graph Search)

## 1. 그래프

- 정점(vertex) + 간선(edge)
- 간선
    - 무방향 or 방향
    - 가중치 유무

![Untitled 0](https://user-images.githubusercontent.com/87421893/170044564-0b769c3b-9386-4ce0-9c25-d9560b6aefa5.png)


- 차수
    - deg(x)
        - x의 차수
        - x와 연결된 간선의 수
- `모든 정점의 차수의 합`
    - `간선의 개수 x 2`

      → 그려보면 앎

- 그래프를 저장하는 방법
    1. 인접 행렬
    2. 인접 리스트

### 인접 행렬 (Adjacency Matrix)

- 2차원 배열을 사용해 저장

    ```sql
    int[][] adjacencyMatrix = int new[vertex][vertex];
    ```

![Untitled 1](https://user-images.githubusercontent.com/87421893/170044602-1b1e1732-8f5b-4b59-b5be-a9eb3a1d6195.png)

- 공간 복잡도 : O(V^2)
    - 메모리를 너무 많이 차지함
        - 정점이 많아지면 사용 못함

          ex) V = 10만 → V^2 = 100억

- 시간 복잡도
    - A ↔ B 이동 가능? (무방향)
        - O(1)

          → adj[A][B]만 확인하면 됨

    - 정점 A에서 갈 수 있는 정점은?
        - O(V)

          → 모든 정점 확인해봐야함


### 인접 리스트 (Adjacency List)

- 2차원 ArrayList를 사용해 저장

    ```sql
    ArrayList<ArrayList<Integer>> adjacencyList;
    
    or
    
    ArrayList<Integer>[] adjacencyList; // 이게 쓰기 더 편한듯
    ```

![Untitled 2](https://user-images.githubusercontent.com/87421893/170044648-eb3f8e4e-9015-417f-9ba4-0ce082820437.png)


- 공간 복잡도 : O(E)
    - `모든 정점의 차수합`만큼 필요
        - 간선(E) x 2

          = O(2E) = O(E)

- 시간 복잡도
    - A ↔ B 이동 가능?
        - O(min(deg(A),deg(B)))

          → A,B 둘 중 차수 낮은 것에 따라 결정

    - 정점 A에서 갈 수 있는 정점은?
        - O(deg(A))

          → A와 연결된 정점만큼 조회

- 인접 행렬 vs 인접 리스트
    - A,B가 연결되어있는지 아닌지 여부만 궁금 → 인접 행렬 사용
    - 그것 아니면 인접 리스트 사용

      → `인접 리스트`를 더 많이 씀


![Untitled 3](https://user-images.githubusercontent.com/87421893/170044698-5948c68e-80ce-4527-9a65-ff733f34484a.png)


### 탐색 (Search)

> 시작점에서 간선을 0개 이상 사용하여 갈 수 있는 모든 정점들을 찾는 것
>
- 정점, 간선, 시작점 주어짐
- `visit 배열`, `인접 행렬 or 인접 리스트 변수` 필요
- dfs, bfs 둘 다 `한번 메소드가 실행`되면 **방문할 수 있는 정점을 모두 탐색함**
    - 탐색 작업을 몇번할 지 잘 생각하면서 문제 풀 것
    - dfs 내부 재귀는 별개로 생각

## 2. DFS - 깊이 우선 탐색(Depth First Search)

- `재귀 함수` 사용

### 핵심 코드

```java
    "start 를 갈 수 있다는 걸 알고 방문한 상태"
    void dfs(int start) {
        "visit check"
        visit[start] = true;

        "정답 갱신"
        sb.append(start).append(' ');

        "갈 수 있는 모든 정점"
        for (int i : adjacencyList[start]) {

            "처리하지 않을 정점을 조건문으로 걸러냄"
            if (visit[i]) {
                continue;
            }

            "조건을 모두 통과한 정점에 대해 dfs"
            dfs(i);    // 재귀 -> 더 깊게 들어감
        }
    }
```

1. `visit 체크`
2. start가 `갈 수 있는 모든 정점`에 대해 `dfs(재귀)`
    - 이 때 **처리하지 않을 정점**을 조건문으로 **잘 걸러야 함**

## 3. BFS - 너비 우선 탐색(Breadth First Search)

- `Queue` 사용

### 핵심 코드

```java
     // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기    
    void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        "큐에 시작점 넣고 visit check"
        queue.add(start);
1번      visit[start] = true;  // start 를 갈 수 있다고 표시하기 (중요!!!)

        "큐에 더 이상 값이 없을 때까지, 즉 갈 수 있는 정점이 없을 때까지 탐색"
        while (!queue.isEmpty()) {
            int number = queue.poll();

            "큐에서 꺼낼 때 정답 갱신"
            sb.append(number).append(' ');

						// visit[number] = true;
            // visit 체크를 1,2번에서 하지 않고 여기서 하면 특수한 경우에 문제가 발생할 수 있음
						// 반드시 큐에 넣을 때 visit 체크를 해야 함

            "큐에 넣을 수 있는 모든 정점"
            for (int i : adjacencyList[number]) {

                "처리하지 않을 정점을 조건문으로 걸러냄"
                if (visit[i]) {
                    continue;  // number 에서 i 를 갈 수는 있지만, 이미 탐색한 점이면 무시
                }
                
                "조건을 통과한 정점을 큐에 넣고 visit check"
                // y를 갈 수 있으니까 queue 에 추가하고, visit 처리 하기!
                queue.add(i);
 2번             visit[i] = true;
            }
        }
    }
```

1. `시작점(start)`를 `큐에 넣고 visit check`
2. `while(!queue.isEmpty)`
    - 큐가 빌 때까지, 즉 갈 수 있는 정점이 더 없을 때 까지 탐색 진행
    1. while문 안에서 `큐에 있는 정점 하나 꺼냄`
    2.  `해당 정점이 갈 수 있는 모든 정점` 체크해서 `큐에 넣고 visit check`
        - 이 때 **처리하지 않을 정점**을 조건문으로 **잘 걸러야 함**
- `visit 체크를 하는 시점`
    - `큐에 넣을 때` visit 체크를 해야함
        - 큐에 값을 추가하는 것과 visit check는 한 세트라고 생각!
    - 큐에서 뺄 때 visit 체크를 하면 특수한 경우 에러가 날 수 있음

## 문제

[1260번: DFS와 BFS](https://www.notion.so/1260-DFS-BFS-89bf068a416042709d759895b6c99990)

[2667번: 단지번호붙이기](https://www.notion.so/2667-a7655b572e4d4a17a3c121002bf6cd40)

[2251번: 물통](https://www.notion.so/2251-6e2d8aeff503459f9d90c87f8a746c8b)
