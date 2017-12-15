package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2017/12/15 22:27
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);
}
