# ArrayList

ArrayList를 알아보기 전에 먼저 Array에 대한 특징을 간략히 살펴보면..

- 고정된 크기를 갖는다.
- (논리) 메모리에 연속적으로 배치되어 있다.
- 순서가 존재하며 순차적으로 할당된다.

특징을 보면 Array의 가장 큰 한계는 고정된 크기라는 점이다.

- 배열은 인덱스에 따라서 값을 유지하기 때문에 데이터가 삭제되어도 빈자리가 그대로 남게되어 메모리 낭비가 있다.
- 빈자리를 채우기 위해 데이터들을 Shift 해야하는 연산 작업이 있다.
- 따라서 위의 한계를 극복하기 위해 나온 것이 ArrayList이다.

> 💡 PHP에서는 Array가 고정된 크기가 아닌 데이터 추가시 자동으로 사이즈가 늘어난다. 

## ArrayList 개념

![arraylist1](https://user-images.githubusercontent.com/55525868/224351658-f61da2f5-7800-41ca-8ab5-da2a953aad8e.png)

- 자바에서 ArrayList는 자바 컬렉션 프레임워크중 하나인 `List` 인터페이스의 구현체이다.
- Array의 한계점을 극복하여 데이터가 추가되어도 배열의 사이즈가 동적으로 늘어난다.
- 심지어 검색 속도 또한 Array와 동일한 `O(1)`의 시간복잡도를 갖는다.

이것이 가능한 이유는 ArrayList는 배열의 방이 모두 차면 배열의 크기를 기존의 2배로 늘린다. 따라서 검색시에는 여전히 고정된 배열에서 진행하기 때문이다. (배열의 크기만 늘릴뿐 인덱스에는 영향이 없다!)

```java
//자바에서 ArrayList 라이브러리를 사용하려면 아래와 같이 선언하면 된다.
List<T> list = new ArrayList<>();
```

## Doubling

![arraylist2](https://user-images.githubusercontent.com/55525868/224351667-0c599267-18bf-44bc-b846-84e5e944be82.png)

- ArrayList는 배열 방이 모두 찼을 때 기존 배열 방 크기의 2배만큼 늘린다고 했다.
- 이 때 기존 배열에서 늘리는 것이 아닌 크기를 2배 늘린 새로운 배열을 생성하는 것이다. 
- 그래서 기존 배열에 있던 데이터들을 모두 새로운 배열에 복사하는 작업을 바로 Doubling 이라고 한다.
- Doubling이 소요되는 시간은 기존 데이터 개수가 n이라고 할 때 Doubling이 수행되면 `O(n)`의 시간복잡도를 갖는다.

배열의 크기를 2배만큼 늘리고, 새로운 배열을 생성하고 또 기존 데이터를 가지고 모두 복사까지 하는 이러한 번거로운 작업임에도 불구하고 ArrayList의 입력(삽입) 시간은 `O(1)`이 된다. 그 이유를 살펴보자.

![arraylist3](https://user-images.githubusercontent.com/55525868/224351674-35fd49ed-a5fc-47e4-b2d9-1de4a90b4950.png)

Doubling 작업을 한 후에 새로운 배열에서 절반의 데이터는 기존에 있던 데이터들일 것이다. 즉 새로운 배열에 복사해야 하는 데이터의 양은 새로운 배열 크기의 절반이다.

위 과정에 따라서 새로운 배열 방 크기를 n이라고 했을 때 n/2개 만큼만 복사하면 된다.

![arraylist4](https://user-images.githubusercontent.com/55525868/224351685-922d24be-c8e8-46f0-8e56-e05551025baf.png)

그 전의 배열을 봤을 때 Doubling 작업은 n/2 크기의 절반 즉, n/4 만큼만 복사하면 된다. 또 그전의 Doubling 작업은 n/4 크기의 절반인 n/8 만큼만 복사하면 된다. 결국에는 데이터가 1개가 남을 때까지 반복하게 될 것이다.

따라서 복사하는 총 데이터양은 `n/2 + n/4 + n/8 + ... + 2 + 1`개로 이는 모두 합해도 결국에는 N보다는 작다. 이를 통해 N개 데이터를 삽입할 때 소요되는 시간복잡도는 `O(n)`이므로 한 개의 데이터를 삽입할 때 소요되는 시간복잡도는 `O(1)`이 된다. 다만 중간에 즉, 특정 인덱스에 데이터를 삽입하는 경우 그 뒤에 있는 데이터들은 Shift 연산을 하면서 뒤로 옮겨야 하므로 작업이 추가된다. 이 때는 시간복잡도가 `O(n)`이 된다.

## 🪝 잠깐!  

여기서 [재밌는 글](https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java)이 하나 있다. 바로 자바 언어를 사용할 때 언제 ArrayList를 사용하는 것이 좋은지, 아니면 LinkedList를 사용하는 것이 좋은지에 대한 글이 있는데 결론은 **그냥 ArrayList를 써라!**이다. 그 이유는 ArrayList가 평균적으로 LinkedList보다 기술적으로 좀 더 빠르고 무엇보다 검색할 때 ArrayList가 더 효율적이다. (따라서 고민하고 있다면 그냥 **ArrayList Choose!**)

위에서 ArrayList는 인덱스가 있어서 데이터를 가져올 때는 `O(1)`의 시간복잡도가 걸리고, 삽입할 때 역시 `O(1)`이며 최악의 경우에는 `O(n)`이 걸린다고 했다. 

하지만 LinkedList는 인덱스가 아닌 다음 주소가 어딘지만 알고 있기 때문에 데이터를 가져올 때 `O(n)`의 시간복잡도가 걸리고, 삽입할 때 역시 `O(n)`이 걸린다. 심지어 LinkedList는 ArrayList보다 메모리를 더 잡아먹는다.

> 💡 시간복잡도를 계산할 떄는 항상 최악의 경우를 고려해야 한다. LinkedList는 맨 앞에 있는 데이터를 가져올 때는 `O(1)`의 시간복잡도를 갖지만 맨 뒤에 있는 데이터를 가져올 때는 `O(N)`이 된다. 또한 데이터 삽입의 경우 추가하려는 데이터의 위치가 맨 앞이라면 `O(1)`이 되고, 추가하려는 데이터의 위치가 맨 뒤에 위치한다면 `O(N)`이 되는 것이다.

## ArrayList 구현하기

```java
package com.azurealstn.algorithm.try1.arraylist;

class ArrayList {
    private Object[] data; //Object 타입의 배열
    private int size; //배열의 사이즈
    private int index; //다음 데이터를 추가할 위치

    public ArrayList() {
        this.size = 1; //처음 사이즈는 1로 초기화
        this.data = new Object[size]; //size만큼의 배열 선언
        this.index = 0; //새로 들어올 데이터는 0번부터 시작
    }

    public void add(Object obj) {
        if (this.index == this.size - 1) {
            doubling(); //추가하려는데 배열이 모두 찼으면 doubling 작업 시작
        }
        data[this.index] = obj; //배열 공간이 남아있으면 해당 index에 obj 할당
        this.index++; //데이터가 추가되었으므로 index 증가
    }

    private void doubling() {
        this.size = this.size * 2; //현재 사이즈를 2배 증가
        Object[] newData = new Object[this.size]; //새로운 배열 선언
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i]; //새로운 배열에 기존 배열들 데이터 모두 복사
        }
        this.data = newData; //전역으로 선언된 배열 data를 새로운 배열을 가리키게 한다.
    }

    public Object get(int i) throws Exception {
        checkValidIndex(i); //가져오려는 인덱스가 유효한지 체크 메서드
        return this.data[i]; //위의 조건에서 다 만족하지 않으면 해당 배열에서 가져온다.
    }

    public void remove(int i) throws Exception {
        checkValidIndex(i); //삭제하려는 인덱스가 유효한지 체크 메서드
        for (int x = i; i < this.data.length; i++) {
            data[x] = data[x + 1]; //삭제하려는 index부터 왼쪽으로 Shift를 해준다.
        }
        this.index--;
    }

    private void checkValidIndex(int i) throws Exception {
        if (i > this.index - 1) { //가지고 있는 데이터의 인덱스보다 크면 Exception
            throw new ArrayIndexOutOfBoundsException(i);
        } else if (i < 0) { //가져오려는 데이터의 인덱스가 0보다 작으면
            throw new Exception("Negative Value!");
        }
    }
}
public class ArrayListImplement {
    public static void main(String[] args) throws Exception {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.get(2)); //3
        list.remove(2);
        System.out.println(list.get(2)); //4
    }
}
```


## References

- [엔지니어대한민국 - ArrayList](https://www.youtube.com/watch?v=I4_uFyjWZn4&t=114s)
- http://www.incodom.kr/Array
- https://velog.io/@jaeyunn_15/DataStructure-ArrayList%EC%9D%98-%EA%B8%B8%EC%9D%B4%EB%8A%94-%EC%96%B8%EC%A0%9C-%EB%8A%98%EC%96%B4%EB%82%A0%EA%B9%8C
- https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java
- https://m.blog.naver.com/raylee00/221944085465