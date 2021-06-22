package design.pattern.behavioral;

/**
 * @author qin
 * @description 策略模式
 * @date 2021-05-14
 */
public class StrategyDemo {
    public static void main(String[] args) {
        StrategyContext context = new StrategyContext();
        try {
            context.setStrategyUsingStr("ConcreteStrategyA");
        } catch (Exception e) {
            e.printStackTrace();
        }
        context.useStrategy();

    }
}

class StrategyContext{
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategyUsingStr(String strategyStr) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 反射获取对象  Class.forName( "全限定类名" )
        this.strategy = (Strategy)Class.forName(Strategy.class.getPackage().getName() + "."+strategyStr).newInstance();
    }

    void useStrategy(){
        strategy.strategyMethod();
    }
}

interface Strategy{
    void strategyMethod();
}

class ConcreteStrategyA implements Strategy{
    @Override
    public void strategyMethod() {
        System.out.println("ConcreteStrategyA strategyMethod");
    }
}

class ConcreteStrategyB implements Strategy{
    @Override
    public void strategyMethod() {
        System.out.println("ConcreteStrategyB strategyMethod");

    }
}

class ConcreteStrategyC implements Strategy{
    @Override
    public void strategyMethod() {
        System.out.println("ConcreteStrategyC strategyMethod");

    }
}
