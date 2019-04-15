package d2_fansheandproxy.mybeanutils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class MyBeanUtilsDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Student student = new Student();
        BeanUtils.setProperty(student,"name","靖哥");
        String name = BeanUtils.getProperty(student, "name");
        System.out.println(name);
        System.out.println("---------------");


        //BeanUtils中的populate方法  直接将整个Map集合中所有的数据 赋值到一个bean对象中
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","靖哥");
        map.put("age",20);
        BeanUtils.populate(student,map);
        System.out.println(student.getName()+"---"+student.getAge());
    }
}
