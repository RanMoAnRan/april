package d5_c3p0_and_JdbcTemplate.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import d4_shiwu_jdbc.jdbc.JdbcUtils;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @ClassName:DruidDemo
 * @Description TODO  druid连接池联系
 * @author:RanMoAnRan
 * @Date:2019/4/21 20:34
 * @Version 1.0
 */
public class DruidDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Properties properties = new Properties();
        try {
            //加载配置文件
            properties.load(new FileReader("druid-config.properties"));
            //创建datasource连接池
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            conn = dataSource.getConnection();
            String sql = "select * from user where id=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, 1);
            rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstm, conn);
        }
    }
}
