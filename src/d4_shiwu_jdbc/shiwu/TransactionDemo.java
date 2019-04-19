package d4_shiwu_jdbc.shiwu;

import d4_shiwu_jdbc.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//jdbc事务操作
public class TransactionDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbctest", "root", "root");

            //设置自动提交为false,相当于开启了事务
            //两个sql要么同时执行成功，要么同时失败回滚
            conn.setAutoCommit(false);
            //创建带参的sql，sql可以重用，提高代码的复用性
            String sql = "update user set age=age+? where id=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, 10);
            pstm.setInt(2, 1);
            pstm.executeUpdate();

            pstm.setInt(1, -10);
            pstm.setInt(2, 2);
            pstm.executeUpdate();

            //提交事务
            conn.commit();
            System.out.println("修改成功");
        } catch (Exception e) {
            try {
                //如果执行sql语句时出现错误则回滚事务
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close(pstm,conn);
        }

    }
}
