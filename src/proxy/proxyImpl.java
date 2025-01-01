package src.proxy;

import src.proxy.proxy1;

public class proxyImpl implements proxy1 {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
