# sorting

###1. Selection Sort

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

###2. Insertion Sort
