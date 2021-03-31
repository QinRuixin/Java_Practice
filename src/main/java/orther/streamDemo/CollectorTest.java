package orther.streamDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author qin
 * @description lambda 表达式 CollectorTest
 * @date 2021-03-31
 */
public class CollectorTest {
    public static void main(String[] args) {
        int[] list = new int[]{2,4,6,8,1,3,5,7};
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("213");
        arrayList.add("645");
        arrayList.add("8");
        Map<String, Integer> stringIntegerMap = arrayList.stream().collect(Collectors.toMap(Function.identity(), String::length));
//        Arrays.stream(list).collect(Collectors.toMap(Function.identity(), Integer::doubleValue));
        System.out.println(stringIntegerMap);


    }
}
