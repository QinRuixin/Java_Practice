package orther.enumDemo.priority;

/**
 * @author qin
 * @date 2020-05-26
 */
public enum Priority {
    MAX(10),NORM(5),MIN(1);

    private int value;

    private Priority(int value){    //  此处定义的构造函数只是编译程序
        this.value = value;         //  用来产生真正构造函数时参考之用，详见 Priority.jad
    }

    public int getValue() { //  获取自定义value
        return value;
    }

    public static void main(String[] args) {
        for(Priority priority: Priority.values()){
            System.out.println(priority+":"+priority.value);
        }
    }
}
