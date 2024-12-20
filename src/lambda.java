package src;

import java.util.Arrays;
import java.util.List;

public class lambda {
    public static void main(String []args){
        funcdemo(()-> System.out.println("函数式接口"));
        //equivalent
        funcdemo(new func() {
            @Override
            public void fun() {
                System.out.println("函数式接口的传统实现");
            }
        });


        List<String> strings = Arrays.asList("1", "2", "3");
    }
    static void funcdemo(func i){
        System.out.println(i.getClass().getName());
        i.fun();
    }
}
