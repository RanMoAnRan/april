package d2_fansheandproxy.fanshe;

import java.lang.reflect.Field;

public class ReflectFieldDemo {
    //字段操作
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //访问公共的字段
        //创建字节码对象
        Class<?> clazz = Class.forName("d2_fansheandproxy.fanshe.Student");
        //创建对象
        Object stu = clazz.newInstance();
        //创建字段所在对象
        Field namefield = clazz.getField("name");
        namefield.set(stu,"靖哥");
        System.out.println(namefield.get(stu));

        //访问私有的字段
        Field agefield = clazz.getDeclaredField("age");
        //暴力访问
        agefield.setAccessible(true);
        agefield.set(stu,18);
        System.out.println(agefield.get(stu));
    }
}
