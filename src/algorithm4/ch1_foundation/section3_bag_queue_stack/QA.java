package algorithm4.ch1_foundation.section3_bag_queue_stack;

import java.util.Stack;

public class QA {
    public static void main(String[] args) {
        // java不允许泛型数组！

        //如何创建一个字符串栈的数组
        int N = 5;
//        Stack<String>[] a = new Stack<String>[N]; //报错
        Stack<String>[] a = (Stack<String>[]) new Stack[N];


    }
}
