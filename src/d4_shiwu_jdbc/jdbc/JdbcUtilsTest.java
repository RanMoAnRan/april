package d4_shiwu_jdbc.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

//jdbc工具类测试类
@SuppressWarnings("all")
public class JdbcUtilsTest {
    @Test
    public void add() {
        Connection conn = null;
        Statement stm = null;
        try {
            conn = JdbcUtils.getConnection();
            //System.out.println(conn);
            stm = conn.createStatement();
            String sql = "insert into user values(null,'靖哥','123456','姚靖',18)";
            //返回的是执行成功语句的数量
            int num = stm.executeUpdate(sql);
            if (num > 0) {
                System.out.println("添加语句成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(stm, conn);
        }
    }

    @Test
    public void delete() {
        Connection conn = null;
        Statement stm = null;
        try {
            conn = JdbcUtils.getConnection();
            //System.out.println(conn);
            stm = conn.createStatement();
            String sql = "delete from user where id='6'";
            //返回的是执行成功语句的数量
            int num = stm.executeUpdate(sql);
            if (num > 0) {
                System.out.println("删除语句成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(stm, conn);
        }

    }

    @Test
    public void update() {
        Connection conn = null;
        Statement stm = null;
        try {
            conn = JdbcUtils.getConnection();
            //System.out.println(conn);
            stm = conn.createStatement();
            String sql = "update user set username='丫头' where id='3'";
            //返回的是执行成功语句的数量
            int num = stm.executeUpdate(sql);
            if (num > 0) {
                System.out.println("修改语句成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(stm, conn);
        }

    }

    @Test
    public void query() {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            stm = conn.createStatement();
            String sql = "select * from user";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                String rsInt = rs.getString(4);
                System.out.println(rsInt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, stm, conn);
        }
    }

    //上面的都是Statement操作，存在sql注入安全
    //下面测试一个用PreparedStatement方法解决安全问题
    @Test
    public void PreparedStatementTest() {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //创建连接对象
            conn = JdbcUtils.getConnection();
            String sql = "update user set username=? where id=?";//  ?代表占位符 从左到右一次为 1，2，3...
            //预编译sql
            pstm = conn.prepareStatement(sql);
            //设置参数
            pstm.setString(1, "张三");
            pstm.setInt(2, 2);
            //运行sql，返回执行成功的行数
            int num = pstm.executeUpdate();
            if (num > 0) {
                System.out.println("修改数据成功");
            } else {
                System.out.println("修改数据失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JdbcUtils.close(pstm, conn);
        }
    }
}
