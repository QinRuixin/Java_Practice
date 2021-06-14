package design.pattern;

/**
 * @author qin
 * @description 工厂方法
 * @date 2021-06-14
 */
public class FactoryMethodDemo {
}

class FactoryMethodClient{
    FactoryMethodProductI product;
    FactoryMethodI factory;

    public static void main(String[] args) {
        FactoryMethodClient client = new FactoryMethodClient();
        client.factory = new ConcreteFactoryMethod1();
        client.product = client.factory.createProduct();
        client.product.useProduct();
        client.factory = new ConcreteFactoryMethod2();
        client.product = client.factory.createProduct();
        client.product.useProduct();

    }
}

interface FactoryMethodProductI{
    void useProduct();
}

class FactoryProduct1 implements FactoryMethodProductI{
    @Override
    public void useProduct() {
        System.out.println("using Product1");
    }
}

class FactoryProduct2 implements FactoryMethodProductI{
    @Override
    public void useProduct() {
        System.out.println("using Product2");
    }
}

interface FactoryMethodI{
    FactoryMethodProductI createProduct();
}

class ConcreteFactoryMethod1 implements FactoryMethodI{
    @Override
    public FactoryMethodProductI createProduct() {
        return new FactoryProduct1();
    }
}

class ConcreteFactoryMethod2 implements FactoryMethodI{
    @Override
    public FactoryMethodProductI createProduct() {
        return new FactoryProduct2();
    }
}
