package algorithm4.ch1_foundation;

public class CloneTest implements Cloneable{
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//     //深拷贝进一步操作
//        CloneTest clonea = null;
//        clonea = (CloneTest) super.clone();
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
        CloneTest clone1 = new CloneTest();
        clone1.count = 2;
        CloneTest clone2 = clone1;
        clone2.count = 3;
        System.out.println(clone1.count);
        try {
            CloneTest clone3 = (CloneTest)clone1.clone();
            clone3.count = 4;
            System.out.println(clone1.count);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
