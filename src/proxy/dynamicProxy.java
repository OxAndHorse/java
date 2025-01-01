package src.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*
定义一个接口及其实现类；自定义 InvocationHandler 并重写invoke方法，在 invoke 方法中我们会调用原生方法（被代理类的方法）并自定义一些处理逻辑；
通过 Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h) 方法创建代理对象；

 */
public class dynamicProxy implements InvocationHandler {
    //目标对象注入
    private  final Object target;
    public dynamicProxy(Object target){
        this.target=target;
    }
    //自定义invoke handler，在不侵入原生方法的情况下对原生方法进行加强
    @Override
    public  Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }

    public static void main(String []args){
        //通过Proxy.newProxyInstance（）方法动态获取某个类的代理对象,
        proxy1 proxy11=(proxy1) Proxy.newProxyInstance(new proxyImpl().getClass().getClassLoader(),// 目标类的类加载器
                new proxyImpl().getClass().getInterfaces(),// 代理需要实现的接口，可指定多个
                new dynamicProxy(new proxyImpl()));// 代理对象对应的自定义 InvocationHandler
        //proxy11 是由 Proxy.newProxyInstance() 创建的代理对象，JVM 会将方法调用转发给 dynamicProxy 中的 invoke 方法。

        /*
        invoke 方法会接收到三个参数：
        proxy：代理对象本身（在这个例子中，proxy11）。
        method：被调用的方法（在这里是 send 方法）。
        args：方法参数（这里是 {"dynamic proxy"}，即传入的字符串参数）。
         */
        proxy11.send("dynamic proxy");
    }
}
