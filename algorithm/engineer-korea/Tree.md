# Tree

Tree를 이해하기 전에 먼저 선형 구조와 비선형 구조에 대해 알아볼 필요가 있다. 자료구조는 크게 2가지로 분류할 수 있다.

## 선형 구조

선형 구조란 자료를 구성하는 원소들을 하나씩 순차적으로 나열시킨 형태이다. 즉, 일직선 데이터 구조를 말한다. Array, LinkedList, Stack, Queue가 바로 선형 구조이다. 또한 선형 구조는 자료들의 관계가 1:1 관계가 된다.

![linear](https://user-images.githubusercontent.com/55525868/222042465-3cf99c60-f3ec-44e3-a404-46bf1e0c4f52.png)

## 비선형 구조

비선형 구조는 하나의 자료에 여러 개의 자료가 존재할 수 있는 형태를 말한다. 트리와 그래프가 바로 비선형 구조이다. 또한 자료들의 관계가 1:N 또는 N:N이 될 수 있다. 비선형 구조의 특징은 부모-자식간의 관계를 갖고 있으며, 계층적 구조를 나타낸다.

## Tree 개념

선형 구조와 비선형 구조를 알아보았듯이 Tree는 비선형 구조로서, 부모-자식 관계를 가지는 구조이다. 따라서 Tree는 계층이 있고, 그룹이 있다. 이것이 가능한 이유는 노드가 하나 이상의 자식 노드를 가지고 있기 때문이다. 또한 노드의 자식 노드가 없는 노드를 leaf 노드라고 한다.

![tree](https://user-images.githubusercontent.com/55525868/222044583-a33668d2-99ac-4f97-ab4d-6ca65b635ffd.png)

### Binary Tree (이진 트리)

Tree란 노드가 하나 이상의 자식을 가지면 Tree라고 했다. 이 때 자식 노드가 최대 2개까지만 있는 것이 Binary Tree라고 한다. 위의 그림이 이진트리가 된다.

> 트리의 자식 노드가 3개까지 붙은 Tree도 있는데 이를 Ternary Tree라고 한다.

### Binary Search Tree (이진 검색 트리)

자식 노드가 최대 2개 가지면 이진 트리라고 했다. 이진 검색 트리는 현재 노드 데이터가 7이라고 하면 7 노드를 기준으로 왼쪽 노드와 그 이하 자식 노드들은 7보다 작아야 하고, 오른쪽 노드와 그 이하 자식 노드들은 7보다 커야 한다. (그림을 보면 바로 이해할 수 있다.)

![binary_search_tree](https://user-images.githubusercontent.com/55525868/222046542-dbb63be9-42bb-4c28-afb5-0dc224ab3686.png)

- 또한 5 노드를 기준으로 봐도 왼쪽 노드는 5보다 작고, 오른쪽 노드는 5보다 큰 것을 볼 수 있다.
- 따라서 특정 노드를 찾고 싶을 때는 해당 노드보다 작으면 왼쪽에서 크면 오른쪽 노드에 찾으면 된다.

### Balance (균형)

Tree에서도 balance한 트리가 있고, unbalance한 트리가 있다. unbalance한 트리는 한 쪽으로 지나치게 모여있는 것을 말하며, 이것을 제외하면 나머지는 balance한 트리가 된다. 따라서 위의 그림들은 모두 balance한 트리가 되고, 아래 그림은 unbalance한 트리가 된다.

![unbalance](https://user-images.githubusercontent.com/55525868/222047390-5aac9190-8f47-4c81-9e96-2587bcc156c0.PNG)

> balance한 트리들 중 대표적으로 Red-Black Tree와 AVL Tree가 있다.

### Complete Binary Tree (완전 이진 트리)

완전 이진 트리란 모든 노드들이 레벨별로 왼쪽부터 채워져 있으면 완전 이진 트리라고 부른다.

![complete_binary_tree](https://user-images.githubusercontent.com/55525868/222048013-d1c39ba7-b26d-4865-b8cf-f6856e2361f5.png)

### Full Binary Tree

Full Binary Tree란 자식 노드를 안가지려면 한 개도 갖지 말아야 한다. 즉, 자식 노드가 한 개만 있으면 안된다.

![full_binary_tree](https://user-images.githubusercontent.com/55525868/222048329-ad4ec03f-0354-4966-b844-b0777b3bdd51.png)

### Perfect Binary Tree

Perfect Binary Tree란 레벨별로 모든 노드가 빈 공간 없이 채워져 있는 상태를 말한다. (완벽한 피라미드 구조) 즉, 빈 공간이 있으면 안된다.

![perfect_binary_tree](https://user-images.githubusercontent.com/55525868/222048726-2ef6d584-7bf1-4398-89f9-bbe1b3c742ae.png)

## Trie(트라이) Tree

Trie 자료구조는 특히 문자열에서 검색을 빠르게 할 수 있는 트리구조이다. 위에서 살펴보았듯이 이진트리의 시간복잡도는 `O(log N)`인 것을 확인할 수 있었다. 따라서 이진트리에서 문자열을 찾을 때는 특정 노드를 찾는데 `O(log N)` 시간이 걸리고 노드를 찾은 후 그 안에 문자열을 찾는데 또 `O(M)` 시간이 걸린다. 따라서 특정 문자열을 찾으려면 총 `O(M log N)`이 걸리게 된다. 

![trie1](https://user-images.githubusercontent.com/55525868/222716814-f88a8629-1a2d-465d-ad11-a273f3746d13.png)

하지만 Trie 자료구조를 이용하면 `O(M)` 만큼만 시간이 걸리게 할 수 있다.

![trie2](https://user-images.githubusercontent.com/55525868/222716827-317e2720-d2b0-4a70-86d5-35556adc8a15.png)

각 노드마다 알파벳이 있고, 위에서부터 레벨별로 하나씩 접근한다.  여기서 문자열에서 첫 알파벳이 항상 같은 것은 아니므로 루트 노드는 비워준다. 이제 `BOOK` 이라는 단어를 찾을 때는 위에서부터 밑으로 `BOOK`이라는 단어를 찾을 때까지 자식노드를 타고 쭉 탐색한다. `K` 노드로 왔을 때는 문자열의 끝이 되므로(빨간색 노드) 이 `K`노드에  `BOOK` 데이터가 저장된다. (즉, 빨간색 노드부분이 데이터가 저장되는 곳이다.) `TOP` 단어와 `TOY` 단어를 찾을 때는 마찬가지이다.

### Trie 장단점

위 방식에서 **Trie의 장점은 문자열 검색을 빠르게 할 수 있다.** 즉, 문자열의 길이만큼 노드를 따라가거나 추가하면 되기 때문에 시간복잡도는 `O(M)`이 된다.

하지만 **Trie의 단점은 메모리를 많이 잡아먹는다.** 문자열이 영어라면 일단 알파벳 26개는 기본이며, 대문자나 여러 특수문자도 허용이 된다면 노드가 무수히 늘어날 것이다.

## Reference

- [엔지니어대한민국 - Tree](https://www.youtube.com/watch?v=LnxEBW29DOw)
- [엔지니어대한민국 - Trie Tree](https://www.youtube.com/watch?v=TohdsR58i3Q)
- [jud00.tistory.com - 선형, 비선형](https://jud00.tistory.com/entry/Data-Structure-%EC%84%A0%ED%98%95Linear-%EB%B9%84%EC%84%A0%ED%98%95NonLinear-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0)
- [rebro.kr - Trie Tree](https://rebro.kr/86)