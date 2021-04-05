public class InsertionSort {

    public static void main(String[] args) {

        int data[] = {66, 10, 1, 34, 5};

        insertion(data);
        for(int i = 0; i < data.length; i++){
            System.out.println("Data["+i+"] : " + data[i]);
        }

    }

    public static void insertion(int[] data){
        int size = data.length;
        int temp = 0;
        int j = 0;
        for(int i = 1; i < size; i++){
            temp = data[i];
            for(j=i-1; j>=0 && temp<data[j]; j--){
                data[j+1] = data[j];
            }
            data[j+1] = temp;
        }
    }


}
