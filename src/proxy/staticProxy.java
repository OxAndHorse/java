package src.proxy;

public class staticProxy implements proxy1 {
    //静态代理
    //将目标方法注入代理类，如这里发送消息，定义发送消息接口，实现消息接口，代理类同样实现消息接口
    //注入
    private final proxy1 proxy11;
    public staticProxy(proxy1 proxy11){
        this.proxy11=proxy11;
    }

    @Override
    public String send(String message){
        System.out.println("发送前加强");
        proxy11.send(message);
        System.out.println("发送后加强");
        return message;
    }


    public static void main(String[] args) {
        proxy1 smsService = new proxyImpl() ;
        //通过静态代理实现发送
        proxy1 smsProxy = new staticProxy(smsService);
        smsProxy.send("使用静态代理发送java");
    }

}
