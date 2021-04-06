package designPattern;

import java.util.HashMap;

/**
 * @author qin
 * @description 享元模式
 *
 * 时间换空间
 * example 文档中 多次使用相同图片
 *
 * @date 2021-04-06
 */
public class FlyWeightDemo {
}

class FlyweightFactory
{
    private HashMap<String,Flyweight> flyweights = new HashMap<>();
    public Flyweight getFlyweight(String key)
    {
        if(flyweights.containsKey(key))
        {
            return flyweights.get(key);
        }
        else
        {
            Flyweight fw = new ConcreteFlyweight("hello");
            flyweights.put(key,fw);
            return fw;
        }
    }
}

class Flyweight
{
    //内部状态作为成员属性
    private String intrinsicState;
    private OutSideObject outSideObject;
    public Flyweight(String intrinsicState)
    {
        this.intrinsicState = intrinsicState;
    }
    public void operation(String extrinsicState)
    {
//......
    }
}

class OutSideObject{
    private String outState;
}

class ConcreteFlyweight extends Flyweight{

    public ConcreteFlyweight(String intrinsicState) {
        super(intrinsicState);
    }
}