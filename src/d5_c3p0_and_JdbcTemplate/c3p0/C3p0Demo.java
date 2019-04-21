package d5_c3p0_and_JdbcTemplate.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import d4_shiwu_jdbc.jdbc.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName:C3p0Demo1
 * @Description TODO  使用c3p0创建连接池对象调用默认的xml配置文件文件名必须为c3p0-config.xml 并且必须放在src目录下
 * @author:RanMoAnRan
 * @Date:2019/4/21 19:17
 * @Version 1.0
 */
public class C3p0Demo {
    @Test
    public void query() {
        //创建c3p0核心类对象
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //获取连接对象
            conn = cpds.getConnection();
            //System.out.println(conn);
            String sql = "select * from user";
            pstm = conn.prepareStatement(sql);
            //调用查询方法
            rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs,pstm,conn);
        }
    }

    @Test
    public void update(){
        Connection connection=null;
        PreparedStatement pstm=null;
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            connection = cpds.getConnection();
            String sql="update user set username=? where id=?";
            pstm = connection.prepareStatement(sql);
            //给占位符？赋值
            pstm.setString(1,"杨素");
            pstm.setInt(2,1);
            //调用修改方法，返回影响的行数
            int sum = pstm.executeUpdate();
            if (sum>0) {
                System.out.println("修改成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstm,connection);
        }
    }
}
