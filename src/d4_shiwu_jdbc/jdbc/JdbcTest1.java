package d4_shiwu_jdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@SuppressWarnings("all")
public class JdbcTest1 {
    //使用PreparedStatement查询一条数据，封装成一个User对象
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user";
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                User user = new User();
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                int age = rs.getInt("age");
                //将查询的数据添加到user中
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                user.setNickname(nickname);
                user.setAge(age);
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(pstm, conn);
        }

    }
}
