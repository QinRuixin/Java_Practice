package design.pattern;

import java.util.ArrayList;

/**
 * @author qin
 * @description 外观模式
 * 降低内部类之间的耦合程度
 *
 *
 * @date 2021-04-06
 */
public class MediatorDemo {

}

class MediatorClient{
    Mediator mediator;


}

abstract class Mediator{
    protected ArrayList<Colleague> colleagues;

    public void register(Colleague colleague){
        colleagues.add(colleague);
    }

    public abstract void operation1();

}

class ConcreteMediator extends Mediator{

    @Override
    public void operation1() {
        for (Colleague colleague :
                colleagues) {
            colleague.method1();
        }
    }
}

abstract class  Colleague{
    protected Mediator mediator;

    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }

    public abstract void method1();
    public abstract void method2();

}

class ConcreteColleague extends Colleague{
    public ConcreteColleague(Mediator mediator){
        super(mediator);
    }

    @Override
    public void method1() {
        System.out.println("ConcreteColleague method1");
    }

    @Override
    public void method2() {
        System.out.println("ConcreteColleague method2");
        System.out.println("call mediator operation1");
        mediator.operation1();
    }

}