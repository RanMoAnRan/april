package d4_shiwu_jdbc.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//jdbc封装类
@SuppressWarnings("all")
public class JdbcUtils {
    private static final String DRIVERCLASS;
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        //将配置文件中的内容加载到内存中
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVERCLASS = properties.getProperty("driverclass");
        URL = properties.getProperty("url");
        USER = properties.getProperty("user");
        PASSWORD = properties.getProperty("password");
    }

    //加载驱动
    public static void loadDriver() {
        try {
            Class.forName(DRIVERCLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //创建连接
    public static Connection getConnection() {
        Connection conn=null;
        try {
            loadDriver();
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //释放资源
    public static void close(Statement stm, Connection conn) {
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

    //关闭资源重载
    public static void close(ResultSet rs, Statement stm, Connection conn) {
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
