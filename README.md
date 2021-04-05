# sorting

### 1. Selection Sort
* 시간 복잡도 O(n^2)
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
* 시간 복잡도 O(n^2)
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
