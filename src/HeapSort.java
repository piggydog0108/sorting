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
