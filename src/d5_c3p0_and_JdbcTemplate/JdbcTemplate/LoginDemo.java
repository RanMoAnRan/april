package d5_c3p0_and_JdbcTemplate.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

/**
 * @ClassName:LoginDemo
 * @Description TODO
 * @author:RanMoAnRan
 * @Date:2019/4/21 21:53
 * @Version 1.0
 */
public class LoginDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(new ComboPooledDataSource());
        User user =null;
        try {
            user = jdbcTemplate.queryForObject("select * from user where username=? and password=?", new BeanPropertyRowMapper<>(User.class), username, password);
        } catch (DataAccessException e) {
            System.out.println("账号或密码错误");
        }
        if (user!=null) {
            System.out.println("恭喜 "+user.getNickname() +" 登陆成功");
        }else {
            System.out.println("登陆失败");
        }

    }

}
