package orther.enumDemo.executeByEnum;

/**
 * @author qin
 * @date 2020-05-26
 */
public enum Action3 implements Command {
    STOP{
        public void execute(){
            System.out.println("stop");
        }
    },
    RIGHT{
        public void execute(){
            System.out.println("right");
        }
    },
    LEFT{
        public void execute(){
            System.out.println("left");
        }
    },
    UP{
        public void execute(){
            System.out.println("up");
        }
    },
    DOWN{
        public void execute(){
            System.out.println("down");
        }
    };
}
