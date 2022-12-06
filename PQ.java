public class PQ<E extends Comparable<E>> {

    /*
    Priority Queue Implementation Using Unsorted Resizing Array
    Author @LwinPhyoAung
    insert O(1)
    delMax O(N)
    delMin O(N)
     */

    private E[] pq;
    private int pointer;
    private int size;

    public PQ(){
        pq = (E[]) new Comparable[10];
        size = pq.length;
    }

    public void insert(E e){

        if (pointer == size){
            resize(size * 2);
        }
        pq[pointer++] = e;

    }

    public E delMax(){

        if (pointer <= (size / 4)){
            resize(size/2);
        }
        int max = 0;
        for (int i = 1; i<pointer; i++){
            if (less(pq[max], pq[i])){
                max = i;
            }
        }
        E e = pq[max];
        swap(pq,pointer-1,max);
        pointer--;
        return e;

    }

    public E delMin(){

        if (pointer <= (size/4)){
            resize(size / 2);
        }
        int min = 0;
        for (int i = 1; i<pointer; i++){
            if (less(pq[i] , pq[min])){
                min = i;
            }
        }
        E e = pq[min];
        swap(pq,pointer-1,min);
        pointer--;
        return e;

    }

    private void resize(int capacity){

        E[] newPq = (E[]) new Comparable[capacity];
        for (int i = 0; i<pointer; i++){
            newPq[i] = pq[i];
        }
        pq = newPq;
        size = pq.length;

    }

    public boolean isEmpty(){
        return pointer == 0;
    }

    private boolean less(Comparable x,Comparable y){
        return x.compareTo(y) == -1;
    }

    private void swap(Comparable[] a,int x,int y){
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

}
