package d5_c3p0_and_JdbcTemplate.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JSONUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:JdbcTemplateQueryDemo
 * @Description TODO
 * @author:RanMoAnRan
 * @Date:2019/4/21 20:26
 * @Version 1.0
 */
public class JdbcTemplateQueryDemo {

    //查询一条记录封装成 Map集合
    @Test
    public void queryForMapTest() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from employee where id=?", 1);
        System.out.println(map);
    }


    //查询一条记录封装成javaBean对象
    @Test
    public void queryForObjectTest() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        User user = jdbcTemplate.queryForObject("select * from user where id=?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                int id = resultSet.getInt("id");
                user.setId(id);
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                user.setAge(resultSet.getInt("age"));

                return user;
            }
        }, 1);
        System.out.println(user);
    }


    //查询一条记录封装成 Bean
    @Test
    public void queryForObjectTest02() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        User user = jdbcTemplate.queryForObject("select * from user where id=?", new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }

    //查询多条记录封装Bean
    @Test
    public void query() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        List<User> userList = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        //将list对象转换为json格式
        String s = JSONUtils.toJSONString(userList);
        System.out.println(userList);
        System.out.println(s);
    }

    //查询一列数据封装成 List
    @Test
    public void query02() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        List<String> list = jdbcTemplate.queryForList("select username from user", String.class);
        System.out.println(list);
    }


    //查询多列数据封装成List
    @Test
    public void query03() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select id, username,nickname,age from user");
        System.out.println(list);
    }

    //查询所有数据封装成 List<Map<String,Object>>
    @Test
    public void query04() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        System.out.println(list);
    }

    //聚合函数
    @Test
    public void query05() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        Integer sum = jdbcTemplate.queryForObject("select count(*) from user", int.class);
        System.out.println(sum);
    }
}
