package orther.test;

/**
 * @author qin
 * @description TTF
 * str3 编译优化 直接是 "abcd"
 * str4 new StringBuilder()
 *      append
 *      toString()
 *      创建了新对象
 *
 * @date 2021-04-06
 */
public class StrEqTest {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "abcd";
        String str3 = "ab"+"cd";
        String str4 = "ab";
        str4 += "cd";
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str1==str4);
    }
}
