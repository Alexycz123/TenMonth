import com.ycz.pojo.Travel;
import com.ycz.pojo.User;
import com.ycz.pojo.UserCollect;
import com.ycz.service.TravelService;
import com.ycz.service.UserCollectService;
import com.ycz.service.UserService;
import com.ycz.utils.DBUtil;
import com.ycz.utils.GetDatasourceUtils;
import com.ycz.utils.SpringBeanFactory;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TestMysql {

    @Test
    public void addUser() throws Exception {
        UserService userService= (UserService)
                SpringBeanFactory.getBean("UserServiceImpl");
        User user=new User();
        user.setName("hh");
        user.setPwd("12312312");
        user.setPhone("21231");
        int rs = userService.addUser(user);
        if (rs==0){
            System.out.println("不成功");
        }else {
            System.out.println("成功");
        }

    }

    @Test
    public void selectUser() throws Exception {
        UserService userService= (UserService)
                SpringBeanFactory.getBean("UserServiceImpl");

        User user = userService.selectUser(1);
        System.out.println(user);
    }

    @Test
    public  void addTravel() throws Exception {
        TravelService travelService= (TravelService)
                SpringBeanFactory.getBean("TravelServiceImpl");
        Travel travel=new Travel();
        travel.setName("广科");
        travel.setAddress("东莞");
        int rs = travelService.addTravel(travel);
        if (rs==0){
            System.out.println("不成功");
        }else {
            System.out.println("成功");
        }
    }

    @Test
    public void addUserCollect() throws Exception {
        UserCollectService collectService= (UserCollectService)
                SpringBeanFactory.getBean("UserCollectServiceImpl");
        UserCollect userCollect=new UserCollect();
        userCollect.setUserId(2);
        userCollect.setTravelId(1);
        int rs = collectService.addUserCollect(userCollect);
        if (rs==0){
            System.out.println("不成功");
        }else {
            System.out.println("成功");
        }
    }

    @Test
    public void selectAll() throws Exception {
        UserService userService= (UserService)
                SpringBeanFactory.getBean("UserServiceImpl");

        List<User> userList= userService.selectAll();
        System.out.println(userList);
    }

    @Test
    public void t3(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate(GetDatasourceUtils.getC3p0());
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("select * from user");

        //jdbcTemplate.execute();


        List<User> query = jdbcTemplate.query(
                "select * from user where id=?", new BeanPropertyRowMapper<>(User.class), 2
        );
        System.out.println(query);

        Map<String, Object> map = jdbcTemplate.queryForMap(
                "select  * from user where id=?", 1
        );
        System.out.println(map);

        System.out.println(mapList);
//        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid);

    }

}
