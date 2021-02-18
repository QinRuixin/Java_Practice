package algorithm4.ch1_foundation.section3_bag_queue_stack;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * dijkstra的双栈算术表达式求值
 *
 * 输入的表达式前后有括号，用空格分开，且每个符号对应一个左右括号 如
 * ( 1 + 100 )
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 * ( ( 1 + sqrt ( 5.0 ) ) / 2.0 )
 * //( 1 + 2 ^ 2 / 2 )
 */

public class Evaluate {
    public static void main(String[] args) {

/*
用户的输入在计算机缓冲区中是这样存储的：42\n3.1415\nWelcome to HackerRank Java tutorials!\n
使用nextInt()读取42结束，剩下\n3.1415\nWelcome to HackerRank Java
使用nextDouble()读取3.1415，剩下\nWelcome to HackerRank Java
如果此时直接用nextLine()读取，该函数遇到换行符\n就结束
所以需要在这之前输入nextLine()，去掉缓冲区的\n，然后再读取
这是由于nextLine()会读取\n之前的所有内容，并去除\n，而nextDouble()等曾不会去除它后面的\n
*/

        String expression= "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )\n";
        // System.setIn(InputStream in) :重新分配“标准”输入流。
        System.setIn(new ByteArrayInputStream(expression.getBytes()));

        Scanner sc = new Scanner(System.in);
        // 读取输入并分隔方法1
//        while (sc.hasNext()) {
//            String s = sc.next();
//            System.out.println(s);
//        }
        // 读取输入并分隔方法2
        String exp = sc.nextLine().trim();
        String[] strs = exp.split("\\s+");

//        Arrays.stream(strs).forEach(System.out::println); // debug

        Stack<String> ops = new Stack<String>(); //操作符栈
        Stack<Double> vals = new Stack<Double>(); //操作数栈
        for(String s : strs){
            //读取字符，如果是运算符则压入栈
            if(s.equals(""));
            else if(s.equals("(")) ;
            else if(s.equals("+")) ops.push(s);
            else if(s.equals("-")) ops.push(s);
            else if(s.equals("*")) ops.push(s);
            else if(s.equals("/")) ops.push(s);
            else if(s.equals(")")){
                //如果是 ")"弹出操作符和操作数，计算结果并压入栈
                String op = ops.pop();
                double v = vals.pop();
                if(op.equals("+")) v=vals.pop()+v;
                else if(op.equals("-")) v=vals.pop()-v;
                else if(op.equals("*")) v=vals.pop()*v;
                else if(op.equals("/")) v=vals.pop()/v;
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }

        System.out.println(vals.pop());
    }

}
