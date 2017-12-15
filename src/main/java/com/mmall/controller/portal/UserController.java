package com.mmall.controller.portal;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2017/12/15 22:22
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value="login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User>  login(String username, String password, HttpSession session){
        ServerResponse<User> result = userService.login(username, password);
        if(result.isSuccess()){
            User user = result.getData();
            session.setAttribute("user", user);
        }
        return result;
    }
}
