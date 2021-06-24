package design.pattern.creational;

/**
 * @author qin
 * @description 建造者
 * @date 2021-06-24
 */
public class BuilderDemo {

}

class BuilderClient {
    public static void main(String[] args) {

    }
}

class Director {

    Builder builder;
    Product product;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    Product construct() {
        builder.buildPart1();
        builder.buildPart2();
        return builder.getProduct();
    }
}

interface Builder {
    Product product = new Product();

    Product getProduct();

    int buildPart1();

    int buildPart2();
}

class BuilderA implements Builder {

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public int buildPart1() {
        product.setPart1(1);
        return 1;
    }

    @Override
    public int buildPart2() {
        product.setPart2(2);
        return 2;
    }
}

class Product {
    int part1;
    int part2;

    public void setPart1(int part1) {
        this.part1 = part1;
    }

    public void setPart2(int part2) {
        this.part2 = part2;
    }
}