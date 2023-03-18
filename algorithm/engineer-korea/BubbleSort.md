# Bubble Sort (버블 정렬)

버블 정렬은 정렬 알고리즘 중 하나로, 거품 정렬이라고도 한다. 또한 구현해보면 알겠지만 버블 정렬은 코드가 정말 단순하다. 그래서 자주 사용된다.

## 버블 정렬 개념

- `O(n^2)`의 상당히 느린 시간복잡도를 갖느다.
- 코드가 단순하기 때문에 자주 사용되며, 원소의 이동이 거품이 수면으로 올라오는 듯한 모습을 보이기 때문에 지어진 이름이다. 이를 양방향으로 번갈아 수행하면 칵테일 정렬이 된다.

## 버블 정렬 알고리즘

- 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘
  - 인접한 두 원소가 정렬이 안되어 있으면 두 원소를 swap하고, 정렬이 되어있으면 그대로둔다.
- 서로 인접한 두 원소를 배열의 마지막 원소까지 비교해나가다 보면 결국에 마지막 원소가 자리를 잡게 된다. 이렇게 한 사이클이 `1회`이다.
- 이 알고리즘을 배열이 모두 정렬될 때까지 즉, 배열에 아무런 변화가 없을 때까지 반복한다.
- 포인트는 `1회`가 끝나면 마지막 원소는 자리를 잡게 된다. 다음으로 `2회`가 끝나면 마지막에서 2번째 원소가 자리르 잡게 된다. 즉, 매회가 끝날 때마다 반복 수가 하나씩 줄어드는 것을 알 수 있다.

## 버블 정렬 구현하기

### 재귀 사용

```java
package com.azurealstn.algorithm.try1.sort;

public class BubbleSortTest {
    private static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length - 1); //재귀적으로 호출
    }

    private static void bubbleSort(int[] arr, int last) {
        if (last > 0) { //마지막 인덱스가 0보다 클 때까지 반복
            for (int i = 1; i <= last; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                }
            }
            bubbleSort(arr, last - 1); //반복되는 수는 마지막 인덱스에서 하나씩 줄어든다.
        }
    }

    private static void swap(int[] arr, int source, int target) {
        int tmp = arr[source];
        arr[source] = arr[target];
        arr[target] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2, 1};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
```

### 2중 for문 사용

```java
package com.azurealstn.algorithm.try1.sort;

public class BubbleSortTest {
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) { //반복수가 1개씩 줄어든다.
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int source, int target) {
        int tmp = arr[source];
        arr[source] = arr[target];
        arr[target] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2, 1};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
```

## References

- [엔지니어대한민국 - BubbleSort](https://www.youtube.com/watch?v=YbsQiiubO74&t=32s)
- https://ko.wikipedia.org/wiki/%EB%B2%84%EB%B8%94_%EC%A0%95%EB%A0%AC
- https://gmlwjd9405.github.io/2018/05/06/algorithm-bubble-sort.html