# Sorting

### 1. Selection Sort (선택 정렬)
* 시간 복잡도 O(N^2)
* 설명 
    * 정렬되지 않은 데이터 중 최솟값을 찾음
    * 최솟값을 맨앞에 위치한 값과 교환
    * 나머지 데이터를 같은 방법으로 정렬
```java
class SelectionSort {

    public static void selection(int[] data){
        int size = data.length;
        int min;
        int temp;

        for(int i=0; i<size-1; i++){
            min = i;
            for(int j=i+1; j<size; j++){
                if(data[min] > data[j]){
                    min = j;
                }
            }
            temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }
   
    }
}
```


### 2. Insertion Sort (삽입 정렬)
* 시간 복잡도 O(N^2)
* 설명 
    * 배열의 모든 요소를 이미 정렬된 배열 부분과 비교 후 자신의 위치를 삽입한다.
    * 배열 두번째 데이터부터 연산 시작
```java
class InsertionSort {

    public static void insertion(int[] data){
        int size = data.length;
        int temp = 0;
        int j = 0;
        for(int i = 1; i < size; i++){ // 배열의 두번째 요소부터 연산을 시작
            temp = data[i];
            for(j=i-1; j>=0 && temp<data[j]; j--){
                data[j+1] = data[j];
            }
            data[j+1] = temp;
        }
    }

}

```

### 3. Bubble Sort (버블 정렬)
* 시간 복잡도 O(N^2)
* 설명 
    * 서로 인접한 두 원소를 비교하여 정렬
        * 인접한 두개의 원소를 비교 후 정렬되어 있지 않다면 정렬 수행
```java

class BubbleSort {

    public static void bubble(int [] data){
        int temp = 0;
        for(int i=data.length-1; i>=0; i--){
            for(int j=0; j<i; j++){
                if(data[j] > data[j+1]){
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

}


```
### 4. Quick Sort (퀵 정렬)
* 시간 복잡도 O(n^2) or O(N*log N)
* 설명
    * 기준값 (pivot)을 기준으로 왼쪽, 오른쪽의 원소들을 정렬해 나간다.
```java
public class QuickSort {

    public static void main(String[] args) {

        int[] data = {1,10,5,8,7,6,4,3,2,9};

        quick(data, 0, data.length-1);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }

    }

    public static void quick(int[] data, int start, int end){

        if(start >= end) {
            return;
        }

        int key = start;
        int i = start+1;
        int j=end;
        int temp;

        while(i <= j) {
            while(i <= end && data[i] <= data[key]) {
                i++;
            }

            while(j > start && data[j] >= data[key]) {
                j--;
            }

            if(i > j) {
                temp = data[j];
                data[j] = data[key];
                data[key] = temp;
            } else {
                temp =data[i];
                data[i] = data[j];
                data[j] = temp;
            }

        }

        quick(data, start,j-1);
        quick(data, j+1, end);

    }

}
```

### 5. Merge Sort (병합 정렬)
* 시간 복잡도 O(N*logN)
    * 반으로 계속 나누고 나중에 합치면서 정렬하기


```java
public class MergeSort {

    public static int[] sorted;

    public static void main(String[] args) {
        int[] data = {7,6,5,8,3,5,9,1};
        sorted = new int[data.length];
        mergeSort(data,0,data.length-1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");

        }
    }

    public static void merge(int[] a, int m, int middle, int n) {

        int i=m;
        int j=middle +1;
        int k = m;

        while(i<=middle && j <=n) {
            if(a[i] <= a[j]) {
                sorted[k] = a[i];
                i++;
            } else {
                sorted[k] = a[j];
                j++;
            }
            k++;
        }

        if(i > middle) {
            for (int t = j; t <= n ; t++) {
                sorted[k] = a[t];
                k++;
            }
        } else{
            for (int t = i; t <=middle; t++) {
                sorted[k] = a[t];
                k++;
            }
        }

        for (int t = m; t <=n; t++) {
            a[t] = sorted[t];
        }
    }

    public static void mergeSort(int[] a, int m, int n) {
        if(m < n){
            int middle = (m+n) /2;
            mergeSort(a,m,middle);
            mergeSort(a,middle+1, n);
            merge(a,m,middle, n);
        }
    }
}
```

### 6. Heap Sort (힙 정렬)
* 시간 복잡도 O(N*logN)
  * 최대힙(Max Heap)으로 구성
    * 힙생성 알고리즘(Heapify)을 활용
  * 1. 최대힙으로 구성된 배열의 Root는 최대값이므로 Root의 있는 값을 가장 뒤쪽으로 보내면서 힙트리의 크기를 1씩 빼준다.
  * 2. 정렬된 가장 뒤쪽 배열의 값을 제외 한 후 힙생성 알고리즘 수행
  * 위 1,2 과정을 반복 한다.
  
