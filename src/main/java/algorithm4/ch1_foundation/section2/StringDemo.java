package algorithm4.ch1_foundation.section2;

public class StringDemo {
    public static void main(String[] args) {
        // 以空白字符为分隔符 创建字符串数组
        String src = "abc   de fg  hij   ";
        String[] words = src.split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }

//        // 从一个命令行参数中提取文件名和扩展名
//        String str1 = args[0];
//        int dot = str1.indexOf(".");
//        String base = str1.substring(0,dot);
//        String extension = str1.substring(dot+1);
//        System.out.println(base);
//        System.out.println(extension);

    }

    // 检查一个字符串数组中的元素是否已按照字母表顺序排列
    private static boolean isSorted(String[] a){
        for (int i = 1; i < a.length; i++) {
            if(a[i-1].compareTo(a[i]) > 0){
                return false;
            }
        }
        return true;
    }


}
