package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2017/12/15 22:29
 */
public class UserServiceImple implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUsername(username);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        User user  = userMapper.selectLogin(username, password);

        return ServerResponse.createBySuccess(user);
    }
}
