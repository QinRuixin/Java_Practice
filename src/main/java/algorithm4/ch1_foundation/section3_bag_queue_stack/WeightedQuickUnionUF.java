package algorithm4.ch1_foundation.section3_bag_queue_stack;

public class WeightedQuickUnionUF {
    private int[] id; // parents
    private int[] sz; // weight of component 根节点所对应的分量的大小
    private int count;
    public WeightedQuickUnionUF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }
    public int getCount(){
        return count;
    }

    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }

    // 带路径压缩
    private int find(int p){
        int src = p;
        while (p!=id[p]) p = id[p];
        while (id[src]!=p){
            int tempSrc = id[src];
            id[src] = p;
            src = tempSrc;
        }
        return p;
    }

    public void union(int p,int q){
        int i = find(p);
        int j = find(q);
        if(i == j) return;
        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }else {
            id[j] = i;
            sz[i] += sz[j];
        }
        --count;
    }

}
