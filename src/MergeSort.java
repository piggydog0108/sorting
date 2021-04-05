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
