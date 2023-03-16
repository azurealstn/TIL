# 퀵 정렬

퀵 정렬은 이름 그대로 매우 빠른 수행 속도를 가지며, 분할 정복(Divide and Conquer) 알고리즘을 사용한다. 분할 정복 알고리즘은 그대로 해결할 수 없는 **문제를 작은 문제로 분할하여 문제를 해결하는 방법**을 말한다.

## 퀵 정렬 개념

- 찰스 앤터니 리처드 호어가 개발한 정렬 알고리즘
- 다른 원소와의 비교만으로 정렬을 수행하는 비교 정렬에 속한다.
- 평균적으로 `O(N log N)`의 시간복잡도를 가지며, 최악의 경우에는 `O(N^2)`의 시간복잡도를 갖는다.
- 매 단계마다 적어도 1개의 원소가 자기 자리를 찾게 되므로 이후에 정렬할 개수가 줄어들기 때문에 퀵 정렬(빠른 정렬)이라는 이름을 갖게 되었다.
- 분할 정복 알고리즘을 사용한다.

## 퀵 정렬 과정

![quicksort1](https://user-images.githubusercontent.com/55525868/225629143-85455bf5-ae6e-46e4-b2d3-13431ab255b6.png)

- 현재 배열은 정렬이 되어있지 않기 때문에 임의의 숫자인 가운데를 지정한다. -> 이 숫자를 `pivot`이라 한다.
- `pivot`을 기준으로 왼쪽은 작은 값들, 오른쪽은 큰 값들을 배치하도록 한다.
- 나눈 두 파티션에서 각각의 파티션을 또 임의의 숫자 가운데를 지정하여 왼쪽은 작은 값들, 오른쪽은 큰 값들로 배치한다.
- 위 과정을 반복하다보면 결국 원소가 2개가 되는데 그 2개를 가지고 또 위 과정을 거치면 결국엔 정렬된 상태가 된다.

### 동작 순서

위 과정에서 `pivot`을 기준으로 왼쪽은 작은 값들, 오른쪽은 큰 값들을 배치하도록 한다고 했는데 어떻게하면 이러한 동작을 할 수 있는지 살펴본다.

### 🎈 잠깐!

- **S** : 시작 인덱스, **E** : 끝 인덱스
- 시작 인덱스의 원소값이 피벗값보다 작으면 오른쪽으로 이동한다. (시작 인덱스의 원소값이 피벗값보다 크면 멈춘다.)
- 끝 인덱스의 원소값이 피벗값보다 크면 왼쪽으로 이동한다. (크지 않으면 멈춘다.)
- 시작 인덱스와 끝 인덱스 둘 다 멈추면 두 원소를 스왑(swap)해준다.
- 그리고나서 시작 인덱스를 오른쪽으로, 끝 인덱스를 왼쪽으로 한 칸씩 이동한다.

![quicksort2](https://user-images.githubusercontent.com/55525868/225629151-605081b6-9332-4476-934e-4e3146cf120c.png)

위 동작 순서가 모두 끝나게 되면 `pivot`을 기준으로 왼쪽은 작은 값들, 오른쪽은 큰 값들로 배치된다. 이 과정을 반복하면 결국 정렬이 된다. 즉, 반복적인 행위를 퀵 정렬 함수를 만들어서 재귀적으로 호출하면 된다.

## 퀵 정렬 구현

```java
package com.azurealstn.algorithm.try1.sort;

public class QuickSortTest {
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1); //arr: 배열, 0: start, arr.length - 1: end
    }

    private static void quickSort(int[] arr, int start, int end) {
        int rightPart = partition(arr, start, end);//파티션을 나눈후 오른쪽 파티션의 첫번째 원소 반환
        //오른쪽 파티션이 시작점보다 1개 이상 차이나면 정렬을 수행한다.
        //1개면 굳이 정렬할 필요가 없기 때문!
        if (start < rightPart - 1) {
            quickSort(arr, start, rightPart -1); //왼쪽 파티션
        }
        //오른쪽 파티션이 끝지점보다 작아야지만 정렬을 수행한다.
        if (rightPart < end) {
            quickSort(arr, rightPart, end); //오른쪽 파티션
        }
    }

    //파티션 나누기
    private static int partition(int[] arr, int start, int end) {
        int mid = (start + end) / 2; //중간 인덱스
        int pivot = arr[mid];
        while (start <= end) { //start와 end의 교차되기 전까지 반복
            while (arr[start] < pivot) start++; //피벗값이 시작 인덱스의 원소값보다 작으면 오른쪽으로 이동
            while (arr[end] > pivot) end--; //피벗값이 끝 인덱스의 원소값보다 크면 왼쪽으로 이동
            if (start <= end) { //아직 교차되기 전이라면 스왑해준다.
                swap(arr, start, end);
                //스왑하고 나서 시작 인덱스는 오른쪽으로, 끝 인덱스는 왼쪽으로 한칸 이동한다.
                start++;
                end--;
            }
        }
        return start;
    }

    //스왑 함수
    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    //출력 함수
    private static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        printArray(arr);
        quickSort(arr); //퀵 정렬 수행
        printArray(arr);
    }
}
```

## References

- [엔지니어대한민국 - 퀵 정렬](https://www.youtube.com/watch?v=7BDzle2n47c)
- https://ko.wikipedia.org/wiki/%ED%80%B5_%EC%A0%95%EB%A0%AC
- https://gmlwjd9405.github.io/2018/05/10/algorithm-quick-sort.html