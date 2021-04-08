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
