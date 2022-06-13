# 위상 정렬 (Topological Sort)

# 1. 위상 정렬

## DAG (Directed Acyclic Graph)

![Untitled](https://user-images.githubusercontent.com/87421893/173366758-3a8bf0c4-95e5-454d-8544-e194fcd2f6e3.png)


- Directed
    - 간선의 방향이 존재함
- Acyclic
    - cycle이 없음
- Graph
    - 정점(Vertex) + 간선(Edge)
- inDegree & outDegree
    - 들어오는 선의 갯수 & 나가는 선의 갯수

## 위상 정렬

> DAG를 위상에 맞춰 정렬하는 것
>
- 위상에 맞춰 정렬한다는 의미
    - 올 수 있는 순서에 맞춰 정렬한다는 의미

      ex) 1 → 6 (O), 6 → 4 (X)

- 아이디어
    - 가장 먼저 올 수 있는 정점은?
        - inDegree == 0 인 정점

      ⇒ 가장 먼저 올 수 있는 정점을 결과에 추가 & 그래프에서 삭제


## 동작 과정

1. 정점들의 inDegree 계산
2. inDegree가 0인 정점들을 자료구조 D(heap)에 저장
3. D가 빌 때까지
    1. D에서 원소 x 하나 꺼내서 결과에 추가
    2. 그래프에서 원소 x 제거
    3. inDegree가 0이 된 원소를 D에 저장

# 2. 핵심 코드

```java
private static void topologicalSort() {
    Queue<Integer> inDegreeZeroVertex = new LinkedList<>();

    // 1. inDegree 0인 정점을 모두 큐에 넣음
    for (int i = 1; i <= numberOfStudent; i++) {
        if (inDegree[i] == 0) {
            inDegreeZeroVertex.add(i);
        }
    }

    // 2. 큐가 빌 때까지
    while (!inDegreeZeroVertex.isEmpty()) {
        int vertex = inDegreeZeroVertex.poll();

        // 3. 큐에서 꺼낸 원소 결과에 추가
        sb.append(vertex).append(' ');

        // 4. 원소를 그래프에서 제거 -> 인접한 정점의 inDegree--
        for (Integer taller : adjacencyList[vertex]) {
            inDegree[taller]--;

            // 5. inDegree 0인 원소를 큐에 넣음
            // 여기서 queue에 들어갈 정점을 체크하는게 시간을 줄이는 핵심 방법
            // + 어차피 모든 정점이 큐에 한번씩만 들어가므로 visit 체크를 할 필요도 없음
            if (inDegree[taller] == 0) {
                inDegreeZeroVertex.add(taller);
            }
        }
    }
}
```

# 3. 문제

[2252번: 줄 세우기](%E1%84%8B%E1%85%B1%E1%84%89%E1%85%A1%E1%86%BC%20%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%A7%E1%86%AF%20(Topological%20Sort)%2052682d9d790e4db88668dc69304d1b82/2252%E1%84%87%E1%85%A5%E1%86%AB%20%E1%84%8C%E1%85%AE%E1%86%AF%20%E1%84%89%E1%85%A6%E1%84%8B%E1%85%AE%E1%84%80%E1%85%B5%20e04424cc10ed495098373972336759a1.md)
