package d2_fansheandproxy.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("周芷若", 123456);
        properties.put("张柏芝", 123456);
        properties.put("张无忌", 123456);
        properties.put("赵敏", 123456);

        //方式一
        Set<Object> keySet = properties.keySet();
        for (Object key : keySet) {
            System.out.println(key + "-------" + properties.get(key));
        }
        System.out.println("--------------------");

        //方式二
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + "----" + entry.getValue());
        }
        System.out.println("--------------------");
        properties.setProperty("黄蓉", "郭靖");
        String s1 = properties.getProperty("黄蓉");
        System.out.println(s1);

        System.out.println("------------");
        //测试读取文件
        Properties ps = new Properties();
        try {
            //将文件中的键值对读取到ps集合中
            ps.load(new FileReader("a.txt"));
            //获取ps中的所有key
            Set<String> keys = ps.stringPropertyNames();
            for (String key : keys) {
                System.out.println(key+"----"+ps.getProperty(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //写入文件
        /*try {
            ps.store(new FileWriter("a.properties"),"靖哥=丫头");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
