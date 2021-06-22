package design.pattern.creational;

/**
 * @author qin
 * @description 工厂方法 demo
 * @date 2021-04-01
 */
public class FactoryDemo {

}

class Client{
    ProductI product;
    FactoryI factory;

    public static void main(String[] args) {
        Client client = new Client();
        client.factory = new ConcreteFactory1();
        client.product = client.factory.createProduct();
        client.product.useProduct();
    }
}

interface ProductI{
    void useProduct();
}

class Product1 implements ProductI{

    @Override
    public void useProduct() {
        System.out.println("using Product1");
    }
}

interface FactoryI{
    ProductI createProduct();
}

class ConcreteFactory1 implements FactoryI{

    @Override
    public ProductI createProduct() {
        return new Product1();
    }
}
