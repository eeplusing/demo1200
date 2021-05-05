package com.eplusing.demo1200.designpattern.proxy.cglibproxy;

import com.eplusing.demo1200.designpattern.proxy.jdkproxy.LiuDehua;
import com.eplusing.demo1200.designpattern.proxy.jdkproxy.Star;
import com.eplusing.demo1200.designpattern.proxy.jdkproxy.StarProxy;

//JDK动态代理
//cglib动态代理

//代理模式，指一个对象A通过持有另一个对象B，可以具有B同样的行为的模式
/**
 *
 * 使用代理好处还不止这些，一个工程如果依赖另一个工程给的接口，
 * 但是另一个工程的接口不稳定，经常变更协议，就可以使用一个代理，接口变更时，
 * 只需要修改代理，不需要一一修改业务代码。从这个意义上说，
 * 所有调外界的接口，我们都可以这么做，不让外界的代码对我们的代码有侵入，这叫防御式编程。代理其他的应用可能还有很多
 *
 * */

/**
 *
 * 从代码可以看出，它和jdk动态代理有所不同，对外表现上看CreatProxyedObj，它只需要一个类型clazz就可以产生一个代理对象，
 * 所以说是“类的代理”，且创造的对象通过打印类型发现也是一个新的类型。不同于jdk动态代理，jdk动态代理要求对象必须实现接口（三个参数的第二个参数），cglib对此没有要求。
 *
 * cglib的原理是这样，它生成一个继承B的类型C（代理类），这个代理类持有一个MethodInterceptor，我们setCallback时传入的。C重写所有B中的方法（方法名一致），
 * 然后在C中，构建名叫“CGLIB”+“$父类方法名$”的方法（下面叫cglib方法，所有非private的方法都会被构建），方法体里只有一句话super.方法名()，
 * 可以简单的认为保持了对父类方法的一个引用，方便调用。
 *
 * 这样的话，C中就有了重写方法、cglib方法、父类方法（不可见），还有一个统一的拦截方法（增强方法intercept）。其中重写方法和cglib方法肯定是有映射关系的。
 *
 * C的重写方法是外界调用的入口（LSP原则），它调用MethodInterceptor的intercept方法，调用时会传递四个参数，第一个参数传递的是this，
 * 代表代理类本身，第二个参数标示拦截的方法，第三个参数是入参，第四个参数是cglib方法，intercept方法完成增强后，我们调用cglib方法间接调用父类方法完成整个方法链的调用。
 *
 * **/
public class CglibProxyTest {

    public static void main(String[] args) {
        Star ldh = new LiuDehua();
        StarProxy proxy = new StarProxy();
        proxy.setTarget(ldh);

        long time1 = System.currentTimeMillis();
        Star star = (Star)proxy.createProxyObject();
        long time2 = System.currentTimeMillis();
        System.out.println("jdk创建时间：" + (time2 - time1));

        CglibProxy cglibProxy = new CglibProxy();

        time1 = System.currentTimeMillis();
        Star star2 = (Star) cglibProxy.CreateProxyObject(LiuDehua.class);
        time2 = System.currentTimeMillis();
        System.out.println("cglib创建时间：" + (time2 - time1));

        int times = 100;

        time1 = System.currentTimeMillis();
        for (int i = 1; i <= times; i++)
        {
            star.sing("ss");

            star.dance("ss");
        }
        time2 = System.currentTimeMillis();
        System.out.println("jdk执行时间" + (time2 - time1));

        time1 = System.currentTimeMillis();
        for (int i = 1; i <= times; i++)
        {
            star2.sing("ss");

            star2.dance("ss");
        }
        time2 = System.currentTimeMillis();
        System.out.println("cglib执行时间" + (time2 - time1));


    }

}
