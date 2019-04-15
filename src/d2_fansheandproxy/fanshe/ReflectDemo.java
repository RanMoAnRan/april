package d2_fansheandproxy.fanshe;

public class ReflectDemo {
    //反射的前提创建字节码对象

    //1. 反射不仅可以操作公共的方法属性构造方法还可操作私有的
    //2. 使用反射这种方式更加灵活 有助于我们对代码进行解耦
    // 反射:在代码运行期间创建对象 操作成员的一种方式
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Student stu = new Student();
        //方式一
        Class<? extends Student> clazz = stu.getClass();
        System.out.println(clazz);
        //方式二
        Class<Student> clazz2 = Student.class;
        System.out.println(clazz2);
        //方式三
        try {
            Class<?> clazz3 = Class.forName("d2_fansheandproxy.fanshe.Student");
            System.out.println(clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
