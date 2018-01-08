package com.bee.fetch.controller;

import com.bee.fetch.entity.User;
import com.bee.fetch.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liangbe on 2017/12/13.
 */
@Controller
@RequestMapping("/")
public class testController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login() {
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index() {
        return "index";
    }

    @RequestMapping(value = "/getSession", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> GetSession() {

        Map<String, Object> responseMap = new HashMap<>();
        Object user=SecurityUtils.getSubject().getSession().getAttribute("user");
        responseMap.put( "state",user==null?false:true);
        responseMap.put( "user",user);
        return responseMap;
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> DoLogin(HttpServletRequest request, ModelMap modelMap) throws Exception {

        String username = request.getParameter("username");
        String password =request.getParameter("password");
        Map<String, Object> responseMap = new HashMap<>();
        String message="Login successfully!";
            try {
                //使用shiro管理登录
                Subject subject = SecurityUtils.getSubject();
                subject.login(new UsernamePasswordToken(username, password));//登录失败会产生异常


            } catch (UnknownAccountException | IncorrectCredentialsException e) {
                message="用户名/密码错误";
            } catch (ExcessiveAttemptsException e) {

                message="帐号已被锁定";
            } catch (AuthenticationException e) {
                message=e.getMessage();
            }
        responseMap.put("massage", message);
        return responseMap;
    }



}
