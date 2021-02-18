package java_collections_framework;

import java.util.*;
import java.util.function.Consumer;

public class LinkedList_source<E> {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        /*
        * LinkedList 是一个双向链表
        *
        public class LinkedList<E>
            extends AbstractSequentialList<E>
            implements List<E>, Deque<E>, Cloneable, java.io.Serializable{

            }
        *
        * LinkedList实现了List接口，Queue和Deque接口
        * 既能作为List使用，也能作为双端队列使用，也可以作为栈使用
        *
        * 非同步的，线程不安全的
        * 利用 Collections.synchronizedList 可得到线程安全的版本
        * */
        List<String> list = Collections.synchronizedList(new LinkedList<>());
        /*
         * 其 listIterator 的方法是 fail-fast 的，也就是 listIterator 被创建后，如果被修改
         * 将会抛出 ConcurrentModificationException
         *
         * 相对的是 fail—safe， 迭代时是对原集合的拷贝进行遍历，
         * 所以在遍历过程中对原集合所作的修改并不能被迭代器检测到，
         * 不会触发ConcurrentModificationException
         *
         * */
    }

    // 节点
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    // transient 成员变量
    int size = 0;
    Node<E> first;
    Node<E> last;
    // 永真 (first == null && last == null) || (first.prev == null && first.item != null)


}
