package com.bee.fecth;

//import com.bee.fetch.service.UserService;
//import com.bee.fetch.utils.MyShiroRealm;
import com.bee.fetch.entity.Household;
import com.bee.fetch.entity.Property;
import com.bee.fetch.entity.User;
import com.bee.fetch.service.HouseholdService;
import com.bee.fetch.service.PropertyService;
import com.bee.fetch.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by liangbe on 2017/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"
//        , "classpath*:applicationContext-shiro-test.xml"
})
public class test {


    @Autowired
    UserService userService;

    @Autowired
    HouseholdService householdService;

    @Autowired
    PropertyService propertyService;


//    @Test
//    public void testMain() {
//        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
//         Factory<SecurityManager> factory =new IniSecurityManagerFactory("classpath:55.ini");
//        //2、得到SecurityManager实例 并绑定给SecurityUtils
//        SecurityManager securityManager = factory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);
//        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
//        try {
//            //4、登录，即身份验证
//            subject.login(token);
//        } catch (AuthenticationException e) {
//            //5、身份验证失败
//        }
//        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
//        //6、退出
//        subject.logout();
//    }
//    @Autowired
//    private DefaultSecurityManager securityManager;

//    @Test
//    public  void dologin(){
//    /**    以下是不行的方法
//        //初始化SecurityManager 全局管理组件
//        DefaultSecurityManager securityManager= new DefaultSecurityManager();
//        //设定信息验证器和权限认证器
//       securityManager.setRealm(new MyShiroRealm());
//     */
//
//        SecurityUtils.setSecurityManager(securityManager);
//        String username = "yingting23333";
//        String password = "123457";
//        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.login(new UsernamePasswordToken(username, password));
//        } catch (UnknownAccountException | IncorrectCredentialsException e) {
//            System.out.println("用户名/密码错误");
//        } catch (ExcessiveAttemptsException e) {
//            System.out.println("帐号已被锁定");
//        }catch (AuthenticationException e) {
//            System.out.println("unknown");
//        }
//    }


//    @Test
//    public  void findUser(){
//        User user =new User();
//        user.setId(1L);
//        user.setName("颜定添");
//        user.setPassword("123456");
//        user.setPhoneNum("123456789");
//        userService.save(user);

//    }
//      @Test
//      public  void household(){
//
//          User houseOwner=userService.findByName("张淑玲");
//          List<User> users=new ArrayList<User>();
//
//          User user1=userService.findOne(1L);
//          User user2=userService.findOne(2L);
//          User user3=userService.findOne(3L);
//          User user4=userService.findOne(4L);
//
//          users.add(user1);
//          users.add(user2);
//          users.add(user3);
//          users.add(user4);
//
//          Household household=new Household();
//          household.setFloor(13);
//          household.setNumber(1);
//          household.setRoomNum("1301");
//          household.setArea(156.30f);
//          household.setHouseOwner(houseOwner);
//          household.setUserList(users);
//
//
//          householdService.save(household);
//
//      }

    @Test
    public  void property(){
        List<User> users=new ArrayList<User>();
        User user1=userService.findOne(5L);
        User user2=userService.findOne(6L);
        User user3=userService.findOne(7L);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        Property property=new Property();
        property.setName("东平物业");
        property.setUserList(users);

        propertyService.save(property);






    }
}
