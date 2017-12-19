package com.bee.fetch.service;

import com.bee.fetch.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by liangbe on 2017/12/13.
 */

public interface UserService  extends CRUDService<User,Long>{

    User findByName(String name);
}
