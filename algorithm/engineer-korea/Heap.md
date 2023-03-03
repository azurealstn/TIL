# Heap

Heap이란 최대값이나 최소값을 구하는데 빠르게 찾아내기 위해 고안된 완전 이진 트리(Complete Binary Tree)를 기반으로 한 자료구조이다. 따라서 Binary Heap(이진 힙)이라고도 한다.

## Min-Heaps, Max-Heaps

Heap에는 2가지가 있다.

- Min-Heap (최소힙) : 작은 값을 항상 위에 위치하여 최종적으로 가장 작은 값이 root 노드에 위치하게 된다.
- Max-Heap (최대힙) : 큰 값이 항상 위에 위치하여 최종적으로 가장 큰 값이 root 노드에 위치하게 된다.

### 최소힙에 노드 삽입

힙에 노드를 삽입할 때는 트리의 맨 끝에 노드를 삽입하게 되는데 삽입할 때 완전 이진 트리의 구조를 잃지 않도록 레벨의 왼쪽부터 채워나가야 한다.

![heap1](https://user-images.githubusercontent.com/55525868/222426536-3c3f70eb-28f2-4e47-b9e3-3acacfd139fb.png)

노드를 삽입한 이후에는 정렬이 되어 있지 않기 때문에 삽입한 노드와 부모 노드를 비교하여 값이 작은 노드가 위에 위치시키도록 `swap`한다.

![heap2](https://user-images.githubusercontent.com/55525868/222426546-204a204b-64e0-4742-87ec-3ba826a58fde.png)

이렇게 삽입한 노드와 부모 노드를 계속 비교하여 작은 노드가 위에 위치시키게 위 과정을 반복한다. 가장 작은 값이 root 노드에 도착하게 되면 위 과정을 멈춘다.

![heap3](https://user-images.githubusercontent.com/55525868/222426560-0c8e9e8b-4847-4e66-b93d-2969e7777a7b.png)

이러한 작업은 Balance한 완전 이진 트리에서 한 레벨씩 root 노드까지 과정이 이루어지므로 시간복잡도는 `O(log N)`이 된다.

### 최소힙에 노드 꺼내기

최소힙에서 노드를 꺼낼 때는 가장 작은 값을 꺼내려고 할 것이다. 최소힙에서 가장 작은 값은 root 노드에 있으므로 꺼내는 것은 어렵지 않을 것이다. 하지만 문제는 root 노드를 꺼냈을 때 root 노드가 비어있으므로 빈 공간을 채워주어야 한다. (완전 이진 트리의 특징을 보면 왜 채워야 하는지 알 수 있다.)

![heap4](https://user-images.githubusercontent.com/55525868/222426650-9e3e8773-95b3-42a4-b622-bd7cb4433fe0.png)

채울 때는 완전 이진 트리의 맨 마지막 노드를 가져와서 root 노드로 채운다.

![heap5](https://user-images.githubusercontent.com/55525868/222426660-a3cde656-1230-4db1-9c90-2a9be09a70b3.png)

하지만 위 그림에서 정렬이 되어 있지 않은 것을 볼 수 있다. 그래서 자신의 자식 노드와 비교하여 값이 더 작은 값과 `swap`한다.

![heap6](https://user-images.githubusercontent.com/55525868/222426672-9978a268-2a52-45f8-825f-7f87df53619f.png)

자식의 노드가 부모의 노드보다 커질 때까지 위 과정을 반복한다. 이 과정 역시 완전 이진 트리의 구조에서 한 레벨씩 위에서 밑으로 수행이 되므로 최대 `O(log N)`의 시간복잡도를 가진다.

> 최대힙 역시 노드를 삽입할 때와 노드를 꺼낼 때 동작이 동일하므로 생략하겠다. (최소힙과 반대로 생각하면 되겠다.)

## Reference

- [엔지니어대한민국 - Heap](https://www.youtube.com/watch?v=jfwjyJvbbBI)