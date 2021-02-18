package orther.enumDemo.executeByEnum;


/**
 * @author qin
 * @date 2020-05-26
 */
public class Game2 {
    public static void play(Action2 action){
        action.execute();
    }

    public static void main(String[] args) {
        Game2.play(Action2.UP);
        Game2.play(Action2.LEFT);
    }
}
