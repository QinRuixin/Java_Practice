package orther.enumDemo.executeByEnum;

/**
 * @author qin
 * @date 2020-05-26
 */
public enum Action2 implements Command {
    STOP,RIGHT,LEFT,UP,DOWN;
    public void execute(){
        switch (this){
            case STOP:
                System.out.println("停止");
                break;
            case RIGHT:
                System.out.println("向右");
                break;
            case LEFT:
                System.out.println("向左");
                break;
            case UP:
                System.out.println("向上");
                break;
            case DOWN:
                System.out.println("向下");
                break;
            default:
                break;
        }
    }
}
