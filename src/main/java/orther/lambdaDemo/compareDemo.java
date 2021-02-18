package orther.lambdaDemo;

import orther.lambdaDemo.compare.StringOrder;

import java.util.Arrays;
import java.util.Comparator;

public class compareDemo {
    public static void main(String[] args) {
        String[] names = {"czy", "zt", "lq"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        // the same
        Comparator<String> byLength = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        Arrays.sort(names, byLength);

        for (String name : names) {
            System.out.println(name);
        }

        // Lambda表达式写法
        Comparator<String> byLength2 = (String name1, String name2) -> name1.length() - name2.length();
        // 根据泛型可以推断出类型，故可省略
        Comparator<String> byLength3 = (name1, name2) -> name1.length() - name2.length();
        // IDEA推荐
        Comparator<String> byLength4 = Comparator.comparingInt(String::length);

        // 按字典序排列，lambda表达式实际上是要操作 compare() 方法
        Arrays.sort(names, (name1, name2) -> name1.compareTo(name2));
//        Arrays.sort(names, Comparator.naturalOrder());
        for (String name : names) {
            System.out.println(name);
        }

        Arrays.sort(names, StringOrder::byLexicographyIgnoreCase);


        //如果运算比较复杂，必须使用多行描述，可以加入{}定义描述区块，如果有返回值，必须加上return
        Comparator<String> byLength5 = (String s1, String s2) -> {
            String name1 = s1.trim();
            String name2 = s2.trim();
            return name1.length() - name2.length();
        };


    }

}