```java
public class HeapSort {

    public static int[] heap;

    public static void main(String[] args) {
        heap = new int[]{7,6,5,8,3,5,9,1,6};
        int number = heap.length;
        makeMaxHeap(number);
        ordering(number);

        for (int i = 0; i < number; i++) {
            System.out.print(heap[i]+" ");
        }

    }

    private static void ordering(int number) {
        
        // root 노드의 값을 맨 아래로 보내주며
        // 배열의 크기를 끝쪽에서부터 줄여나감
        for (int i = number -1; i >= 0 ; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            int root = 0;
            int c = 1;
            do{
                //힙 생성 알고리즘 적용
                c = 2*root+1;
                if(c < i-1 && heap[c] < heap[c+1]){
                    c++;
                }
                if(c<i && heap[root] < heap[c]) {
                    temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                root = c;
            } while(c<i);
        }
    }

    private static void makeMaxHeap(int number) {
        //MaxHeap 만들기
        for (int i = 1; i < number; i++) {
            int c = i;
            do{
                int root = (c - 1) /2;
                if(heap[root] < heap[c]) {
                    int temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                c = root;
            }while(c!=0);
        }
    }

}
```

### 7. Counting Sort (계수정렬)
* 시간 복잡도 O(N)
  * 데이터의 크기가 한정되어 있을때 적용가능한 알고리즘
    * ex) 5 이하 자연수데이터들을 오름차순으로 정렬 하세요. { 1,3,2,4,3,2,5,3,1,2,3,4,4,3,5,1,2,3,5,3,2,1,4,3,5,1,2,1,1,1 }
  * 크기를 기준으로 갯수를 먼제 센 후 정렬

```java
public class CountingSort {

    public static int temp;
    public static int[] count;
    public static int[] data;

    public static void main(String[] args) {
        count = new int[5];
        data = new int[] {
                1,3,2,4,3,2,5,3,1,2,3,4,4,3,5,1,2,3,5,3,2,1,4,3,5,1,2,1,1,1
        };

        for (int i =0; i < count.length; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < 30; i++) {
            count[data[i] -1] ++;
        }

        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    System.out.print((i+1) +" ");
                }
            }
        }
    }

}
```
### 8. Topology Sort (위상 정렬)
* 시간 복잡도 O(V+E) [V 정점, E 간선]
  * 위상 정렬은 정렬이 아닌 그래프가 지나가는 순서를 정렬해 주는 것이다.
  * 순차적인 그래프 형태일때 적용 가능
  * 사이클이 발생하지 않는 방향그래프일 때 적용 가능
  * 위상정렬은 시작점이 존재해야 적용 가능
  * 스택을 이용한 방식과, 큐를 이용한 방식이 있다.
  * 큐를 이용한 방식이 범용적으로 쓰인다.
    * 알고리즘 순서
        1. 진입차수가 0인 정점을 큐에 삽입
        2. 큐에서 원소를 꺼내고, 간선을 제거
        3. 큐가 빌때까지 a,b를 반복, 모든 원소를 방문하기 전에 큐가 비어버린다면, 사이클애 존재하는 것이기 때문에, 모든 원소를 방문 했다면, 큐에서 꺼낸 순서가 위상 정렬의 결과이다.
  
```java
import java.util.*;

public class TopologySort {

    static int n;
    static int e;

    public static void main(String[] args) {
        n = 7; // 정점 갯수
        e = 9; // 간선 갯수
        int[] indegree = new int[n + 1];
        List<List<Integer>> array = new ArrayList<List<Integer>>();

        for (int i = 0; i < n + 1; i++)
            array.add(new ArrayList<Integer>());

        // 간선 목록 v1 -> v2
        int[] v1 = {1, 1, 2, 4, 3, 3, 5, 2, 5};
        int[] v2 = {2, 3, 5, 6, 4, 7, 6, 4, 4};

        /**
         * 1. v1 -> v2 인접리스트 생성
         * 2. v2 를 가리키는 노드 갯수 indegree 증가
         */
        for (int i = 0; i < e; i++) {
            int c1 = v1[i];
            int c2 = v2[i];

            array.get(c1).add(c2);
            indegree[c2]++;
        }

        topologicalSort(indegree, array);
    }

    static void topologicalSort(int[] indegree, List<List<Integer>> array) {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        // 큐에 indegree 가 0 인 노드 담기
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        /**
         * 1. 큐에서 값을 꺼내며 해당 노드가 가리키는 노드의 indegree 를 1 감소
         * 2. 만약 indegree가 0 이 된다면 큐에 넣기
         * 3. 큐가 빌때까지 반복
         */
        while (!q.isEmpty()) {
            int node = q.poll();
            result.offer(node);

            for (Integer i : array.get(node)) {
                indegree[i]--;

                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        System.out.println(result);
    }
}
```