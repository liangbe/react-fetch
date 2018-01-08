package com.bee.fetch.utils;

import com.bee.fetch.entity.User;
import com.bee.fetch.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liangbe on 2017/12/15.
 */
public class MyShiroRealm extends AuthorizingRealm {

    /***
     * 获取授权信息
     *
     *
     */


    /**用户的业务类**/
    @Resource
    private UserService userService;
// 一定要完整写完两个方法的返回值不能为空
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {

        Set<String> roleNames = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        roleNames.add("administrator");//添加角色
        permissions.add("newPage.jhtml");  //添加权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }
    /***
     * 获取认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) at;
        // 通过表单接收的用户名
        Subject currentUser = SecurityUtils.getSubject();
        String username = token.getUsername();
        if (username != null && !"".equals(username)) {
            User user = userService.findByName(username);
            if (user != null) {
                Session session = currentUser.getSession();
                session.setAttribute("user", user);
                return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
            }
        }

        return null;
    }



}
