package d2_fansheandproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        //创代被代理对象
        ZhongJie people = new ZhongJie();
        //创建类加载器
        ClassLoader loader = people.getClass().getClassLoader();
        //创建被代理对象所实现的接口
        Class<?>[] interfaces = people.getClass().getInterfaces();
        //调用代理方法，返回一个指定接口的代理类实例
        StudyClass studyClass = (StudyClass) Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = null;
                String name = method.getName();
                if ("dance".equals(name)) {
                    System.out.println("中介费100");
                    invoke = method.invoke(people,args[0]);
                } else if ("sing".equals(name)) {
                    System.out.println("中介费200");
                    invoke = method.invoke(people,args);
                } else {
                    System.out.println("中介费500");
                    invoke = method.invoke(people,args);
                }

                return invoke;
            }
        });

        studyClass.dance(1000);
        studyClass.sing(2000);
        studyClass.lol(5000);

    }
}
