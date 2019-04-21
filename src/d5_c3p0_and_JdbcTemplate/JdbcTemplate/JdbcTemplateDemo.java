package d5_c3p0_and_JdbcTemplate.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:JdbcTemplateDemo
 * @Description TODO   JdbcTemplate实现增删改查功能
 * @author:RanMoAnRan
 * @Date:2019/4/21 19:48
 * @Version 1.0
 */
public class JdbcTemplateDemo {
    //创建表   DDL语句
    @Test
    public void createTable() {
        //创建连接池
        DataSource cpds = new ComboPooledDataSource();
        //将连接池对象传给JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(cpds);
        String sql = "create table employee(" +
                "id int primary key auto_increment," +
                "name varchar(20)," +
                "gender varchar(2)," +
                "birthday date)";
        //执行sql
        jdbcTemplate.execute(sql);
    }


    //DML语句增删改
    @Test
    public void insert() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        jdbcTemplate.update("insert into employee values (null, ?,?,?)", "孙悟空", "男", "1999-12-10");
        jdbcTemplate.update("insert into employee values (null, ?,?,?)", "孙悟天", "男", "1999-12-10");
        jdbcTemplate.update("insert into employee values (null, ?,?,?)", "孙悟饭", "男", "1999-12-10");
        jdbcTemplate.update("insert into employee values (null, ?,?,?)", "龟仙人", "男", "1999-12-10");
        jdbcTemplate.update("insert into employee values (null, ?,?,?)", "牛魔王", "男", "1999-12-10");
        jdbcTemplate.update("insert into employee values (null, ?,?,?)", "18号", "女", "1997-12-10");
    }

    @Test
    public void update() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        String sql = "update employee set name=?, birthday=? where id=?";
        int sum = jdbcTemplate.update(sql, "靖哥", "2000-12-01", 1);
        if (sum > 0) {
            System.out.println("修改成功");
        }
    }

    @Test
    public void delete() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        int row = jdbcTemplate.update("delete from employee where id=?", 6);
        System.out.println("删除" + row + "行记录");
    }

    //DQL语句查询
    @Test
    public void query() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        List<Map<String, Object>> employeelist = jdbcTemplate.queryForList("select * from employee");
        List<User> userList = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(employeelist);
        System.out.println(userList);
    }
}
