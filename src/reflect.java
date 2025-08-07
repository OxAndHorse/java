package src;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflect {

    public static void main(String []agrs) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //传入包路径
        Class<?> testClass=Class.forName("src.testClass");
//        testClass testClass1=testClass.newInstance();
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Method method=testClass.getDeclaredMethod("test1", String.class);
        method.invoke(testClass.newInstance(),"invoke调用");

//        System.out.println(testClass.getClass().getName());
    }
}
