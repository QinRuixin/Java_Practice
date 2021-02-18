package algorithm4.ch1_foundation.section3_bag_queue_stack;

import java.util.Iterator;


/**
 * 用链表实现栈
 * */

public class Stack_linked<Item> implements Iterable<Item> {
    private Node first; // 栈顶
    private int N; // 元素数量

    private class Node{
        // 定义了节点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty() {return first==null;}  // 或： N == 0
    public int size()  {return N;}

    public void push (Item item){
        // 从栈顶添加元素
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        ++N;
    }

    public Item pop(){
        //从栈顶删除元素
        if(isEmpty()){
            throw new NullPointerException();
        }
        Item item = first.item;
        first = first.next;
        --N;
        return item;
    }

    /*
    * package java.lang;
    * import java.util.Iterator;
    *
    * public interface Iterable<T> {
    *       Iterator<T> iterator();
    * }
    * */

    /*
     * package java.util;
     *
     * public interface Iterator<E> {
     *      boolean hasNext();
     *      E next();
     *      default void remove() {throw new UnsupportedOperationException("remove");}
     * }
     * */

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>();
    }

    private class ListIterator<ItemT> implements Iterator<ItemT>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public ItemT next() {
            ItemT item = (ItemT) current.item;
            current = current.next;
            return item;
        }
    }

}
