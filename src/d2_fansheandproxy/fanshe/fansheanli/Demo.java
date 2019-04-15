package d2_fansheandproxy.fanshe.fansheanli;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        //创建Properties对象
        Properties ps = new Properties();
        //将文件加载到Properties中
        ps.load(new FileReader("a.properties"));
        //根据健获取值
        String path = ps.getProperty("path");

        //创建字节码对象
        Class<?> clazz = Class.forName(path);
        //创建对象
        Object animal = clazz.newInstance();
        //获取方法
        Method eat = clazz.getMethod("eat");
        //调用方法
        eat.invoke(animal);
    }
}
