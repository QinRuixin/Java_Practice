package design.pattern.creational;

/**
 * @author qin
 * @description 工厂方法 demo
 * @date 2021-04-01
 */
public class AbstractFactoryDemo {

}

class Client{
    ProductAI productA;
    ProductBI productB;
    FactoryI factory;

    public static void main(String[] args) {
        Client client = new Client();
//        client.factory = new ConcreteFactory1();
        client.factory = new ConcreteFactory2();
        client.productA = client.factory.createProductA();
        client.productB = client.factory.createProductB();
        client.productA.useProduct();
        client.productB.useProduct();
    }
}

interface ProductAI{
    void useProduct();
}

interface ProductBI{
    void useProduct();
}
class ProductA1 implements ProductAI{
    @Override
    public void useProduct() {
        System.out.println("using ProductA1");
    }
}
class ProductB1 implements ProductBI{
    @Override
    public void useProduct() {
        System.out.println("using ProductB1");
    }
}
class ProductA2 implements ProductAI{
    @Override
    public void useProduct() {
        System.out.println("using ProductA2");
    }
}
class ProductB2 implements ProductBI{
    @Override
    public void useProduct() {
        System.out.println("using ProductB2");
    }
}

interface FactoryI{
    ProductAI createProductA();
    ProductBI createProductB();
}

class ConcreteFactory1 implements FactoryI{

    @Override
    public ProductAI createProductA() {
        return new ProductA1();
    }

    @Override
    public ProductBI createProductB() {
        return new ProductB1();
    }
}

class ConcreteFactory2 implements FactoryI{

    @Override
    public ProductAI createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductBI createProductB() {
        return new ProductB2();
    }
}