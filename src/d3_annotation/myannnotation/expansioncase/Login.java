package d3_annotation.myannnotation.expansioncase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

//登陆测试类
public class Login {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {

        //获取用户信息到userlist
        ArrayList<User> userlist = DBUtils.getList();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的用户名");
        String username = scanner.nextLine();
        System.out.println("请输入你的密码");
        String password = scanner.nextLine();

        User user = null;

        for (User user1 : userlist) {
            if (user1.getName().equals(username) && user1.getPwd().equals(password)) {
                user = user1;

            }
        }

        if (user != null) {
            System.out.println("欢迎" + user.getNickname() + "登陆成功");

            while (true) {
                System.out.println();
                System.out.println("请输入对应的内容来完成某个功能");
                System.out.println("publishlog:发表日志 publishTalk:发表说说 lookPhoto:查看女神相册 lookMessage:查看女生留言板 deleteLook:删除浏览记录 exit:退出");

                String choose = scanner.nextLine();

                if (choose.equals("exit")) {
                    break;
                } else {

                    //通过反射调用方法

                    Method method = null;
                    try {
                        Class<?> clazz = Class.forName("d3_annotation.myannnotation.expansioncase.QQFunction");
                        Object instance = clazz.newInstance();
                        method = clazz.getMethod(choose);

                        //通过注解获取用户权限

                        //判断是否有注解
                        if (method.isAnnotationPresent(Anno.class)) {
                            //得到注解类
                            Anno annotation = method.getAnnotation(Anno.class);
                            //获取注解值
                            String value = annotation.value();
                            if (user.getList().contains(value)) {
                                method.invoke(instance);
                            } else {
                                System.out.println("你没有权限访问此功能");
                            }
                        }

                    } catch (NoSuchMethodException e) {
                        System.out.println("没有你选择的功能，请重新输入");
                    }

                }

            }

        } else {
            System.out.println("登陆失败");
        }

    }
}
