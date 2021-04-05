public class SelectionSort {

    public static void main(String[] args) {


        int data[] = {66, 10, 1, 99, 5};

        selection(data);

        for(int i=0; i<data.length; i++){
            System.out.println("Data["+i+"] : " + data[i]);
        }

    }

    public static void selection(int[] data) {
        int size = data.length;
        int min; //최소값을 가진 데이터의 인덱스 저장 변수
        int temp;

        for(int i=0; i<size-1; i++){ // size-1 : 마지막 요소는 자연스럽게 정렬됨
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
