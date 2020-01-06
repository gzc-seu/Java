package ProxyTest;
/**
 * 静态代理举例
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory nike=new NikeClothFactory();
        ProxyClothFactory proxyClothFactory=new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//用被代理类对象进行实例化
    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}
