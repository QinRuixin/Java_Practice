package orther.enumDemo.action;

/**
 * @author qin
 * @date 2020-05-26
 */
public class Game {
    public static void main(String[] args) {
        play(Action.RIGHT);
        play(Action.UP);
        System.out.println(Action.STOP.ordinal());  // 0
        System.out.println(Action.STOP);            // STOP
        System.out.println(Action.valueOf("STOP")); // STOP
//        Action action = Enum.valueOf(Action.class,"STOP");  等价于下面
        Action action = Action.valueOf("STOP");
        System.out.println(Action.STOP.equals(action));//true
    }

    private static void play(Action action) {
        switch (action){
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
