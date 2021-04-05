# Sorting

### 1. Selection Sort
* 시간 복잡도 O(N^2)
* 설명 
    * 정렬되지 않은 데이터 중 최솟값을 찾음
    * 최솟값을 맨앞에 위치한 값과 교환
    * 나머지 데이터를 같은 방법으로 정렬
```
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
```

### 2. Insertion Sort
* 시간 복잡도 O(N^2)
* 설명 
    * 배열의 모든 요소를 이미 정렬된 배열 부분과 비교 후 자신의 위치를 삽입한다.
    * 배열 두번째 데이터부터 연산 시작
```
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
```

###3. Bubble Sort
* 시간 복잡도 O(N^2)
* 설명 
    * 서로 인접한 두 원소를 비교하여 정렬
        * 인접한 두개의 원소를 비교 후 정렬되어 있지 않다면 정렬 수행
```
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

```
###4. Quick Sort
* 시간 복잡도 O(n^2) or O(N*log N)
* 설명
    * 기준값 (pivot)을 기준으로 왼쪽, 오른쪽의 원소들을 정렬해 나간다.
```
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

###5. Merge Sort
* 시간 복잡




