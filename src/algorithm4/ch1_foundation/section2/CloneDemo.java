package algorithm4.ch1_foundation.section2;

public class CloneDemo implements Cloneable{
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//     //深拷贝进一步操作
//        CloneDemo clonea = null;
//        clonea = (CloneDemo) super.clone();
//        return clonea;
//    }

    int count = 0;
    InnerClass innerClass = new InnerClass();
    class InnerClass{
        int cnt = 0;
        void incre(){
            ++cnt;
        }
    }
    public static void main(String[] args) {
        CloneDemo clone1 = new CloneDemo();
        clone1.count = 2;
        CloneDemo clone2 = clone1;
        clone2.count = 3;
        System.out.println(clone1.count);
        try {
            CloneDemo clone3 = (CloneDemo)clone1.clone();
            clone3.count = 4;
            System.out.println(clone1.count);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
