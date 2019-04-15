package d2_fansheandproxy.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectConstructorDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //创建字节码对象
        Class<?> clazz = Class.forName("d2_fansheandproxy.fanshe.Student");
        //获取全部构造方法
       /* Constructor<?>[] constructors = clazz.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor<?> constructor = constructors[i];
            System.out.println(constructor);
        }*/
        //获取想要的构造方法
        //无参构造
        Constructor<?> constructor = clazz.getConstructor();
        System.out.println(constructor);
        //创建对象
        Object stu = constructor.newInstance();
        System.out.println(stu);

        //有参构造私有
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);//私有的
        System.out.println(declaredConstructor);
        //私有暴力访问
        declaredConstructor.setAccessible(true);
        //创建对象
        Object jing = declaredConstructor.newInstance("靖哥", 18);
        System.out.println(jing);

    }
}
