package com.bee.fetch.controller;

import com.bee.fetch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liangbe on 2017/12/13.
 */
@Controller
@RequestMapping("/")
public class testController {

    @Autowired
    UserService  userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login() {
        return "login";
    }


}
