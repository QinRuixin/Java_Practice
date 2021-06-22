package design.pattern.structural;

/**
 * @author qin
 * @description 外观模式 门面模式
 * 体现单一职责原则和迪米特法则
 * 与 中介者相似 但中介者封装的是内部对象的耦合
 * 外部接口的统一
 *
 * example1 电源总开关 —— 电灯Light 风扇Fan 空调AirConditioner 电视Tv
 * example2 文件加密 EncryptFacade —— FileReader  CipherMachine  FileWriter
 *          如果是 CipherMachine 经常变化 可以使用模板方法 （子类提供不同实现，复用父类的步骤，
 * example3 JDBC 中 ResultSet
 * example4 J2EE Session
 *
 * @date 2021-04-06
 */
public class FacadeDemo {

    public static void main(String[] args) {
        Client3 client3 = new Client3();
        client3.doMethod();
    }

}

class Client3 {
    private Facade facade;

    Client3() {
        facade = new Facade();
    }

    public void doMethod() {
        facade.doMethod();
    }
}

class Facade {
    private SubSystemA subSystemA;
    private SubSystemB subSystemB;

    Facade() {
        subSystemA = new SubSystemA();
        subSystemB = new SubSystemB();
    }

    public void doMethod() {
        System.out.println("Facade doMethod");

        System.out.println("Facade call subSystemA method");
        subSystemA.method();
        System.out.println("Facade  call subSystemB method");
        subSystemB.method();
    }

}

class SubSystemA {
    public void method() {
        System.out.println("SubSystemA method");
    }
}

class SubSystemB {
    public void method() {
        System.out.println("SubSystemB method");
    }
}
