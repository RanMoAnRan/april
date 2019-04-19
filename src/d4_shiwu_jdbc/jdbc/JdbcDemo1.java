package d4_shiwu_jdbc.jdbc;

import java.sql.*;

//此方法用的是Statement 存在sql注入隐患
@SuppressWarnings("all")
public class JdbcDemo1 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            //加载maysql驱动（可以不写）驱动包中有一个静态代码注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbctest", "root", "root");

            //创建Statement对象
            stm = conn.createStatement();
            String sql = "select * from user";
            //执行sql，得到一个结果集
            rs = stm.executeQuery(sql);
            //遍历结果集
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                int age = rs.getInt("age");
                System.out.println(id + "---" + username + "---" + password + "---" + nickname + "---" + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }


    }
}
