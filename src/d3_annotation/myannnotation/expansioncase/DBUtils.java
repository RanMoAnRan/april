package d3_annotation.myannnotation.expansioncase;
import java.util.ArrayList;

//添加用户类
@SuppressWarnings("all")
public class DBUtils {

    public static ArrayList<User> getList() {
        ArrayList<User> list=new ArrayList<>();

        User user = new User();
        user.setNickname("我是一只鱼");
        user.setName("admin");
        user.setPwd("123456");

        //给用户添加权限
        ArrayList<String> list1=new ArrayList<>();
        list1.add("publishlog");
        list1.add("publishTalk");
        list1.add("lookPhoto");
        list1.add("lookMessage");
        list1.add("deleteLook");
        user.setList(list1);

        list.add(user);

        User user1 = new User();
        user1.setNickname("我是一颗糖、甜到忧伤");
        user1.setName("test");
        user1.setPwd("123456");

        //给用户添加权限
        ArrayList<String> list2=new ArrayList<>();
        list2.add("lookMessage");
        list2.add("publishlog");
        user1.setList(list2);

        list.add(user1);

        User user2 = new User();
        user2.setNickname("当爱已成往事");
        user2.setName("yaya");
        user2.setPwd("123456");

        //给用户添加权限
        ArrayList<String> list3=new ArrayList<>();
        list3.add("lookMessage");
        list3.add("lookPhoto");
        user2.setList(list3);

        list.add(user2);

        return list;
    }

}
