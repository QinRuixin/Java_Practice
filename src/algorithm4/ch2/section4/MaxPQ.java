package algorithm4.ch2.section4;

/**
 * @author qin
 * @date 2020-05-17
 *
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;       // 基于堆，pq[0] 没有使用
    private int N = 0;
    private Comparable<Key> comparator;

    /**
     * 自底向上建堆, 初始化，越靠近底层 比较次数越少 建堆复杂度 O(N)
     */
    public MaxPQ(Key[] keys) {
        N = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < N; i++)
            pq[i+1] = keys[i];
        for (int k = N/2; k >= 1; k--)
            sink(k);
    }

    public MaxPQ(int maxN){
        pq = (Key[])new Object[maxN+1];
        N = 0;
    }

    public MaxPQ(){
        this(0);
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k){
        while (k>1 && less(k/2,k)){
            // 可优化，先存 一直移动 再放
            exch(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if(j<N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            // 可优化，先存 一直移动 再放
            exch(k,j);
            k = j;
        }
    }

}
