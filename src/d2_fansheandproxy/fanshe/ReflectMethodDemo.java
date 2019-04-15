package d2_fansheandproxy.fanshe;

import java.lang.reflect.Method;

public class ReflectMethodDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("d2_fansheandproxy.fanshe.Student");
        Object stu = clazz.newInstance();
        //访问公共的方法
        Method getName = clazz.getMethod("getName");
        Method setName = clazz.getMethod("setName", String.class);
        Object o = setName.invoke(stu, "靖哥");
        System.out.println(getName.invoke(stu));

        //访问私有方法

        Method getAge = clazz.getDeclaredMethod("getAge");
        Method setAge = clazz.getDeclaredMethod("setAge", int.class);
        //暴力访问
        getAge.setAccessible(true);
        setAge.setAccessible(true);
        setAge.invoke(stu,18);
        System.out.println(getAge.invoke(stu));

    }
}
