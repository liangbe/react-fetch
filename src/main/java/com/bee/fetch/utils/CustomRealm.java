package com.bee.fetch.utils;

import com.bee.fetch.dao.UserDao;
import com.bee.fetch.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangbe on 2017/12/15.
 */
public class CustomRealm {

    /****
     * 通过用户名获取用户对象
     *
     * @param username
     * @return
     */
    // 公共的数据库访问接口
    // 这里省略BaseDao dao的编写
    @Autowired
    private UserDao userDao;

    public User getUserByUserName(String username) {
        User user =  userDao.getOne(Long.getLong("1"));
        return user;
    }

    /***
     * 通过用户名获取权限资源
     *
     * @param username
     * @return
     */
    public List<String> getPermissionsByUserName(String username) {
        System.out.println("调用");
        User user = getUserByUserName(username);
        if (user == null) {
            return null;
        }
        List<String> list = new ArrayList<String>();
        // System.out.println(user.getUserRoles().get(0).get);

        return list;
    }


}
