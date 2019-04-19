package d4_shiwu_jdbc.jdbc;

import utils.JSONUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest2 {
    //查询所有的用户类，封装成List<User>返回
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List<User> list =new ArrayList<>();
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
                //将user添加到集合中
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(pstm, conn);
        }

        //将list对象转化为json格式
        String jsonlist = JSONUtils.toJSONString(list);
        System.out.println(jsonlist);

    }
}
