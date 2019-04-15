package d3_annotation.myannnotation;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("d3_annotation.myannnotation.MyAnnotationDemo");
        clazz.newInstance();
        Method method = clazz.getMethod("method");

        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            String name = annotation.name();
            int value = annotation.value();
            System.out.println(name+"----"+value);
        }

    }
}
