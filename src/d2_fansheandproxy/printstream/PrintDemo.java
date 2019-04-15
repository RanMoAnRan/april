package d2_fansheandproxy.printstream;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintDemo {
    public static void main(String[] args) throws IOException {
        //打印字符流
        PrintWriter pw = new PrintWriter("b.txt");
        pw.println("天王盖地虎");
        pw.println("提莫一米五");
        pw.write("小鸡炖蘑菇");
        pw.flush();
        pw.close();

        System.out.println("-----------");
        //打印字节流
        PrintStream ps = new PrintStream("b.txt");
        ps.println("哈哈哈哈");
        byte[] bytes={97,98,99};
        ps.write(bytes);
        ps.flush();
        ps.close();
    }

}
