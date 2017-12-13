package com.bee.fetch.service.impl;

import com.bee.fetch.dao.UserDao;
import com.bee.fetch.entity.User;
import com.bee.fetch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liangbe on 2017/12/13.
 */
public class UserServiceImpl  extends CRUDServiceImpl<User,Long> implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDao getDao() {
        return userDao;
    }
}
