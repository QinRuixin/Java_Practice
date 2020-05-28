package orther.regexDemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qin
 * @date 2020-05-28
 */
public class RegExDemo {
    public static void main(String[] args) {
        String str = "2020-05-27 23:07:44 酒(1000071292)";
        String str2 = " (80000000)";
//    String regEx = "(20[0-9]{2})-(0?[1-9]|1[0-2])-((0?[1-9])|([12][0-9])|30|31) ([0-9]|[12][0-9]):((0?[1-9])|([1-5][0-9])):((0?[1-9])|([1-5][0-9]))";
//    String regEx = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        String regEx = "((20[0-9]{2})-(0?[1-9]|1[0-2])-((0?[1-9])|([12][0-9])|30|31) ([0-9]|[12][0-9]):((0?[1-9])|([1-5][0-9])):((0?[1-9])|([1-5][0-9])))" +
                " (.*)\\(.*\\)";
        String regEx2 = " (.*)\\(.*\\)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches()){
            System.out.println(str);
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }
        Pattern pattern2 = Pattern.compile(regEx2);
        Matcher matcher2 = pattern2.matcher(str2);
        if(matcher2.matches()){
            System.out.println(str2);
        }
    }

}
