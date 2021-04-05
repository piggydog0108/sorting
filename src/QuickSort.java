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
