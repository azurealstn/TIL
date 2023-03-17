# 병합 정렬

병합 정렬 즉, Merge Sort는 퀵 정렬과 마찬가지로 분할 정복 알고리즘 중 하나이다. 병합 정렬은 평균 시간복잡도 `O(N log N)`으로 퀵 정렬과 동일하다. 병합 정렬은 가운데를 기준으로 파티션을 나누므로 최악의 경우에도 `O(N log N)`의 시간복잡도를 갖는다. 하지만 병합 정렬은 실행시에 별도의 저장 공간이 필요로하기 떄문에 별도의 공간을 사용할 수 없는 경우라면 퀵 정렬을 사용하는 것이 바람직하다.

## 병합 정렬 개념

- 합병 정렬이라고도 하며, 비교 기반 정렬 알고리즘이다.
- 일반적인 방법으로 구현했을 때 병합 정렬은 안정 정렬에 속하며, 분할 정복 알고리즘 중에 하나이다.
- 존 폰 노이만이 개발했다.

## 병합 정렬 과정

1. 배열의 길이는 최소 1보다는 커야 한다.
2. 분할(Divide) : 정렬되지 않은 배열을 절반으로 잘라 비슷한 크기의 두 파티션으로 나눈다. (이 때 원소가 두 개가 남을 때까지 분할을 진행한다.)
3. 정복(Conquer) : 분할이 완료되면 나눈 각 파티션을 재귀적으로 호출해 정렬을 진행한다.
4. 결합(Combine) : 정렬이 완료되면 이제 나누었던 두 파티션을 하나의 정렬된 배열로 병합한다. (이 때 정렬된 배열이 임시 배열에 저장된다는 것을 기억하자.)
5. 복사(Copy) : 임시 배열에 저장된 결과를 원래 배열에 복사한다.

![mergesort1](https://user-images.githubusercontent.com/55525868/225923640-cab72bbe-0ce6-4c1e-b718-2f115c1de654.png)

**함수가 호출될 때마다 절반씩 잘라서 재귀적으로 함수를 호출하고 맨 마지막 레벨의 제일 작은 조각부터 2개씩 병합해서 정렬된 배열을 Merge(병합) 해나가는 방식이 바로 Merge Sort이다.**

## 병합 정렬 구현

```java
package com.azurealstn.algorithm.try1.sort;

public class MergeSortTest {
    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length]; //배열의 크기만큼 임시 배열을 생성한다.
        mergeSort(arr, tmp, 0, arr.length - 1); //재귀 호출
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) { //시작 인덱스가 끝 인덱스보다 작은 경우에만
            int mid = (start + end) / 2; //중간값
            mergeSort(arr, tmp, start, mid); //앞 파티션 정렬
            mergeSort(arr, tmp, mid + 1, end); //뒤 파티션 정렬
            merge(arr, tmp, start, mid, end); //나눈 두 파티션을 병합해준다.
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i]; //임시 배열에 복사
        }
        int partition1 = start; //앞 파티션의 시작 인덱스
        int partition2 = mid + 1; //뒤 파티션의 시작 인덱스
        int index = start; //저장할 위치 인덱스

        //앞 파티션이 끝까지 돌거나 뒤 파티션이 끝까지 돌때까지 반복
        while (partition1 <= mid && partition2 <= end) {
            if (tmp[partition1] <= tmp[partition2]) { //앞 파티션의 값이 뒤 파티션의 값보다 작으면
                arr[index] = tmp[partition1]; //배열에 앞 파티션의 값을 할당
                partition1++; //앞쪽 인덱스를 증가
            } else { //앞 파티션이 더 크다면
                arr[index] = tmp[partition2]; //배열에 뒤 파티션의 값을 할당
                partition2++; //뒤쪽 인덱스를 증가
            }
            index++; //저장할 인덱스 증가
        }

        //만약에 뒤쪽 배열은 비어있고, 앞쪽 배열이 남아있는 경우에는 계속 진행해야한다.
        //반대로 앞쪽 배열이 비어있고, 뒤쪽 배열이 남아있는 경우에는 상관이 없다.
        //그 이유는 뒤쪽 배열은 어차피 최종 배열에 이미 정렬되어 배치되어 있기 떄문이다.
        for (int i = 0; i <= mid - partition1; i++) {
            arr[index + i] = tmp[partition1 + i];
        }


    }

    //출력 함수
    private static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 3, 7, 8, 5, 1};
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }
}
```

## References

- [엔지니어대한민국 - Merge Sort](https://www.youtube.com/watch?v=QAyl79dCO_k&t=259s)
- https://ko.wikipedia.org/wiki/%ED%95%A9%EB%B3%91_%EC%A0%95%EB%A0%AC